import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        for (Book existingBook : books) {
            if (existingBook.getId() == book.getId()) {
                System.out.println("A book with this ID already exists.");
                return;
            }
        }

        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    public void searchBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.displayBook();
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void borrowBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.borrowBook();
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.returnBook();
                return;
            }
        }

        System.out.println("Book not found.");
    }
}