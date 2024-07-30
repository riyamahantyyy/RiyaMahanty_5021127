import java.util.Scanner;

public class ECommercePlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("E-commerce Search Function");
            System.out.println("1. Linear Search by ID");
            System.out.println("2. Binary Search by ID");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID to search (Linear Search): ");
                    String searchIdLinear = scanner.nextLine();
                    Product resultLinear = SearchAlgorithms.linearSearchById(searchIdLinear);
                    if (resultLinear != null) {
                        System.out.println("Found: " + resultLinear);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter Product ID to search (Binary Search): ");
                    String searchIdBinary = scanner.nextLine();
                    Product resultBinary = SearchAlgorithms.binarySearchById(searchIdBinary);
                    if (resultBinary != null) {
                        System.out.println("Found: " + resultBinary);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
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
