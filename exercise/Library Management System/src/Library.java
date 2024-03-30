import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> booklist;

    public Library() {
        booklist = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        booklist.add(book);
    }

    // Remove a book from the library
    public void removeBook(String ISBN) {
        boolean removed = booklist.removeIf(book -> book.getISBN().equals(ISBN));
        if (!removed) {
            System.out.println("Error: No book found with ISBN " + ISBN);
        } else {
            booklist.removeIf(book -> book.getISBN().equals(ISBN));
            System.out.println("Book successfully removed.");
        }
    }

    // Search for a book by title, author, or genre
    public void searchBooks(String query) {
        List<Book> foundBooks = booklist.stream().filter(book -> book.getTitle().equalsIgnoreCase(query)
                        || book.getAuthor().equalsIgnoreCase(query)
                        || book.getGenre().equalsIgnoreCase(query))
                .collect(Collectors.toList());

        if (foundBooks.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("Here are the books found: ");
            foundBooks.forEach(System.out::println);
        }
    }

    // Display all available books
    public void displayAvailableBooks() {
        booklist.stream().filter(Book::isAvailable).forEach(System.out::println);
    }

    // Check out a book
    public void checkOutBook(String ISBN) {
        Book book = booklist.stream().filter(b -> b.getISBN().equals(ISBN)).findFirst().orElse(null);
        if (book == null) {
            System.out.println("Error: No book found with ISBN " + ISBN);
        } else if (!book.isAvailable()) {
            System.out.println("Error: Book with ISBN " + ISBN + " is not available for checkout.");
        } else {
            book.setAvailable(false);
            System.out.println("Book successfully checked out.");
        }
    }

    // Return a book
    public void returnBook(String ISBN) {
        Book book = booklist.stream().filter(b -> b.getISBN().equals(ISBN)).findFirst().orElse(null);
        if (book == null) {
            System.out.println("Error: No book found with ISBN " + ISBN);
        } else if (book.isAvailable()) {
            System.out.println("Error: Book with ISBN " + ISBN + " was not checked out.");
        } else {
            book.setAvailable(true);
            System.out.println("Book successfully returned.");
        }
    }
}

