import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManagement taskManagement = new TaskManagement();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task by ID");
            System.out.println("3. Display All Tasks");
            System.out.println("4. Delete Task by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Status: ");
                    String status = scanner.nextLine();
                    taskManagement.addTask(new Task(id, name, status));
                    System.out.println("Task added.");
                    break;
                case 2:
                    System.out.print("Enter Task ID to search: ");
                    String searchId = scanner.nextLine();
                    Task foundTask = taskManagement.searchTaskById(searchId);
                    if (foundTask != null) {
                        System.out.println("Task found: " + foundTask);
                    } else {
                        System.out.println("Task with ID " + searchId + " not found.");
                    }
                    break;
                case 3:
                    System.out.println("Current Tasks:");
                    taskManagement.traverseTasks();
                    break;
                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    String deleteId = scanner.nextLine();
                    taskManagement.deleteTaskById(deleteId);
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
