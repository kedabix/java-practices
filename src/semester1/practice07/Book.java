package semester1.practice07;

public class Book {
    private String title;
    private String author;
    private int year;
    private double price;

    // Конструктор за замовчуванням
    public Book() {
        this.title = "Невідомо";
        this.author = "Невідомий";
        this.year = 2000;
        this.price = 0.0;
    }

    // Параметризований конструктор з перевіркою
    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        if (year < 0 || price < 0.0) {
            this.year = 2000;
            this.price = 0.0;
        } else {
            this.year = year;
            this.price = price;
        }
    }

    public void printInfo() {
        System.out.println("Книга: \"" + title + "\", автор: " + author + ", рік: " + year + ", ціна: " + price + " грн");
    }
}
