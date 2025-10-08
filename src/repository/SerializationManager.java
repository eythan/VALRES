package repository;

import java.io.*;
import java.util.List;

public class SerializationManager {

    // Sérialiser une liste d’objets dans un fichier
    public static <T> void saveList(List<T> list, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(list);
            System.out.println("Fichier sauvegardé : " + filePath);
        }
    }

    // Charger une liste d’objets depuis un fichier
    public static <T> List<T> loadList(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<T>) ois.readObject();
        }
    }
}
