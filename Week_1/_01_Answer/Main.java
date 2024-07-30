import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();
        
        // Display default products
        System.out.println("Initial Inventory:");
        inventoryManagement.displayAllProducts();
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    inventoryManagement.addProduct(new Product(id, name, quantity, price));
                    System.out.println("Product added.");
                    break;
                case 2:
                    System.out.print("Enter Product ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter New Product Name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int updateQuantity = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double updatePrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    inventoryManagement.updateProduct(updateId, new Product(updateId, updateName, updateQuantity, updatePrice));
                    System.out.println("Product updated.");
                    break;
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    String deleteId = scanner.nextLine();
                    inventoryManagement.deleteProduct(deleteId);
                    System.out.println("Product deleted.");
                    break;
                case 4:
                    System.out.println("Current Inventory:");
                    inventoryManagement.displayAllProducts();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }

        scanner.close();
    }
}
