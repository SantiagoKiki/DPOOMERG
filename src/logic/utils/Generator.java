package logic.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import logic.persistencia.CentralPersistencia;

public class Generator implements Serializable {

    private static final long serialVersionUID = 1L;

    private static Generator instance = null;
    public transient static CentralPersistencia centralPersistencia = new CentralPersistencia();

    private final HashMap<String, LinkedList<String>> db = new HashMap<>();

    private Generator() {
        db.put("Activity", new LinkedList<>());
        db.put("LearningPath", new LinkedList<>());
    }
    
    public static synchronized Generator getInstance() {
        if (instance == null) {
            instance = new Generator();
        }
        return instance;
    }

    private String nanoid(int length) {
        char[] characters = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            result.append(characters[ThreadLocalRandom.current().nextInt(characters.length)]);
        }
        return result.toString();
    }

    private String interleave(String s1, String s2) {
        StringBuilder result = new StringBuilder(s1.length() + s2.length());
        int minLength = Math.min(s1.length(), s2.length());

        for (int i = 0; i < minLength; i++) {
            result.append(s1.charAt(i)).append(s2.charAt(i));
        }

        if (s1.length() > minLength) {
            result.append(s1.substring(minLength));
        } else if (s2.length() > minLength) {
            result.append(s2.substring(minLength));
        }

        return result.toString();
    }

    private boolean existsInDatabase(String type, String id) {
        LinkedList<String> typeList = db.get(type);
        return typeList != null && typeList.contains(id);
    }

    private String checkId(String type, String id) {
        while (existsInDatabase(type, id)) {
            int l = type.length() + (int) Math.ceil(type.length() / 2.0);
            id = interleave(type, nanoid(l));
        }
        return id;
    }

    public synchronized String generateId(String type) {
        int l = type.length() + (int) Math.ceil(type.length() / 2.0);
        String id = interleave(type, nanoid(l));
        String finalId = checkId(type, id);

        db.get(type).add(finalId);

        return finalId;
    }

    public void guardarInfo() {
        centralPersistencia.guardar2(db);
    }
}
