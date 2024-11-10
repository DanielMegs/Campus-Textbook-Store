package daniel;

import java.util.Scanner;

public class MyMain {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Textbook");
            System.out.println("2. Remove Textbook");
            System.out.println("3. Display Textbook");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter SKU: ");
                    int sku = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    inventory.addTextbook(sku, title, price, quantity);
                    break;
                case 2:
                    System.out.print("Enter SKU of textbook to remove: ");
                    sku = scanner.nextInt();
                    inventory.removeTextbook(sku);
                    break;
                case 3:
                    System.out.print("Enter SKU of textbook to display: ");
                    sku = scanner.nextInt();
                    inventory.displayTextbook(sku);
                    break;
                case 4:
                    inventory.displayInventory();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
