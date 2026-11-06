package semester1.practice09;

// =====================================================================
// БЛОК 3 (Завдання 17–24): композиція з масивами об'єктів (HAS-MANY)
// =====================================================================

/** Завдання 17: ламана лінія з масиву точок. */
class Polyline {
    private final Point2D[] vertices;
    private int count;

    public Polyline(int capacity) {
        this.vertices = new Point2D[capacity];
    }

    public boolean addVertex(double x, double y) {
        if (count >= vertices.length) {
            return false;
        }
        vertices[count++] = new Point2D(x, y);
        return true;
    }

    public double getTotalLength() {
        double sum = 0;
        for (int i = 1; i < count; i++) {
            sum += vertices[i - 1].distanceTo(vertices[i]);
        }
        return sum;
    }

    /** Додає замикаючий відрізок від останньої точки до першої. */
    public double getClosedPerimeter() {
        if (count < 2) {
            return 0;
        }
        return getTotalLength() + vertices[count - 1].distanceTo(vertices[0]);
    }

    public int getCount() {
        return count;
    }
}

/** Завдання 18: позиція замовлення. */
class OrderItem {
    private final String productName;
    private final double unitPrice;
    private int quantity;

    public OrderItem(String productName, double unitPrice, int quantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int extra) {
        quantity += extra;
    }

    public double getItemTotal() {
        return unitPrice * quantity;
    }
}

/** Завдання 18: кошик інтернет-магазину. */
class ShoppingOrder {
    private static final int MAX_ITEMS = 10;

    private final OrderItem[] items = new OrderItem[MAX_ITEMS];
    private int itemCount;

    public void addItem(String name, double price, int qty) {
        if (qty <= 0 || price < 0) {
            System.out.println("  Некоректна позиція: " + name);
            return;
        }
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getProductName().equalsIgnoreCase(name)) {
                items[i].addQuantity(qty); // товар уже є, збільшуємо кількість
                return;
            }
        }
        if (itemCount >= MAX_ITEMS) {
            System.out.println("  Кошик повний, не додано: " + name);
            return;
        }
        items[itemCount++] = new OrderItem(name, price, qty);
    }

    public double calculateGrandTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getItemTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------- ЧЕК -------------\n");
        for (int i = 0; i < itemCount; i++) {
            OrderItem it = items[i];
            sb.append(String.format("%-14s %2d x %8.2f = %9.2f%n",
                    it.getProductName(), it.getQuantity(), it.getUnitPrice(), it.getItemTotal()));
        }
        sb.append("-------------------------------\n");
        sb.append(String.format("РАЗОМ: %.2f грн", calculateGrandTotal()));
        return sb.toString();
    }
}

/** Завдання 19: книга. */
class BookItem {
    private final String title;
    private final String author;
    private final int pages;

    public BookItem(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" (" + author + ", " + pages + " с.)";
    }
}

/** Завдання 19: полиця з обмеженою кількістю місць. */
class Bookshelf {
    private final String genre;
    private final BookItem[] books;
    private int bookCount;

    public Bookshelf(String genre, int capacity) {
        this.genre = genre;
        this.books = new BookItem[capacity];
    }

    public boolean putBook(BookItem book) {
        if (book == null || bookCount >= books.length) {
            return false;
        }
        books[bookCount++] = book;
        return true;
    }

    public BookItem findLongestBook() {
        BookItem longest = null;
        for (int i = 0; i < bookCount; i++) {
            if (longest == null || books[i].getPages() > longest.getPages()) {
                longest = books[i];
            }
        }
        return longest;
    }

    public int getTotalPagesOnShelf() {
        int sum = 0;
        for (int i = 0; i < bookCount; i++) {
            sum += books[i].getPages();
        }
        return sum;
    }

    public String getGenre() {
        return genre;
    }

    public int getBookCount() {
        return bookCount;
    }
}

/** Завдання 20: трек. */
class AudioTrack {
    private final String title;
    private final String artist;
    private final int durationSeconds;

    public AudioTrack(String title, String artist, int durationSeconds) {
        this.title = title;
        this.artist = artist;
        this.durationSeconds = Math.max(0, durationSeconds);
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public String formatDuration() {
        return String.format("%02d:%02d", durationSeconds / 60, durationSeconds % 60);
    }

    @Override
    public String toString() {
        return artist + " - " + title + " [" + formatDuration() + "]";
    }
}

/** Завдання 20: плейлист. */
class Playlist {
    private final String name;
    private final AudioTrack[] tracks;
    private int trackCount;

    public Playlist(String name, int capacity) {
        this.name = name;
        this.tracks = new AudioTrack[capacity];
    }

    public boolean addTrack(AudioTrack track) {
        if (track == null || trackCount >= tracks.length) {
            return false;
        }
        tracks[trackCount++] = track;
        return true;
    }

    public int getTotalDurationSeconds() {
        int sum = 0;
        for (int i = 0; i < trackCount; i++) {
            sum += tracks[i].getDurationSeconds();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Плейлист '" + name + "':\n");
        for (int i = 0; i < trackCount; i++) {
            sb.append("  ").append(i + 1).append(". ").append(tracks[i]).append("\n");
        }
        int total = getTotalDurationSeconds();
        sb.append("Загальна тривалість: ").append(total / 60).append(" хв ").append(total % 60).append(" сек");
        return sb.toString();
    }
}

/** Завдання 21: вузол кластера. */
class ServerNode {
    private final String ipAddress;
    private final int totalRamGb;
    private int usedRamGb;
    private boolean online;

    public ServerNode(String ipAddress, int totalRamGb, boolean online) {
        this.ipAddress = ipAddress;
        this.totalRamGb = totalRamGb;
        this.online = online;
    }

    public int getFreeRamGb() {
        return totalRamGb - usedRamGb;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public void allocate(int ramGb) {
        usedRamGb += ramGb;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public String toString() {
        return ipAddress + " [" + (online ? "online" : "OFFLINE") + ", вільно "
                + getFreeRamGb() + "/" + totalRamGb + " ГБ]";
    }
}

/** Завдання 21: кластер, що розподіляє контейнери по вузлах. */
class DataCenterCluster {
    private final String clusterLocation;
    private final ServerNode[] nodes;
    private int nodeCount;

    public DataCenterCluster(String clusterLocation, int capacity) {
        this.clusterLocation = clusterLocation;
        this.nodes = new ServerNode[capacity];
    }

    public boolean addNode(ServerNode node) {
        if (node == null || nodeCount >= nodes.length) {
            return false;
        }
        nodes[nodeCount++] = node;
        return true;
    }

    /** Перший online-вузол, де вистачає вільної пам'яті. */
    public boolean deployContainer(int requiredRamGb) {
        for (int i = 0; i < nodeCount; i++) {
            if (nodes[i].isOnline() && nodes[i].getFreeRamGb() >= requiredRamGb) {
                nodes[i].allocate(requiredRamGb);
                System.out.println("  Контейнер " + requiredRamGb + " ГБ розміщено на " + nodes[i].getIpAddress());
                return true;
            }
        }
        System.out.println("  Контейнер " + requiredRamGb + " ГБ розмістити нікуди");
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Кластер '" + clusterLocation + "':\n");
        for (int i = 0; i < nodeCount; i++) {
            sb.append("  ").append(nodes[i]).append("\n");
        }
        return sb.toString().trim();
    }
}

/** Завдання 22: модуль курсу. */
class CourseModule {
    private final String topic;
    private final int lectureHours;
    private final int practiceHours;
    private final double maxScore;

    public CourseModule(String topic, int lectureHours, int practiceHours, double maxScore) {
        this.topic = topic;
        this.lectureHours = lectureHours;
        this.practiceHours = practiceHours;
        this.maxScore = maxScore;
    }

    public int getTotalHours() {
        return lectureHours + practiceHours;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public String getTopic() {
        return topic;
    }
}

/** Завдання 22: навчальний курс. */
class UniversityCourse {
    private final String courseTitle;
    private final CourseModule[] modules;
    private int moduleCount;

    public UniversityCourse(String courseTitle, int capacity) {
        this.courseTitle = courseTitle;
        this.modules = new CourseModule[capacity];
    }

    public boolean addModule(CourseModule module) {
        if (module == null || moduleCount >= modules.length) {
            return false;
        }
        modules[moduleCount++] = module;
        return true;
    }

    /** 1 кредит ЄКТС = 30 годин. */
    public double getEctsCredits() {
        int hours = 0;
        for (int i = 0; i < moduleCount; i++) {
            hours += modules[i].getTotalHours();
        }
        return hours / 30.0;
    }

    public double getTotalMaxScore() {
        double sum = 0;
        for (int i = 0; i < moduleCount; i++) {
            sum += modules[i].getMaxScore();
        }
        return sum;
    }

    public boolean isScoreExactly100() {
        return Math.abs(getTotalMaxScore() - 100.0) < 1e-9;
    }

    public String getCourseTitle() {
        return courseTitle;
    }
}

/** Завдання 23: вагон. */
class TrainCarriage {
    private final int carriageNumber;
    private final String type;
    private final int totalSeats;
    private int occupiedSeats;

    public TrainCarriage(int carriageNumber, String type, int totalSeats) {
        if (!type.equals("Купе") && !type.equals("Плацкарт") && !type.equals("Інтерсіті")) {
            throw new IllegalArgumentException("Невідомий тип вагона: " + type);
        }
        this.carriageNumber = carriageNumber;
        this.type = type;
        this.totalSeats = totalSeats;
    }

    public int getCarriageNumber() {
        return carriageNumber;
    }

    public int getFreeSeats() {
        return totalSeats - occupiedSeats;
    }

    public boolean bookSeats(int seats) {
        if (seats <= 0 || seats > getFreeSeats()) {
            return false;
        }
        occupiedSeats += seats;
        return true;
    }

    @Override
    public String toString() {
        return "Вагон №" + carriageNumber + " (" + type + "): " + occupiedSeats + "/" + totalSeats;
    }
}

/** Завдання 23: потяг. */
class PassengerTrain {
    private final String route;
    private final TrainCarriage[] carriages;
    private int carriageCount;

    public PassengerTrain(String route, int capacity) {
        this.route = route;
        this.carriages = new TrainCarriage[capacity];
    }

    public boolean attachCarriage(TrainCarriage c) {
        if (c == null || carriageCount >= carriages.length) {
            return false;
        }
        carriages[carriageCount++] = c;
        return true;
    }

    public int getTotalFreeSeats() {
        int sum = 0;
        for (int i = 0; i < carriageCount; i++) {
            sum += carriages[i].getFreeSeats();
        }
        return sum;
    }

    public boolean bookTicketsInCarriage(int carriageNumber, int seatsToBook) {
        for (int i = 0; i < carriageCount; i++) {
            if (carriages[i].getCarriageNumber() == carriageNumber) {
                return carriages[i].bookSeats(seatsToBook);
            }
        }
        return false; // такого вагона немає
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Потяг " + route + ":\n");
        for (int i = 0; i < carriageCount; i++) {
            sb.append("  ").append(carriages[i]).append("\n");
        }
        sb.append("  Вільних місць: ").append(getTotalFreeSeats());
        return sb.toString();
    }
}

/** Завдання 24: лінійне рівняння a*x + b*y = c. */
class LinearEquation {
    private static final double EPS = 1e-6;

    private final double a;
    private final double b;
    private final double c;

    public LinearEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isSatisfiedBy(double x, double y) {
        return Math.abs(a * x + b * y - c) < EPS;
    }

    @Override
    public String toString() {
        return a + "x + " + b + "y = " + c;
    }
}

/** Завдання 24: система рівнянь як композиція рівнянь. */
class EquationSystem {
    private final LinearEquation[] equations;
    private int count;

    public EquationSystem(int capacity) {
        this.equations = new LinearEquation[capacity];
    }

    public boolean addEquation(LinearEquation eq) {
        if (eq == null || count >= equations.length) {
            return false;
        }
        equations[count++] = eq;
        return true;
    }

    public boolean checkSolution(double x, double y) {
        if (count == 0) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (!equations[i].isSatisfiedBy(x, y)) {
                return false; // достатньо одного невиконаного
            }
        }
        return true;
    }
}
