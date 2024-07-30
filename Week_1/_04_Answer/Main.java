import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManagement employeeManagement = new EmployeeManagement(10); // Initialize with a capacity of 10
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Display All Employees");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    employeeManagement.addEmployee(new Employee(id, name, position, salary));
                    System.out.println("Employee added.");
                    break;
                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    String searchId = scanner.nextLine();
                    Employee foundEmployee = employeeManagement.searchEmployeeById(searchId);
                    if (foundEmployee != null) {
                        System.out.println("Employee found: " + foundEmployee);
                    } else {
                        System.out.println("Employee with ID " + searchId + " not found.");
                    }
                    break;
                case 3:
                    System.out.println("Current Employees:");
                    employeeManagement.traverseEmployees();
                    break;
                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    String deleteId = scanner.nextLine();
                    employeeManagement.deleteEmployeeById(deleteId);
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
