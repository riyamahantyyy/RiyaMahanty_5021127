import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Order[] orders = new Order[]{
            new Order("1", "Alice", 150.00),
            new Order("2", "Bob", 120.00),
            new Order("3", "Charlie", 200.00),
            new Order("4", "Diana", 90.00)
        };

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Sorting Customer Orders");
            System.out.println("1. Sort Orders by Price using Bubble Sort");
            System.out.println("2. Sort Orders by Price using Quick Sort");
            System.out.println("3. Display Orders");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    BubbleSort.bubbleSort(orders);
                    System.out.println("Orders sorted using Bubble Sort.");
                    break;
                case 2:
                    QuickSort.quickSort(orders, 0, orders.length - 1);
                    System.out.println("Orders sorted using Quick Sort.");
                    break;
                case 3:
                    System.out.println("Current Orders:");
                    for (Order order : orders) {
                        System.out.println(order);
                    }
                    break;
                case 4:
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
