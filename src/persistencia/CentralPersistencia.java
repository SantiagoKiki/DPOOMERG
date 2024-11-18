package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

import controller.StudentController;
import learningpath.LearningPath;

public class CentralPersistencia {

	private static final long serialVersionUID = 1L;
	
    public void guardarStudent(StudentController studentController) {
        String path = "./Data/students.ser"; 
        File directory = new File("./Data/");
        if (!directory.exists()) {
            directory.mkdirs(); 
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(studentController);
        } catch (IOException e) {
            System.err.println("Error al guardar " + path + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void guardar2(Serializable object) {
        String path = "./Data/database.ser"; 
        File directory = new File("./Data/");
        if (!directory.exists()) {
            directory.mkdirs(); 
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(object);
        } catch (IOException e) {
            System.err.println("Error al guardar " + path + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Object cargar() {
        String path = "./Data/database.ser"; 
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading object from " + path + ": " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public Object cargarStudent() {
        String path = "./Data/students.ser"; 
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading object from " + path + ": " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

	public void guardar2(HashMap<String, String> usersDataBase) {
		 String path = "./Data/database.ser"; 
	        File directory = new File("./Data/");
	        if (!directory.exists()) {
	            directory.mkdirs(); 
	        }

	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
	            oos.writeObject(usersDataBase);
	        } catch (IOException e) {
	            System.err.println("Error al guardar " + path + ": " + e.getMessage());
	            e.printStackTrace();
	        }
		
	}
}
