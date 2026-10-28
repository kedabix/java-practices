package semester1.practice07;

public class BookItem {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;

    public BookItem(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public void borrowBook() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void printBook() {
        System.out.println("[" + isbn + "] \"" + title + "\", " + author + " - "
                + (isAvailable ? "в наявності" : "видана"));
    }
}
