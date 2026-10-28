package semester1.practice07;

public class Practice07 {

    public static void main(String[] args) {
        // Блок 1
        task01();
        task02();
        task03();
        task04();
        task05();
        task06();
        task07();
        task08();
        // Блок 2
        task09();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        // Блок 3
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
        task23();
        task24();
        // Блок 4
        task25();
        task26();
        task27();
        task28();
        task29();
        task30();
        task31();
        task32();
        // Блок 5
        task33();
        task34();
        task35();
        task36();
        task37();
        task38();
        task39();
        task40();
    }

    private static void header(int number, String title) {
        System.out.println();
        System.out.println("===== Завдання " + number + ": " + title + " =====");
    }

    // ---------------- Блок 1 ----------------

    private static void task01() {
        header(1, "Book");
        Book b1 = new Book();
        Book b2 = new Book("Кобзар", "Тарас Шевченко", 1840, 250.0);
        Book b3 = new Book("Помилкова", "Хтось", -5, 100.0);
        b1.printInfo();
        b2.printInfo();
        b3.printInfo();
    }

    private static void task02() {
        header(2, "Student");
        Student s1 = new Student("Олег", 19, 4.8);
        Student s2 = new Student("Марія", 20, 3.9);
        Student s3 = new Student("Помилка", 5, 7.0);
        s1.printStudent();
        s2.printStudent();
        s3.printStudent();
    }

    private static void task03() {
        header(3, "BankAccount");
        BankAccount acc = new BankAccount("UA001", "Іван", 1000);
        acc.printAccount();
        acc.deposit(500);
        acc.withdraw(300);
        acc.withdraw(5000);
        acc.printAccount();
    }

    private static void task04() {
        header(4, "Point2D");
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(3, 4);
        p1.printPoint();
        p2.printPoint();
        System.out.println("Відстань p2 до початку координат: " + p2.distanceToOrigin());
        System.out.println("Відстань p1 до (6; 8): " + p1.distanceTo(6, 8));
        System.out.println("Відстань p2 до (6; 8): " + p2.distanceTo(6, 8));
    }

    private static void task05() {
        header(5, "Product");
        Product p = new Product("Ноутбук", 20000, 5, "Електроніка");
        p.printProduct();
        p.applyDiscount(20);
        System.out.println("Після знижки 20%:");
        p.printProduct();
    }

    private static void task06() {
        header(6, "Time");
        Time t = new Time(23, 59, 57);
        for (int i = 0; i < 5; i++) {
            System.out.println(t.toUniversalString() + "  |  " + t.toStandardString());
            t.tick();
        }
        Time t2 = new Time(14, 5, 9);
        System.out.println(t2.toUniversalString() + "  |  " + t2.toStandardString());
    }

    private static void task07() {
        header(7, "Rectangle");
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(5);
        Rectangle r3 = new Rectangle(4, 6);
        System.out.println("Одиничний: площа " + r1.getArea() + ", периметр " + r1.getPerimeter());
        System.out.println("Квадрат: площа " + r2.getArea() + ", периметр " + r2.getPerimeter() + ", квадрат? " + r2.isSquare());
        System.out.println("Прямокутник: площа " + r3.getArea() + ", периметр " + r3.getPerimeter() + ", квадрат? " + r3.isSquare());
    }

    private static void task08() {
        header(8, "Employee");
        Employee e = new Employee(1, "Петренко Олександр", "Програміст", 30000);
        e.printBadge();
        e.raiseSalary(15);
        System.out.println("Після підвищення на 15%:");
        e.printBadge();
        System.out.println("Річний дохід: " + e.getAnnualSalary() + " грн");
    }

    // ---------------- Блок 2 ----------------

    private static void task09() {
        header(9, "User");
        User u1 = new User("alex", "alex@mail.com", "ADMIN", true);
        User u2 = new User("maria", "maria@mail.com");
        User u3 = new User("ivan");
        User u4 = new User();
        u1.printProfile();
        u2.printProfile();
        u3.printProfile();
        u4.printProfile();
    }

    private static void task10() {
        header(10, "Fraction");
        Fraction f1 = new Fraction(6, -8);
        Fraction f2 = new Fraction(5);
        Fraction f3 = new Fraction();
        Fraction f4 = new Fraction(1, 0);
        f1.print();
        System.out.println("Десяткове значення: " + f1.toDouble());
        f2.print();
        f3.print();
        f4.print();
    }

    private static void task11() {
        header(11, "Car");
        Car car = new Car("Toyota", "Camry", 2024);
        car.drive(10);
        car.startEngine();
        car.drive(150);
        car.stopEngine();
        Car defaultCar = new Car();
        defaultCar.startEngine();
        defaultCar.drive(20);
    }

    private static void task12() {
        header(12, "SmartBulb");
        SmartBulb b1 = new SmartBulb(80, 3000, false);
        SmartBulb b2 = new SmartBulb(70);
        SmartBulb b3 = new SmartBulb();
        SmartBulb b4 = new SmartBulb(150, 9000, true);
        b1.printStatus();
        b2.printStatus();
        b3.printStatus();
        b4.printStatus();
    }

    private static void task13() {
        header(13, "QueryBuilder");
        String sql = new QueryBuilder("users").select("id, name, email").where("age >= 18").build();
        System.out.println(sql);
        System.out.println(new QueryBuilder("products").build());
    }

    private static void task14() {
        header(14, "CoffeeOrder");
        CoffeeOrder o1 = new CoffeeOrder("Лате", "Large", 2, true);
        CoffeeOrder o2 = new CoffeeOrder("Капучино", "Small");
        CoffeeOrder o3 = new CoffeeOrder("Еспресо");
        o1.printReceipt();
        o2.printReceipt();
        o3.printReceipt();
    }

    private static void task15() {
        header(15, "Box");
        Box cube = new Box(3, "Картон");
        Box copy = new Box(cube);
        cube.printBox();
        copy.printBox();
        System.out.println("Об'єми однакові? " + (cube.getVolume() == copy.getVolume()));
        System.out.println("Це один і той самий об'єкт? " + (cube == copy));
    }

    private static void task16() {
        header(16, "FlightTicket");
        FlightTicket ticket = new FlightTicket("T-1001", "Іван Петренко", "PS101", "Київ", "Львів");
        ticket.printBoardingPass();
        ticket.assignSeat("12A");
        ticket.printBoardingPass();
    }

    // ---------------- Блок 3 ----------------

    private static void task17() {
        header(17, "MathOperations");
        MathOperations m = new MathOperations();
        System.out.println("add(2, 3) = " + m.add(2, 3));
        System.out.println("add(2.5, 3.5) = " + m.add(2.5, 3.5));
        System.out.println("add(1, 2, 3) = " + m.add(1, 2, 3));
        System.out.println("add(\"Привіт\", \"світ\") = " + m.add("Привіт", "світ"));
        System.out.println("multiply(4, 5) = " + m.multiply(4, 5));
        System.out.println("multiply(1.5, 2.0) = " + m.multiply(1.5, 2.0));
        System.out.println("multiply(\"ha\", 3) = " + m.multiply("ha", 3));
    }

    private static void task18() {
        header(18, "DocumentPrinter");
        DocumentPrinter printer = new DocumentPrinter();
        printer.print("Звичайний рядок");
        printer.print(123);
        printer.print(3.14159, 2);
        printer.print(new String[]{"Перший", "Другий", "Третій"});
        printer.print("великі літери", true);
        printer.print("великі літери", false);
    }

    private static void task19() {
        header(19, "AreaCalculator");
        AreaCalculator calc = new AreaCalculator();
        System.out.println("Квадрат (сторона 4): " + calc.calculateArea(4.0));
        System.out.println("Прямокутник (3 x 5): " + calc.calculateArea(3.0, 5.0));
        System.out.println("Коло (радіус 2): " + calc.calculateArea(2.0, true));
        System.out.println("Трикутник (3, 4, 5): " + calc.calculateArea(3.0, 4.0, 5.0));
        System.out.println("Трапеція (основи 4 і 6, висота 5): " + calc.calculateTrapezoidArea(4.0, 6.0, 5.0));
    }

    private static void task20() {
        header(20, "Logger");
        Logger logger = new Logger();
        logger.log("Програму запущено");
        logger.log("WARN", "Мало вільної пам'яті");
        logger.log("ERROR", 404, "Файл не знайдено");
        logger.log("DEBUG", "Подія з часом", true);
    }

    private static void task21() {
        header(21, "ArraySearcher");
        ArraySearcher searcher = new ArraySearcher();
        int[] numbers = {5, 8, 3, 8, 1};
        String[] words = {"Java", "Python", "Kotlin"};
        System.out.println("find(numbers, 8) = " + searcher.find(numbers, 8));
        System.out.println("find(numbers, 8, 2) = " + searcher.find(numbers, 8, 2));
        System.out.println("find(numbers, 100) = " + searcher.find(numbers, 100));
        System.out.println("find(words, \"Python\") = " + searcher.find(words, "Python"));
        System.out.println("find(words, \"python\") = " + searcher.find(words, "python"));
        System.out.println("find(words, \"python\", true) = " + searcher.find(words, "python", true));
    }

    private static void task22() {
        header(22, "DateService");
        DateService date = new DateService(15, 3, 2024);
        date.printDate();
        date.add(20);
        date.printDate();
        date.add(0, 3);
        date.printDate();
    }

    private static void task23() {
        header(23, "SalaryCalculator");
        SalaryCalculator salary = new SalaryCalculator();
        System.out.println("Лише ставка: " + salary.calculate(20000.0));
        System.out.println("Ставка + премія 3000: " + salary.calculate(20000.0, 3000.0));
        System.out.println("Ставка + 10% бонус, з податком: " + salary.calculate(20000.0, 10.0, true));
        System.out.println("Ставка + 10 год понаднормових по 200: " + salary.calculate(20000.0, 10, 200.0));
    }

    private static void task24() {
        header(24, "ArrayFilter");
        ArrayFilter filter = new ArrayFilter();
        int[] data = {12, 5, 8, 19, 24, 3, 16};
        printArray("Більші за 10", filter.filter(data, 10));
        printArray("Від 5 до 16", filter.filter(data, 5, 16));
        printArray("Парні", filter.filter(data, true));
        printArray("Непарні", filter.filter(data, false));
    }

    private static void printArray(String title, int[] arr) {
        String text = title + ": ";
        for (int i = 0; i < arr.length; i++) {
            text += arr[i] + " ";
        }
        System.out.println(text);
    }

    // ---------------- Блок 4 ----------------

    private static void task25() {
        header(25, "UserAccount");
        UserAccount a1 = new UserAccount("alex", "alex@mail.com");
        UserAccount a2 = new UserAccount("maria", "maria@mail.com");
        UserAccount a3 = new UserAccount("ivan", "ivan@mail.com");
        a1.printAccount();
        a2.printAccount();
        a3.printAccount();
        System.out.println("Наступний вільний ID: " + UserAccount.getNextAvailableId());
        UserAccount.resetIdSequence(5000);
        UserAccount a4 = new UserAccount("new_user", "new@mail.com");
        a4.printAccount();
        UserAccount.resetIdSequence(1001);
    }

    private static void task26() {
        header(26, "ServerConfig");
        for (int i = 1; i <= 6; i++) {
            if (ServerConfig.connect()) {
                System.out.println("Користувач " + i + " підключився");
            } else {
                System.out.println("Користувач " + i + ": відмова, ліміт вичерпано!");
            }
        }
        ServerConfig.printServerStatus();
        ServerConfig.disconnect();
        ServerConfig.printServerStatus();
    }

    private static void task27() {
        header(27, "MathUtils");
        System.out.println("PI = " + MathUtils.PI + ", E = " + MathUtils.E);
        System.out.println("5! = " + MathUtils.factorial(5));
        System.out.println("2^10 = " + MathUtils.power(2, 10));
        System.out.println("2^(-2) = " + MathUtils.power(2, -2));
        System.out.println("НСД(48, 18) = " + MathUtils.gcd(48, 18));
        System.out.println("clamp(150, 0, 100) = " + MathUtils.clamp(150, 0, 100));
        System.out.println("clamp(-5, 0, 100) = " + MathUtils.clamp(-5, 0, 100));
    }

    private static void task28() {
        header(28, "CurrencyExchange");
        System.out.println("100 USD = " + CurrencyExchange.usdToUah(100) + " UAH");
        System.out.println("100 EUR = " + CurrencyExchange.eurToUah(100) + " UAH");
        System.out.println("4150 UAH = " + CurrencyExchange.uahToUsd(4150) + " USD");
        CurrencyExchange.updateRates(42.0, 46.0);
        System.out.println("Після зміни курсу:");
        System.out.println("100 USD = " + CurrencyExchange.usdToUah(100) + " UAH");
        System.out.println("100 EUR = " + CurrencyExchange.eurToUah(100) + " UAH");
    }

    private static void task29() {
        header(29, "FleetCar");
        FleetCar car1 = new FleetCar("VIN001", 10000);
        FleetCar car2 = new FleetCar("VIN002", 25000);
        FleetCar car3 = new FleetCar("VIN003", 500);
        car1.addTrip(120);
        car2.addTrip(300);
        car3.addTrip(80);
        car1.printCar();
        car2.printCar();
        car3.printCar();
        FleetCar.printFleetSummary();
    }

    private static void task30() {
        header(30, "StringUtils");
        System.out.println("\"А роза упала на лапу Азора\" паліндром? "
                + StringUtils.isPalindrome("А роза упала на лапу Азора"));
        System.out.println("\"Привіт\" паліндром? " + StringUtils.isPalindrome("Привіт"));
        System.out.println("reverse(\"Java\") = " + StringUtils.reverse("Java"));
        System.out.println("Голосних у \"Програмування\": " + StringUtils.countVowels("Програмування"));
        System.out.println("Картка: " + StringUtils.maskCardNumber("1234 5678 9012 3456"));
    }

    private static void task31() {
        header(31, "GameSession");
        GameSession s1 = GameSession.createSession("Player1");
        GameSession s2 = GameSession.createSession("Player2");
        GameSession s3 = GameSession.createSession("Player3");
        GameSession s4 = GameSession.createSession("Player4");
        System.out.println("Четверта сесія == null? " + (s4 == null));
        s1.terminate();
        GameSession s5 = GameSession.createSession("Player5");
        if (s5 != null) {
            s5.printSession();
        }
        s2.printSession();
        s3.printSession();
    }

    private static void task32() {
        header(32, "PhysicsEngine");
        System.out.println("Енергія спокою 1 грама: " + PhysicsEngine.restEnergy(0.001) + " Дж");
        System.out.println("Відстань падіння за 5 секунд: " + PhysicsEngine.freeFallDistance(5) + " м");
        System.out.println("Кінетична енергія (2 кг, 10 м/с): " + PhysicsEngine.kineticEnergy(2, 10) + " Дж");
    }

    // ---------------- Блок 5 ----------------

    private static void task33() {
        header(33, "Point та LineSegment");
        LineSegment segment = new LineSegment(0, 0, 6, 8);
        segment.printSegment();
        System.out.println("Довжина: " + segment.getLength());
        Point mid = segment.getMidPoint();
        System.out.println("Середина: (" + mid.getX() + "; " + mid.getY() + ")");

        LineSegment segment2 = new LineSegment(new Point(1, 1), new Point(4, 5));
        segment2.printSegment();
        System.out.println("Довжина: " + segment2.getLength());
    }

    private static void task34() {
        header(34, "ClientAccount");
        ClientAccount ivan = new ClientAccount("UA111", "Іван", 10000);
        ClientAccount maria = new ClientAccount("UA222", "Марія", 2000);
        ivan.transferTo(maria, 3500);
        ivan.transferTo(ivan, 100);
        ivan.transferTo(maria, 999999);
        ivan.printAccount();
        maria.printAccount();
    }

    private static void task35() {
        header(35, "CarWithEngine");
        Engine engine = new Engine("ENG-777", 250);
        CarWithEngine car = new CarWithEngine("BMW", "M3", engine);
        car.printSpecs();
        car.startCar();
        car.printSpecs();
        car.turnOff();
        car.printSpecs();
    }

    private static void task36() {
        header(36, "Computer");
        Processor cpu = new Processor("Intel Core i5", 3.6, 8000);
        Memory ram16 = new Memory(16, 3200, 2000);
        Memory ram32 = new Memory(32, 3600, 3800);
        Computer pc = new Computer("Ігровий ПК", cpu, ram16, 3000);
        pc.printSpecs();
        System.out.println("Ціна: " + pc.calculateTotalPrice() + " грн");
        pc.upgradeMemory(ram32);
        pc.printSpecs();
        System.out.println("Нова ціна: " + pc.calculateTotalPrice() + " грн");
    }

    private static void task37() {
        header(37, "Hero");
        Hero knight = new Hero("Лицар", 100, 20, 5);
        Hero orc = new Hero("Орк", 120, 18, 3);
        while (knight.isAlive() && orc.isAlive()) {
            knight.attack(orc);
            if (orc.isAlive()) {
                orc.attack(knight);
            }
        }
        if (knight.isAlive()) {
            System.out.println("Переміг: " + knight.getName());
        } else {
            System.out.println("Переміг: " + orc.getName());
        }
    }

    private static void task38() {
        header(38, "Customer, ShopProduct та Order");
        ShopProduct phone = new ShopProduct(1, "Телефон", 15000);
        ShopProduct case1 = new ShopProduct(2, "Чохол", 500);
        ShopProduct glass = new ShopProduct(3, "Захисне скло", 300);

        Customer rich = new Customer("Богдан", 20000);
        Order order1 = new Order(rich, 5);
        order1.addProduct(phone);
        order1.addProduct(case1);
        order1.addProduct(glass);
        order1.checkout();

        System.out.println();
        Customer poor = new Customer("Стас", 1000);
        Order order2 = new Order(poor, 5);
        order2.addProduct(phone);
        order2.checkout();
    }

    private static void task39() {
        header(39, "Vector3D");
        Vector3D a = new Vector3D(1, 0, 0);
        Vector3D b = new Vector3D(0, 1, 0);
        Vector3D zero = new Vector3D();

        System.out.print("a + b = ");
        a.add(b).print();
        System.out.println("a · b = " + a.dotProduct(b));
        System.out.print("a × b = ");
        a.crossProduct(b).print();
        System.out.println("a перпендикулярний до b? " + a.isOrthogonalTo(b));
        System.out.println("a рівний b? " + a.isEqualTo(b));
        System.out.println("a рівний копії (1; 0; 0)? " + a.isEqualTo(new Vector3D(1, 0, 0)));
        System.out.print("Нульовий вектор: ");
        zero.print();
    }

    private static void task40() {
        header(40, "LibraryCatalog");
        LibraryCatalog library = new LibraryCatalog(5);
        library.addBook(new BookItem("111", "Кобзар", "Тарас Шевченко"));
        library.addBook(new BookItem("222", "Лісова пісня", "Леся Українка"));
        library.addBook(new BookItem("333", "Захар Беркут", "Іван Франко"));
        library.printCatalog();

        library.borrowBook("Кобзар");
        library.borrowBook("Кобзар");
        library.borrowBook("Невідома книга");
        library.printCatalog();
    }
}
