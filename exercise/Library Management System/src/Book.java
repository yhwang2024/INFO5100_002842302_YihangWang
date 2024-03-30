public class Book {
    private String Title;
    private String Author;
    private String Genre;
    private String ISBN;
    private boolean isAvailable;

    // Constructor
    public Book(String Title, String Author, String Genre, String ISBN) {
        this.Title = Title;
        this.Author = Author;
        this.Genre = Genre;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    // Getter methods
    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getGenre() {
        return Genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter method for availability
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // ToString method for displaying book information
    @Override
    public String toString() {
        return "Title: " + Title + ", Author: " + Author + ", Genre: " + Genre + ", ISBN: " + ISBN + ", Available: " + isAvailable;
    }
}

