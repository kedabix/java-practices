package semester1.practice02;

public class Practice02 {
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
        int age = 18;
        double height = 1.85;
        char firstLetter = 'Є';
        boolean isStudent = true;
        System.out.println(age);
        System.out.println(height);
        System.out.println(firstLetter);
        System.out.println(isStudent);
    }

    // Завдання 2
    static void task2() {
        System.out.println("=== Завдання 2 ===");
        byte temperature = -15;
        short currentYear = 2026;
        int cityPopulation = 1200000;
        long worldPopulation = 8100000000L;
        System.out.println(temperature);
        System.out.println(currentYear);
        System.out.println(cityPopulation);
        System.out.println(worldPopulation);
    }

    // Завдання 3
    static void task3() {
        System.out.println("=== Завдання 3 ===");
        float floatValue = 1.1234567f;
        double doubleValue = 1.123456789012345;
        System.out.println(floatValue);
        System.out.println(doubleValue);
        // double зберігає набагато більше знаків після коми, ніж float
    }

    // Завдання 4
    static void task4() {
        System.out.println("=== Завдання 4 ===");
        char symbol1 = 'J';
        char symbol2 = 74;
        char symbol3 = '\u004A';
        System.out.println(symbol1);
        System.out.println(symbol2);
        System.out.println(symbol3);
        // Усі три змінні надрукують літеру J, бо 74 — це код цієї літери в Unicode
    }

    // Завдання 5
    static void task5() {
        System.out.println("=== Завдання 5 ===");
        boolean isJavaFun = true;
        boolean isFishFly = false;
        boolean isSkyBlue = true;
        System.out.println(isJavaFun);
        System.out.println(isFishFly);
        System.out.println(isSkyBlue);
    }

    // Завдання 6
    static void task6() {
        System.out.println("=== Завдання 6 ===");
        final double GRAVITY = 9.81;
        final int DAYS_IN_WEEK = 7;
        final String UNIVERSITY_NAME = "Львівська Політехніка";
        System.out.println(GRAVITY);
        System.out.println(DAYS_IN_WEEK);
        System.out.println(UNIVERSITY_NAME);
        // GRAVITY = 10.0; // помилка компіляції: cannot assign a value to final variable GRAVITY
    }

    // Завдання 7
    static void task7() {
        System.out.println("=== Завдання 7 ===");
        int intVal = 250;
        double doubleVal = intVal;
        System.out.println("int: " + intVal);
        System.out.println("double: " + doubleVal);
    }

    // Завдання 8
    static void task8() {
        System.out.println("=== Завдання 8 ===");
        double priceWithPennies = 49.99;
        int roundedPrice = (int) priceWithPennies;
        System.out.println(roundedPrice);
        // дробова частина відкидається, а не округлюється
    }

    // Завдання 9
    static void task9() {
        System.out.println("=== Завдання 9 ===");
        int firstNumber = 5;
        double userWeight = 72.5;
        String userCity = "Kyiv";
        boolean isValidUser = true;
        System.out.println(firstNumber + ", " + userWeight + ", " + userCity + ", " + isValidUser);
    }

    // Завдання 10
    static void task10() {
        System.out.println("=== Завдання 10 ===");
        String firstName = "Тарас";
        String lastName = "Шевченко";
        int age = 47;
        System.out.println("Мене звати " + firstName + " " + lastName + ", мені " + age + " років.");
    }

    // Завдання 11
    static void task11() {
        System.out.println("=== Завдання 11 ===");
        int a = 10;
        int b = 20;
        System.out.println("Сума без дужок: " + a + b);
        System.out.println("Сума з дужками: " + (a + b));
        // Без дужок вираз обчислюється зліва направо: спочатку "Сума без дужок: " + 10 дає рядок,
        // потім до рядка приєднується 20, тому виходить 1020. У дужках спочатку додаються числа (30).
    }

    // Завдання 12
    static void task12() {
        System.out.println("=== Завдання 12 ===");
        String login = "ivan.petrenko";
        String domain = "gmail.com";
        String role = "student";
        String email = login + "@" + domain;
        System.out.println("Користувач " + login + " (роль: " + role + ") має пошту: " + email);
    }

    // Завдання 13
    static void task13() {
        System.out.println("=== Завдання 13 ===");
        String productName = "Ноутбук";
        int quantity = 2;
        double pricePerUnit = 24500.50;
        System.out.println("ЧЕК:\nТовар: " + productName + "\nКількість: " + quantity + " шт.\nЦіна: " + pricePerUnit + " грн");
    }

    // Завдання 14
    static void task14() {
        System.out.println("=== Завдання 14 ===");
        String currency = "UAH";
        int hryvnias = 1500;
        int kopecks = 75;
        System.out.println("Поточний баланс: " + hryvnias + "." + kopecks + " " + currency);
    }

    // Завдання 15
    static void task15() {
        System.out.println("=== Завдання 15 ===");
        String protocol = "https://";
        String host = "api.example.com";
        String endpoint = "/users";
        int userId = 42;
        System.out.println("Запит відправлено на: " + protocol + host + endpoint + "/" + userId);
    }

    // Завдання 16
    static void task16() {
        System.out.println("=== Завдання 16 ===");
        String language = "Java";
        int level = 1;
        boolean isReady = true;
        System.out.println("Мова: " + language + " | Рівень: " + level + " | Готовність до практики: " + isReady);
    }

    // Завдання 17
    static void task17() {
        System.out.println("=== Завдання 17 ===");
        int number = 19;
        int remainder = number % 2;
        System.out.println("Число " + number + " при діленні на 2 дає остачу: " + remainder);
    }

    // Завдання 18
    static void task18() {
        System.out.println("=== Завдання 18 ===");
        int totalSeconds = 385;
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        System.out.println(totalSeconds + " секунд = " + minutes + " хв " + seconds + " сек");
    }

    // Завдання 19
    static void task19() {
        System.out.println("=== Завдання 19 ===");
        int n = 47;
        int tens = n / 10;
        int units = n % 10;
        System.out.println("Число: " + n + ". Десятки: " + tens + ", Одиниці: " + units + ". Сума цифр: " + (tens + units));
    }

    // Завдання 20
    static void task20() {
        System.out.println("=== Завдання 20 ===");
        int score = 100;
        score += 50;
        System.out.println("Після додавання: " + score);
        score -= 20;
        System.out.println("Після віднімання: " + score);
        score *= 2;
        System.out.println("Після множення: " + score);
        score /= 4;
        System.out.println("Після ділення: " + score);
    }

    // Завдання 21
    static void task21() {
        System.out.println("=== Завдання 21 ===");
        int counter = 5;
        System.out.println(counter++);
        System.out.println(counter);
        // Постфіксний інкремент спочатку повертає старе значення (5), а збільшує змінну вже після цього
    }

    // Завдання 22
    static void task22() {
        System.out.println("=== Завдання 22 ===");
        int counter = 5;
        System.out.println(++counter);
        // Префіксний інкремент спочатку збільшує змінну, тому одразу виводиться 6
    }

    // Завдання 23
    static void task23() {
        System.out.println("=== Завдання 23 ===");
        int grade1 = 4;
        int grade2 = 5;
        int grade3 = 4;
        double average = (grade1 + grade2 + grade3) / 3.0;
        System.out.println("Середній бал: " + average);
    }

    // Завдання 24
    static void task24() {
        System.out.println("=== Завдання 24 ===");
        double celsius = 25.0;
        double fahrenheit = celsius * 1.8 + 32;
        double kelvin = celsius + 273.15;
        System.out.println(celsius + "°C = " + fahrenheit + "°F");
        System.out.println(celsius + "°C = " + kelvin + " K");
    }

    // Завдання 25
    static void task25() {
        System.out.println("=== Завдання 25 ===");
        int userAge = 17;
        boolean isAdult = userAge >= 18;
        System.out.println("Вік: " + userAge + ". Чи є повнолітнім: " + isAdult);
    }

    // Завдання 26
    static void task26() {
        System.out.println("=== Завдання 26 ===");
        int x = 15;
        int y = 20;
        System.out.println("x == y: " + (x == y));
        System.out.println("x != y: " + (x != y));
        System.out.println("x > y: " + (x > y));
    }

    // Завдання 27
    static void task27() {
        System.out.println("=== Завдання 27 ===");
        int speed = 75;
        boolean isSafeSpeed = (speed >= 20) && (speed <= 80);
        System.out.println("Безпечна швидкість: " + isSafeSpeed);
    }

    // Завдання 28
    static void task28() {
        System.out.println("=== Завдання 28 ===");
        int personAge = 70;
        boolean hasFreePass = (personAge < 7) || (personAge >= 65);
        System.out.println("Вік: " + personAge + ". Право на безкоштовний проїзд: " + hasFreePass);
    }

    // Завдання 29
    static void task29() {
        System.out.println("=== Завдання 29 ===");
        boolean isDoorLocked = true;
        boolean canEnter = !isDoorLocked;
        System.out.println("Двері зачинені: " + isDoorLocked);
        System.out.println("Чи можна увійти: " + canEnter);
    }

    // Завдання 30
    static void task30() {
        System.out.println("=== Завдання 30 ===");
        int number = 30;
        boolean isDivisibleByBoth = (number % 3 == 0) && (number % 5 == 0);
        System.out.println("Число " + number + " ділиться на 3 і на 5: " + isDivisibleByBoth);
        number = 25;
        isDivisibleByBoth = (number % 3 == 0) && (number % 5 == 0);
        System.out.println("Число " + number + " ділиться на 3 і на 5: " + isDivisibleByBoth);
    }

    // Завдання 31
    static void task31() {
        System.out.println("=== Завдання 31 ===");
        boolean hasPassword = true;
        boolean hasSmsCode = true;
        boolean isAccountBlocked = false;
        boolean canLogin = hasPassword && hasSmsCode && !isAccountBlocked;
        System.out.println("Вхід дозволено: " + canLogin);
    }

    // Завдання 32
    static void task32() {
        System.out.println("=== Завдання 32 ===");
        int year = 2024;
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println("Рік " + year + " високосний: " + isLeapYear);
    }

    // Завдання 33
    static void task33() {
        System.out.println("=== Завдання 33 ===");
        double a = 3.0;
        double b = 4.0;
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("Катети: " + a + " та " + b + ". Гіпотенуза: " + c);
    }

    // Завдання 34
    static void task34() {
        System.out.println("=== Завдання 34 ===");
        double radius = 5.0;
        double length = 2 * Math.PI * radius;
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("Радіус: " + radius);
        System.out.println("Довжина кола: " + length);
        System.out.println("Площа круга: " + area);
    }

    // Завдання 35
    static void task35() {
        System.out.println("=== Завдання 35 ===");
        double dayTemp = 18.5;
        double nightTemp = -3.2;
        System.out.println("Перепад температури: " + Math.abs(dayTemp - nightTemp));
        System.out.println("Максимальна температура: " + Math.max(dayTemp, nightTemp));
        System.out.println("Мінімальна температура: " + Math.min(dayTemp, nightTemp));
    }

    // Завдання 36
    static void task36() {
        System.out.println("=== Завдання 36 ===");
        double num = 5.67;
        System.out.println("round: " + Math.round(num));
        System.out.println("ceil: " + Math.ceil(num));
        System.out.println("floor: " + Math.floor(num));
        double negNum = -5.67;
        System.out.println("round: " + Math.round(negNum));
        System.out.println("ceil: " + Math.ceil(negNum));
        System.out.println("floor: " + Math.floor(negNum));
        // Для від'ємного числа ceil дає -5.0 (вгору, до нуля), а floor дає -6.0 (вниз)
    }

    // Завдання 37
    static void task37() {
        System.out.println("=== Завдання 37 ===");
        double a = 1.0;
        double b = -7.0;
        double c = 10.0;
        double d = Math.pow(b, 2) - 4 * a * c;
        double x1 = (-b + Math.sqrt(d)) / (2 * a);
        double x2 = (-b - Math.sqrt(d)) / (2 * a);
        System.out.println("Дискримінант D = " + d);
        System.out.println("Корінь x1 = " + x1);
        System.out.println("Корінь x2 = " + x2);
    }

    // Завдання 38
    static void task38() {
        System.out.println("=== Завдання 38 ===");
        int dice = (int) (Math.random() * 6) + 1;
        System.out.println("Випало на кубику: " + dice);
    }

    // Завдання 39
    static void task39() {
        System.out.println("=== Завдання 39 ===");
        int min = -10;
        int max = 35;
        int randomTemp = (int) (Math.random() * (max - min + 1)) + min;
        System.out.println("Погода на завтра: " + randomTemp + "°C");
    }

    // Завдання 40
    static void task40() {
        System.out.println("=== Завдання 40 ===");
        double principal = 10000.0;
        double rate = 12.0;
        int years = 3;
        double total = principal * Math.pow(1 + rate / 100, years);
        total = Math.round(total * 100) / 100.0;
        double profit = Math.round((total - principal) * 100) / 100.0;
        System.out.println("+------------------------------------+");
        System.out.println("|     ДЕПОЗИТНИЙ КАЛЬКУЛЯТОР         |");
        System.out.println("+------------------------------------+");
        System.out.println("Початкова сума: " + principal + " грн");
        System.out.println("Термін: " + years + " роки під " + rate + "% річних");
        System.out.println("Підсумкова сума: " + total + " грн");
        System.out.println("Чистий прибуток: " + profit + " грн");
        System.out.println("+------------------------------------+");
    }
}
