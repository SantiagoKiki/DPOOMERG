package utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Generator {

	private static Generator instance = null;
	private final HashMap<String, LinkedList<String>> db = new HashMap<>();

	private Generator() {
		db.put("Activity", new LinkedList<>());
		db.put("LearningPath", new LinkedList<>());
	}
	
	public static Generator getInstance() {
		if (instance == null) {
			instance = new Generator();
		}
		return instance;
	}
	
	public static void deleteInstance() {
		instance = null;
	}

	private String nanoid(String input) {
		int length = input.length();
		String san = input.replace("\\W", "");

		int randomLength = Math.max(0, length - san.length());
		StringBuilder randomP = new StringBuilder();
		Random rand = new Random();

		for (int i = 0; i < randomLength; i++) {
			randomP.append((char) (rand.nextInt(36) + 'a'));
		}

		return (san + randomP.toString()).substring(0, length);
	}

	private String interleave(String s1, String s2) {
		StringBuilder result = new StringBuilder();
		int i = 0;
		int j = 0;

		while (i < s1.length() && j < s2.length()) {
			result.append(s1.charAt(i++));
			result.append(s2.charAt(j++));
		}

		result.append(s1.substring(i));
		result.append(s2.substring(j));

		return result.toString();
	}

	private boolean existsInDatabase(String type, String id) {
		if (type == null) {
			System.err.println("Type can not be null");
			return false;
		}

		if (id == null) {
			System.err.println("Id can not be null");
			return false;
		}
		LinkedList<String> typeList = this.db.get(type);
		if (typeList == null) {
			System.err.println("Invalid type \"" + type + "\"");
			return false;
		}

		return typeList.contains(id);
	}

	private String checkId(String type, String id) {
		boolean exists = this.existsInDatabase(type, id);

		if (!exists) {
			return id;
		}

		int l = type.length() + (int) Math.floor(type.length() / 2.0);
		String newId = this.interleave(type, this.nanoid(Integer.toString(l)));
		return checkId(type, newId);
	}

	public String generateId(String type) {
		int l = type.length() + (int) Math.floor(type.length() / 2.0);
		String id = interleave(type, nanoid(Integer.toString(l)));
		String finalId = checkId(type, id);

		if (!existsInDatabase(type, finalId)) {
			db.get(type).add(finalId);
		}

		return finalId;
	}
}
