public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", "123456789"));
        library.addBook(new Book("1984", "George Orwell", "Dystopian", "987654321"));

        // Displaying available books
        System.out.println("Available books:");
        library.displayAvailableBooks();

        // Searching for books
        library.searchBooks("1984");

        // Checking out a book
        library.checkOutBook("123456789");

        // Trying to check out an already checked-out book
        library.checkOutBook("123456789");

        // Displaying available books after checkout
        System.out.println("Available books after checkout:");
        library.displayAvailableBooks();

        // Returning a book
        library.returnBook("123456789");

        // Displaying available books after return
        System.out.println("Available books after return:");
        library.displayAvailableBooks();
    }
}
