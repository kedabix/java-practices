package semester1.practice07;

public class LibraryCatalog {
    private BookItem[] books;
    private int size;

    public LibraryCatalog(int capacity) {
        this.books = new BookItem[capacity];
        this.size = 0;
    }

    public void addBook(BookItem book) {
        if (size < books.length) {
            books[size] = book;
            size++;
        } else {
            System.out.println("Фонд заповнений, книгу не додано");
        }
    }

    public BookItem findBookByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    public boolean borrowBook(String title) {
        BookItem book = findBookByTitle(title);
        if (book == null) {
            System.out.println("Книгу \"" + title + "\" не знайдено");
            return false;
        }
        if (!book.isAvailable()) {
            System.out.println("Книга \"" + title + "\" уже видана");
            return false;
        }
        book.borrowBook();
        System.out.println("Ви взяли книгу \"" + title + "\"");
        return true;
    }

    public void printCatalog() {
        System.out.println("--- Каталог ---");
        for (int i = 0; i < size; i++) {
            books[i].printBook();
        }
    }
}
