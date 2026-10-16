import java.util.Scanner;

public class LibraryMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library();

        // Add some sample books
        library.addBook(new Book(1, "Java Programming", "John Smith"));
        library.addBook(new Book(2, "Python Basics", "Mary Jones"));
        library.addBook(new Book(3, "Database Systems", "Peter Brown"));

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Display all books");
            System.out.println("2. Search for a book");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Add a book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter book ID: ");
                    int searchId = input.nextInt();
                    library.searchBook(searchId);
                    break;

                case 3:
                    System.out.print("Enter book ID to borrow: ");
                    int borrowId = input.nextInt();
                    library.borrowBook(borrowId);
                    break;

                case 4:
                    System.out.print("Enter book ID to return: ");
                    int returnId = input.nextInt();
                    library.returnBook(returnId);
                    break;

                case 5:
                    System.out.print("Enter book ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter book title: ");
                    String title = input.nextLine();

                    System.out.print("Enter author name: ");
                    String author = input.nextLine();

                    library.addBook(new Book(id, title, author));
                    break;

                case 0:
                    System.out.println("Exiting the library system.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        input.close();
    }
}