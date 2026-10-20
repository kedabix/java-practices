package semester1.practice06;

public class Practice06 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
        task23();
        task24();
        task25();
        task26();
        task27();
        task28();
        task29();
        task30();
        task31();
        task32();
        task33();
        task34();
        task35();
        task36();
        task37();
        task38();
        task39();
        task40();
    }

    // Завдання 1
    static void task1() {
        System.out.println("=== Завдання 1 ===");
        Student s1 = new Student();
        s1.name = "Денис";
        s1.age = 19;
        s1.gpa = 4.75;
        System.out.println(s1.name + ", " + s1.age + ", " + s1.gpa);
    }

    // Завдання 2
    static void task2() {
        System.out.println("=== Завдання 2 ===");
        Car car1 = new Car();
        Car car2 = new Car();
        car1.brand = "Toyota";
        car1.model = "Camry";
        car1.year = 2021;
        car1.speed = 180;
        car2.brand = "BMW";
        car2.model = "M5";
        car2.year = 2023;
        car2.speed = 250;
        System.out.println(car1.brand + " " + car1.model + ", " + car1.year + ", " + car1.speed + " км/год");
        System.out.println(car2.brand + " " + car2.model + ", " + car2.year + ", " + car2.speed + " км/год");
        if (car1.year > car2.year) {
            System.out.println("Новіший автомобіль: " + car1.brand);
        } else {
            System.out.println("Новіший автомобіль: " + car2.brand);
        }
    }

    // Завдання 3
    static void task3() {
        System.out.println("=== Завдання 3 ===");
        Book emptyBook = new Book();
        System.out.println(emptyBook.title);
        System.out.println(emptyBook.author);
        System.out.println(emptyBook.pages);
        System.out.println(emptyBook.isRead);
    }

    // Завдання 4
    static void task4() {
        System.out.println("=== Завдання 4 ===");
        Rectangle rect = new Rectangle();
        rect.width = 7.5;
        rect.height = 4.0;
        double area = rect.width * rect.height;
        double perimeter = 2 * (rect.width + rect.height);
        System.out.println("Площа: " + area);
        System.out.println("Периметр: " + perimeter);
    }

    // Завдання 5
    static void task5() {
        System.out.println("=== Завдання 5 ===");
        Product p = new Product();
        p.name = "Монітор";
        p.price = 6500.0;
        p.quantity = 8;
        System.out.println("Загальна вартість партії " + p.name + ": " + (p.price * p.quantity) + " грн");
    }

    // Завдання 6
    static void task6() {
        System.out.println("=== Завдання 6 ===");
        Smartphone phone = new Smartphone();
        phone.model = "Galaxy";
        phone.batteryLevel = 100;
        phone.isTurnedOn = true;
        phone.batteryLevel -= 35;
        if (phone.batteryLevel <= 0) {
            phone.isTurnedOn = false;
        }
        System.out.println(phone.model + ": заряд " + phone.batteryLevel + "%, увімкнено: " + phone.isTurnedOn);
    }

    // Завдання 7
    static void task7() {
        System.out.println("=== Завдання 7 ===");
        Point2D a = new Point2D();
        a.x = 0;
        a.y = 0;
        Point2D b = new Point2D();
        b.x = 3;
        b.y = 4;
        double d = Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
        System.out.println("Відстань між точками: " + d);
    }

    // Завдання 8
    static void task8() {
        System.out.println("=== Завдання 8 ===");
        Student first = new Student();
        first.name = "Іван";
        Student second = first;
        second.name = "Петро";
        System.out.println(first.name);
        // first і second — це два посилання на ОДИН об'єкт у Heap, new не викликали,
        // тому зміна через second змінює і first
    }

    // Завдання 9
    static void task9() {
        System.out.println("=== Завдання 9 ===");
        Greeter greeter = new Greeter();
        greeter.sayHello();
        greeter.sayHelloTo("Євгеній");
    }

    // Завдання 10
    static void task10() {
        System.out.println("=== Завдання 10 ===");
        Animal cat = new Animal();
        cat.species = "Кіт";
        cat.name = "Мурчик";
        Animal dog = new Animal();
        dog.species = "Собака";
        dog.name = "Барбос";
        cat.printInfo();
        cat.makeSound();
        dog.printInfo();
        dog.makeSound();
    }

    // Завдання 11
    static void task11() {
        System.out.println("=== Завдання 11 ===");
        Counter counter = new Counter();
        counter.increment();
        counter.increment();
        counter.increment();
        counter.decrement();
        counter.printCount();
        counter.reset();
        counter.printCount();
    }

    // Завдання 12
    static void task12() {
        System.out.println("=== Завдання 12 ===");
        TrafficLight light = new TrafficLight();
        light.changeColor("Червоний");
        light.showSignal();
        light.changeColor("Жовтий");
        light.showSignal();
        light.changeColor("Зелений");
        light.showSignal();
    }

    // Завдання 13
    static void task13() {
        System.out.println("=== Завдання 13 ===");
        Player player = new Player();
        player.nickname = "Hero";
        player.takeDamage(40);
        System.out.println("Здоров'я: " + player.health);
        player.heal(25);
        System.out.println("Здоров'я: " + player.health);
        player.heal(100);
        System.out.println("Здоров'я: " + player.health);
        player.takeDamage(200);
        System.out.println("Здоров'я: " + player.health);
    }

    // Завдання 14
    static void task14() {
        System.out.println("=== Завдання 14 ===");
        Lamp lamp = new Lamp();
        lamp.status();
        lamp.toggle();
        lamp.status();
        lamp.toggle();
        lamp.status();
    }

    // Завдання 15
    static void task15() {
        System.out.println("=== Завдання 15 ===");
        Stopwatch watch = new Stopwatch();
        watch.tick();
        watch.addSeconds(124);
        watch.displayTime();
    }

    // Завдання 16
    static void task16() {
        System.out.println("=== Завдання 16 ===");
        Printer printer = new Printer();
        printer.model = "HP LaserJet";
        printer.paperCount = 10;
        printer.printDocument("Реферат", 6);
        printer.printDocument("Курсова", 8);
    }

    // Завдання 17
    static void task17() {
        System.out.println("=== Завдання 17 ===");
        SimpleCalculator calc = new SimpleCalculator();
        int sum = calc.add(10, 5);
        int diff = calc.subtract(10, 5);
        int prod = calc.multiply(10, 5);
        double quot = calc.divide(10, 4);
        double bad = calc.divide(10, 0);
        System.out.println(sum + " " + diff + " " + prod + " " + quot + " " + bad);
    }

    // Завдання 18
    static void task18() {
        System.out.println("=== Завдання 18 ===");
        Circle circle = new Circle();
        circle.radius = 5.0;
        System.out.println("Площа: " + circle.getArea());
        System.out.println("Довжина кола: " + circle.getCircumference());
    }

    // Завдання 19
    static void task19() {
        System.out.println("=== Завдання 19 ===");
        TemperatureConverter converter = new TemperatureConverter();
        double f = converter.celsiusToFahrenheit(25);
        double c = converter.fahrenheitToCelsius(f);
        System.out.println("25°C = " + f + "°F");
        System.out.println(f + "°F = " + c + "°C");
    }

    // Завдання 20
    static void task20() {
        System.out.println("=== Завдання 20 ===");
        NumberChecker checker = new NumberChecker();
        int[] numbers = {7, 12, -5};
        for (int n : numbers) {
            System.out.println(n + ": парне - " + checker.isEven(n) + ", додатне - " + checker.isPositive(n) + ", просте - " + checker.isPrime(n));
        }
    }

    // Завдання 21
    static void task21() {
        System.out.println("=== Завдання 21 ===");
        CurrencyExchange exchange = new CurrencyExchange();
        exchange.usdRate = 41.5;
        double usd = exchange.toUSD(10000);
        System.out.println("10000 грн = " + Math.round(usd * 100) / 100.0 + " USD");
        System.out.println("100 USD = " + exchange.toUAH(100) + " грн");
    }

    // Завдання 22
    static void task22() {
        System.out.println("=== Завдання 22 ===");
        Employee emp = new Employee();
        emp.name = "Олег";
        emp.baseSalary = 30000;
        emp.bonusPercentage = 15;
        System.out.println("Повна зарплата: " + emp.calculateTotalSalary() + " грн");
        System.out.println("Податок: " + emp.calculateTax() + " грн");
    }

    // Завдання 23
    static void task23() {
        System.out.println("=== Завдання 23 ===");
        TextFormatter formatter = new TextFormatter();
        System.out.println(formatter.formatTitle("програмування"));
        System.out.println("Голосних: " + formatter.countVowels("програмування"));
    }

    // Завдання 24
    static void task24() {
        System.out.println("=== Завдання 24 ===");
        Triangle t = new Triangle();
        t.a = 3;
        t.b = 4;
        t.c = 5;
        System.out.println("Існує: " + t.isValid());
        System.out.println("Периметр: " + t.getPerimeter());
        System.out.println("Площа: " + t.getArea());
    }

    // Завдання 25
    static void task25() {
        System.out.println("=== Завдання 25 ===");
        SecretVault vault = new SecretVault();
        // vault.secretCode = "hacked"; // помилка компілятора: secretCode has private access in SecretVault
        System.out.println("Правильний код: " + vault.verifyCode("Pass123"));
        System.out.println("Неправильний код: " + vault.verifyCode("12345"));
    }

    // Завдання 26
    static void task26() {
        System.out.println("=== Завдання 26 ===");
        UserAccount acc = new UserAccount();
        acc.setCredentials("evgen", "qwerty");
        System.out.println("Вхід: " + acc.login("evgen", "qwerty"));
        acc.changePassword("wrong", "new123");
        acc.changePassword("qwerty", "new123");
        System.out.println("Вхід зі старим паролем: " + acc.login("evgen", "qwerty"));
        System.out.println("Вхід з новим паролем: " + acc.login("evgen", "new123"));
    }

    // Завдання 27
    static void task27() {
        System.out.println("=== Завдання 27 ===");
        BankAccount account = new BankAccount();
        account.deposit(1000);
        System.out.println("Баланс: " + account.getBalance());
        System.out.println("Зняття 300: " + account.withdraw(300));
        System.out.println("Зняття 5000: " + account.withdraw(5000));
        System.out.println("Баланс: " + account.getBalance());
    }

    // Завдання 28
    static void task28() {
        System.out.println("=== Завдання 28 ===");
        Thermometer thermometer = new Thermometer();
        thermometer.setTemperature(21.5);
        System.out.println("Температура: " + thermometer.getTemperature());
        thermometer.setTemperature(-300);
        System.out.println("Температура: " + thermometer.getTemperature());
    }

    // Завдання 29
    static void task29() {
        System.out.println("=== Завдання 29 ===");
        CarSpeedometer speedometer = new CarSpeedometer();
        speedometer.accelerate(100);
        System.out.println("Швидкість: " + speedometer.getSpeed());
        speedometer.accelerate(200);
        System.out.println("Швидкість: " + speedometer.getSpeed());
        speedometer.brake(50);
        System.out.println("Швидкість: " + speedometer.getSpeed());
        speedometer.brake(500);
        System.out.println("Швидкість: " + speedometer.getSpeed());
    }

    // Завдання 30
    static void task30() {
        System.out.println("=== Завдання 30 ===");
        Person p1 = new Person();
        p1.setName("Євгеній");
        p1.setAge(18);
        Person p2 = new Person();
        p2.setName("Марія");
        p2.setAge(200);
        p1.printSummary();
        p2.printSummary();
    }

    // Завдання 31
    static void task31() {
        System.out.println("=== Завдання 31 ===");
        DiscountCard card = new DiscountCard();
        card.setOwnerName("Євгеній");
        card.addPurchase(3000);
        card.printCardInfo();
        card.addPurchase(4000);
        card.printCardInfo();
    }

    // Завдання 32
    static void task32() {
        System.out.println("=== Завдання 32 ===");
        SmartDoorLock lock = new SmartDoorLock();
        lock.enterPin(1111);
        lock.enterPin(2222);
        lock.enterPin(3333);
        lock.enterPin(1234);
    }

    // Завдання 33
    static void task33() {
        System.out.println("=== Завдання 33 ===");
        GradeBook book = new GradeBook();
        int[] grades = {85, 92, 78, 96, 65};
        book.setData("Євгеній", grades);
        System.out.println("Середній бал: " + book.getAverage());
        System.out.println("Найвища оцінка: " + book.getHighestGrade());
        System.out.println("Найнижча оцінка: " + book.getLowestGrade());
    }

    // Завдання 34
    static void task34() {
        System.out.println("=== Завдання 34 ===");
        ArrayStats stats = new ArrayStats();
        int[] nums = {4, 7, 12, 9, 15, 20, 3, 8, 11, 6};
        stats.setNumbers(nums);
        System.out.println("Парних: " + stats.countEvens());
        System.out.println("Непарних: " + stats.countOdds());
        System.out.println("Сума: " + stats.calculateSum());
    }

    // Завдання 35
    static void task35() {
        System.out.println("=== Завдання 35 ===");
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(120.5);
        cart.addItem(80);
        cart.addItem(300);
        System.out.println("Чек: " + cart.getTotalCost() + " грн");
        cart.applyDiscount(15);
        System.out.println("Чек зі знижкою 15%: " + cart.getTotalCost() + " грн");
    }

    // Завдання 36
    static void task36() {
        System.out.println("=== Завдання 36 ===");
        TemperatureTracker tracker = new TemperatureTracker();
        double[] temps = {14.5, 16.0, 18.2, 21.0, 19.5, 17.3, 15.8};
        tracker.setTemps(temps);
        System.out.println("Днів тепліше за 17: " + tracker.countDaysAbove(17));
        tracker.printWeeklyReport();
    }

    // Завдання 37
    static void task37() {
        System.out.println("=== Завдання 37 ===");
        ArraySearcher searcher = new ArraySearcher();
        int[] data = {5, 10, 15, 20, 25};
        searcher.setData(data);
        System.out.println("Є число 20: " + searcher.contains(20));
        System.out.println("Індекс 20: " + searcher.findIndex(20));
        System.out.println("Є число 7: " + searcher.contains(7));
        System.out.println("Індекс 7: " + searcher.findIndex(7));
    }

    // Завдання 38
    static void task38() {
        System.out.println("=== Завдання 38 ===");
        Vector3D v = new Vector3D();
        v.setCoords(2, 3, 6);
        System.out.println("Довжина: " + v.getMagnitude());
        v.multiplyByScalar(2);
        v.printVector();
    }

    // Завдання 39
    static void task39() {
        System.out.println("=== Завдання 39 ===");
        Matrix2D matrix = new Matrix2D();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix.setGrid(grid);
        matrix.printMatrix();
        System.out.println("Сума всіх: " + matrix.getTotalSum());
        System.out.println("Сума рядка 1: " + matrix.getRowSum(1));
    }

    // Завдання 40
    static void task40() {
        System.out.println("=== Завдання 40 ===");
        MatrixDiagonals md = new MatrixDiagonals();
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        md.setMatrix(m);
        System.out.println("Головна діагональ: " + md.getMainDiagonalSum());
        System.out.println("Побічна діагональ: " + md.getAntiDiagonalSum());
        System.out.println("Симетричні: " + md.isDiagonalSymmetric());
    }
}

// ---------- Класи до завдань ----------

class Student {
    public String name;
    public int age;
    public double gpa;
}

class Car {
    public String brand;
    public String model;
    public int year;
    public int speed;
}

class Book {
    public String title;
    public String author;
    public int pages;
    public boolean isRead;
}

class Rectangle {
    public double width;
    public double height;
}

class Product {
    public String name;
    public double price;
    public int quantity;
}

class Smartphone {
    public String model;
    public int batteryLevel;
    public boolean isTurnedOn;
}

class Point2D {
    public double x;
    public double y;
}

class Greeter {
    public void sayHello() {
        System.out.println("Привіт усім!");
    }

    public void sayHelloTo(String name) {
        System.out.println("Привіт, " + name + "! Раді тебе бачити.");
    }
}

class Animal {
    public String species;
    public String name;

    public void makeSound() {
        System.out.println(name + " видає звук!");
    }

    public void printInfo() {
        System.out.println("Вид: " + species + ", кличка: " + name);
    }
}

class Counter {
    public int count;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public void reset() {
        count = 0;
    }

    public void printCount() {
        System.out.println("Лічильник: " + count);
    }
}

class TrafficLight {
    public String currentColor;

    public void changeColor(String newColor) {
        currentColor = newColor;
    }

    public void showSignal() {
        if (currentColor.equals("Червоний")) {
            System.out.println("Стій!");
        } else if (currentColor.equals("Жовтий")) {
            System.out.println("Увага!");
        } else if (currentColor.equals("Зелений")) {
            System.out.println("Їдь!");
        }
    }
}

class Player {
    public String nickname;
    public int health = 100;

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
            System.out.println(nickname + " загинув!");
        }
    }

    public void heal(int amount) {
        health += amount;
        if (health > 100) {
            health = 100;
        }
    }
}

class Lamp {
    public boolean isOn;

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public void toggle() {
        isOn = !isOn;
    }

    public void status() {
        if (isOn) {
            System.out.println("Лампа світить");
        } else {
            System.out.println("Лампа вимкнена");
        }
    }
}

class Stopwatch {
    public int seconds;

    public void tick() {
        seconds++;
    }

    public void addSeconds(int s) {
        seconds += s;
    }

    public void displayTime() {
        int min = seconds / 60;
        int sec = seconds % 60;
        String minText = (min < 10) ? "0" + min : "" + min;
        String secText = (sec < 10) ? "0" + sec : "" + sec;
        System.out.println(minText + ":" + secText);
    }
}

class Printer {
    public String model;
    public int paperCount;

    public void printDocument(String title, int pages) {
        if (paperCount >= pages) {
            paperCount -= pages;
            System.out.println("Документ \"" + title + "\" надруковано. Залишилось паперу: " + paperCount);
        } else {
            System.out.println("Помилка: Недостатньо паперу в принтері " + model + "!");
        }
    }
}

class SimpleCalculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Помилка: ділення на нуль!");
            return 0.0;
        }
        return (double) a / b;
    }
}

class Circle {
    public double radius;

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}

class TemperatureConverter {
    public double celsiusToFahrenheit(double c) {
        return c * 1.8 + 32;
    }

    public double fahrenheitToCelsius(double f) {
        return (f - 32) / 1.8;
    }
}

class NumberChecker {
    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    public boolean isPositive(int n) {
        return n > 0;
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class CurrencyExchange {
    public double usdRate;

    public double toUSD(double uah) {
        return uah / usdRate;
    }

    public double toUAH(double usd) {
        return usd * usdRate;
    }
}

class Employee {
    public String name;
    public double baseSalary;
    public double bonusPercentage;

    public double calculateTotalSalary() {
        return baseSalary * (1 + bonusPercentage / 100);
    }

    public double calculateTax() {
        return calculateTotalSalary() * 0.195;
    }
}

class TextFormatter {
    public String formatTitle(String text) {
        return "*** " + text.toUpperCase() + " ***";
    }

    public int countVowels(String text) {
        String vowels = "аоуеиіяюєїaeiou";
        int count = 0;
        String lower = text.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            if (vowels.indexOf(lower.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }
}

class Triangle {
    public double a;
    public double b;
    public double c;

    public boolean isValid() {
        return a + b > c && a + c > b && b + c > a;
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public double getArea() {
        if (!isValid()) {
            return 0.0;
        }
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

class SecretVault {
    private String secretCode = "Pass123";

    public boolean verifyCode(String attempt) {
        return secretCode.equals(attempt);
    }
}

class UserAccount {
    private String username;
    private String password;

    public void setCredentials(String u, String p) {
        username = u;
        password = p;
    }

    public boolean login(String enteredUser, String enteredPass) {
        return username.equals(enteredUser) && password.equals(enteredPass);
    }

    public void changePassword(String oldPass, String newPass) {
        if (password.equals(oldPass)) {
            password = newPass;
            System.out.println("Пароль змінено.");
        } else {
            System.out.println("Помилка: старий пароль невірний!");
        }
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }
}

class Thermometer {
    private double temperature;

    public void setTemperature(double t) {
        if (t < -273.15) {
            System.out.println("Помилка: температура нижче абсолютного нуля!");
        } else {
            temperature = t;
        }
    }

    public double getTemperature() {
        return temperature;
    }
}

class CarSpeedometer {
    private int speed = 0;

    public void accelerate(int delta) {
        speed += delta;
        if (speed > 240) {
            speed = 240;
        }
    }

    public void brake(int delta) {
        speed -= delta;
        if (speed < 0) {
            speed = 0;
        }
    }

    public int getSpeed() {
        return speed;
    }
}

class Person {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Помилка: некоректний вік " + age);
        }
    }

    public void printSummary() {
        System.out.println("Ім'я: " + name + ", вік: " + age);
    }
}

class DiscountCard {
    private String ownerName;
    private double totalSpent;
    private int discountPercent = 1;

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void addPurchase(double cost) {
        totalSpent += cost;
        if (totalSpent >= 10000) {
            discountPercent = 10;
        } else if (totalSpent >= 5000) {
            discountPercent = 5;
        } else {
            discountPercent = 1;
        }
    }

    public void printCardInfo() {
        System.out.println("Власник: " + ownerName + ", витрачено: " + totalSpent + " грн, знижка: " + discountPercent + "%");
    }
}

class SmartDoorLock {
    private int pinCode = 1234;
    private boolean isLocked = true;
    private int failedAttempts = 0;

    public void enterPin(int enteredPin) {
        if (failedAttempts >= 3) {
            System.out.println("СИСТЕМА ЗАБЛОКОВАНА! Викличте охорону.");
        } else if (enteredPin == pinCode) {
            isLocked = false;
            failedAttempts = 0;
            System.out.println("Замок відчинено.");
        } else {
            failedAttempts++;
            System.out.println("Невірний PIN. Спроба " + failedAttempts + " з 3.");
        }
    }
}

class GradeBook {
    private String studentName;
    private int[] grades;

    public void setData(String name, int[] g) {
        studentName = name;
        grades = g;
    }

    public double getAverage() {
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.length;
    }

    public int getHighestGrade() {
        int max = grades[0];
        for (int g : grades) {
            if (g > max) {
                max = g;
            }
        }
        return max;
    }

    public int getLowestGrade() {
        int min = grades[0];
        for (int g : grades) {
            if (g < min) {
                min = g;
            }
        }
        return min;
    }
}

class ArrayStats {
    private int[] numbers;

    public void setNumbers(int[] nums) {
        numbers = nums;
    }

    public int countEvens() {
        int count = 0;
        for (int n : numbers) {
            if (n % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public int countOdds() {
        return numbers.length - countEvens();
    }

    public int calculateSum() {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }
}

class ShoppingCart {
    private double[] itemPrices = new double[10];
    private int count = 0;

    public void addItem(double price) {
        if (count < itemPrices.length) {
            itemPrices[count] = price;
            count++;
        } else {
            System.out.println("Кошик повний!");
        }
    }

    public double getTotalCost() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += itemPrices[i];
        }
        return sum;
    }

    public void applyDiscount(double percent) {
        for (int i = 0; i < count; i++) {
            itemPrices[i] = itemPrices[i] * (1 - percent / 100);
        }
    }
}

class TemperatureTracker {
    private double[] dailyTemps = new double[7];

    public void setTemps(double[] temps) {
        dailyTemps = temps;
    }

    public int countDaysAbove(double threshold) {
        int count = 0;
        for (double t : dailyTemps) {
            if (t > threshold) {
                count++;
            }
        }
        return count;
    }

    public void printWeeklyReport() {
        int maxIndex = 0;
        for (int i = 0; i < dailyTemps.length; i++) {
            System.out.println("День " + (i + 1) + ": " + dailyTemps[i] + "°C");
            if (dailyTemps[i] > dailyTemps[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("Найтепліший день: " + (maxIndex + 1) + " (" + dailyTemps[maxIndex] + "°C)");
    }
}

class ArraySearcher {
    private int[] data;

    public void setData(int[] data) {
        this.data = data;
    }

    public boolean contains(int target) {
        return findIndex(target) != -1;
    }

    public int findIndex(int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

class Vector3D {
    private double[] coords = new double[3];

    public void setCoords(double x, double y, double z) {
        coords[0] = x;
        coords[1] = y;
        coords[2] = z;
    }

    public double getMagnitude() {
        return Math.sqrt(coords[0] * coords[0] + coords[1] * coords[1] + coords[2] * coords[2]);
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < coords.length; i++) {
            coords[i] *= scalar;
        }
    }

    public void printVector() {
        System.out.println("(" + coords[0] + ", " + coords[1] + ", " + coords[2] + ")");
    }
}

class Matrix2D {
    private int[][] grid;

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public void printMatrix() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int getTotalSum() {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }
        }
        return sum;
    }

    public int getRowSum(int rowIndex) {
        int sum = 0;
        for (int j = 0; j < grid[rowIndex].length; j++) {
            sum += grid[rowIndex][j];
        }
        return sum;
    }
}

class MatrixDiagonals {
    private int[][] matrix;

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getMainDiagonalSum() {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public int getAntiDiagonalSum() {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }

    public boolean isDiagonalSymmetric() {
        return getMainDiagonalSum() == getAntiDiagonalSum();
    }
}
