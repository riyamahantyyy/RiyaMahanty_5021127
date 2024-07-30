// src/LibraryManagement.java
import java.util.Arrays;
import java.util.Scanner;

public class LibraryManagement {

    // Linear Search Implementation
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search Implementation (requires sorted array)
    public static Book binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);

            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    // Method to sort books by title
    public static void sortBooksByTitle(Book[] books) {
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample Books
        Book[] books = {
            new Book(1, "The Catcher in the Rye", "J.D. Salinger"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "Moby Dick", "Herman Melville")
        };

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Search for a book by title (Linear Search)");
            System.out.println("2. Search for a book by title (Binary Search)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter the title of the book to search: ");
                String searchTitle = scanner.nextLine();
                Book foundBook = linearSearch(books, searchTitle);
                if (foundBook != null) {
                    System.out.println("Linear Search: Found book - " + foundBook);
                } else {
                    System.out.println("Linear Search: Book not found");
                }
            } else if (choice == 2) {
                sortBooksByTitle(books);
                System.out.print("Enter the title of the book to search: ");
                String searchTitle = scanner.nextLine();
                Book foundBook = binarySearch(books, searchTitle);
                if (foundBook != null) {
                    System.out.println("Binary Search: Found book - " + foundBook);
                } else {
                    System.out.println("Binary Search: Book not found");
                }
            } else if (choice == 3) {
                System.out.println("Exiting the program...");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}
