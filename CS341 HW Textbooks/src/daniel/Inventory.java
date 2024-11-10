package daniel;

import java.io.*;
import java.util.LinkedList;

public class Inventory {
    private LinkedList<Textbook> textbooks;
    private final String FILE_NAME = "inventory.dat";

    public Inventory() {
        textbooks = new LinkedList<>();
        loadInventory();
    }

    public void addTextbook(int sku, String title, double price, int quantity) {
        if (price <= 0 || quantity < 0) {
            System.out.println("Invalid price or quantity.");
            return;
        }

        for (Textbook textbook : textbooks) {
            if (textbook.sku == sku) {
                System.out.println("Textbook with SKU " + sku + " already exists.");
                return;
            }
        }

        textbooks.add(new Textbook(sku, title, price, quantity));
        saveInventory();
        System.out.println("Textbook added successfully.");
    }

    public void removeTextbook(int sku) {
        for (Textbook textbook : textbooks) {
            if (textbook.sku == sku) {
                textbooks.remove(textbook);
                saveInventory();
                System.out.println("Textbook removed successfully.");
                return;
            }
        }
        System.out.println("Textbook with SKU " + sku + " not found.");
    }

    public void displayTextbook(int sku) {
        for (Textbook textbook : textbooks) {
            if (textbook.sku == sku) {
                System.out.println(textbook);
                return;
            }
        }
        System.out.println("Textbook with SKU " + sku + " not found.");
    }

    public void displayInventory() {
        if (textbooks.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("Inventory:");
        for (Textbook textbook : textbooks) {
            System.out.println(textbook);
        }
    }

    private void saveInventory() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(textbooks);
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadInventory() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            textbooks = (LinkedList<Textbook>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous inventory found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }
}
