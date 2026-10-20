package semester1.practice03;

import java.util.Locale;
import java.util.Scanner;

public class Practice03 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        scanner.useLocale(Locale.US); // щоб дробові числа вводились через крапку
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
        scanner.close();
    }

    // Завдання 1
    static void task1() {
        System.out.println("=== Завдання 1 ===");
        System.out.print("Введіть ім'я: ");
        String firstName = scanner.nextLine();
        System.out.print("Введіть прізвище: ");
        String lastName = scanner.nextLine();
        System.out.print("Введіть вік: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введіть місто: ");
        String city = scanner.nextLine();
        System.out.println("=== ВХІДНІ ДАНІ ===");
        System.out.println("Ім'я: " + firstName);
        System.out.println("Прізвище: " + lastName);
        System.out.println("Вік: " + age);
        System.out.println("Місто: " + city);
        System.out.println("-------------------");
        System.out.println("Привіт, " + firstName + " " + lastName + " з міста " + city + "! Твій вік: " + age + " р.");
    }

    // Завдання 2
    static void task2() {
        System.out.println("=== Завдання 2 ===");
        System.out.print("Введіть перше число: ");
        int a = scanner.nextInt();
        System.out.print("Введіть друге число: ");
        int b = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Сума: " + (a + b));
        System.out.println("Різниця: " + (a - b));
        System.out.println("Добуток: " + (a * b));
        if (b == 0) {
            System.out.println("Остача від ділення: неможливо обчислити (ділення на нуль)");
        } else {
            System.out.println("Остача від ділення: " + (a % b));
        }
    }

    // Завдання 3
    static void task3() {
        System.out.println("=== Завдання 3 ===");
        System.out.print("Введіть суму в гривнях (UAH): ");
        double uah = scanner.nextDouble();
        System.out.print("Введіть курс USD: ");
        double rate = scanner.nextDouble();
        scanner.nextLine();
        double usd = Math.round(uah / rate * 100) / 100.0;
        System.out.println("Сума до видачі: " + usd + " USD");
    }

    // Завдання 4
    static void task4() {
        System.out.println("=== Завдання 4 ===");
        System.out.print("Введіть номер квитка: ");
        int ticket = scanner.nextInt();
        scanner.nextLine(); // очищаємо залишковий \n з буфера
        System.out.print("Введіть повне ім'я студента: ");
        String fullName = scanner.nextLine();
        System.out.print("Введіть спеціальність: ");
        String speciality = scanner.nextLine();
        System.out.println("Студент: " + fullName + ", квиток №" + ticket + ", спеціальність: " + speciality);
    }

    // Завдання 5
    static void task5() {
        System.out.println("=== Завдання 5 ===");
        System.out.print("Ваш зріст (м): ");
        double height = scanner.nextDouble();
        System.out.print("Ваша вага (кг): ");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        double bmi = weight / (height * height);
        System.out.println("Розрахований BMI: " + Math.round(bmi * 100) / 100.0);
    }

    // Завдання 6
    static void task6() {
        System.out.println("=== Завдання 6 ===");
        System.out.print("Введіть символ: ");
        char ch = scanner.next().charAt(0);
        scanner.nextLine();
        System.out.println("Символ: " + ch + " | Код символу: " + (int) ch);
    }

    // Завдання 7
    static void task7() {
        System.out.println("=== Завдання 7 ===");
        System.out.print("Катет A: ");
        double a = scanner.nextDouble();
        System.out.print("Катет B: ");
        double b = scanner.nextDouble();
        scanner.nextLine();
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("Гіпотенуза: " + c);
        System.out.println("Периметр: " + (a + b + c));
        System.out.println("Площа: " + (a * b / 2));
    }

    // Завдання 8
    static void task8() {
        System.out.println("=== Завдання 8 ===");
        System.out.print("Товар: ");
        String name = scanner.nextLine();
        System.out.print("Ціна: ");
        double price = scanner.nextDouble();
        System.out.print("Кількість: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        double total = price * count;
        double vat = total * 0.2;
        System.out.println("Товар: " + name);
        System.out.println("Загальна сума: " + total + " грн (з них ПДВ 20%: " + vat + " грн)");
    }

    // Завдання 9
    static void task9() {
        System.out.println("=== Завдання 9 ===");
        System.out.print("Введіть число: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        if (n > 0) {
            System.out.println("Число додатне.");
        } else if (n < 0) {
            System.out.println("Число від'ємне.");
        } else {
            System.out.println("Число дорівнює нулю.");
        }
    }

    // Завдання 10
    static void task10() {
        System.out.println("=== Завдання 10 ===");
        System.out.print("Введіть число: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        if (number == 0) {
            System.out.println("Число є нулем");
        } else if (number % 2 == 0) {
            System.out.println("Число " + number + " є парним.");
        } else {
            System.out.println("Число " + number + " є непарним.");
        }
    }

    // Завдання 11
    static void task11() {
        System.out.println("=== Завдання 11 ===");
        System.out.print("Введіть вік: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        if (age < 0 || age > 120) {
            System.out.println("Некоректний вік");
        } else if (age <= 12) {
            System.out.println("Дитина");
        } else if (age <= 17) {
            System.out.println("Підліток");
        } else if (age <= 64) {
            System.out.println("Дорослий");
        } else {
            System.out.println("Пенсіонер");
        }
    }

    // Завдання 12
    static void task12() {
        System.out.println("=== Завдання 12 ===");
        System.out.print("Введіть підсумковий бал (0-100): ");
        int score = scanner.nextInt();
        scanner.nextLine();
        if (score < 0 || score > 100) {
            System.out.println("Помилка: некоректний бал!");
        } else if (score >= 90) {
            System.out.println("Відмінно (A)");
        } else if (score >= 82) {
            System.out.println("Дуже добре (B)");
        } else if (score >= 74) {
            System.out.println("Добре (C)");
        } else if (score >= 64) {
            System.out.println("Задовільно (D)");
        } else if (score >= 60) {
            System.out.println("Достатньо (E)");
        } else {
            System.out.println("Незадовільно (F)");
        }
    }

    // Завдання 13
    static void task13() {
        System.out.println("=== Завдання 13 ===");
        System.out.print("Введіть 3 числа: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        System.out.println("Максимум: " + max);
        System.out.println("Мінімум: " + min);
    }

    // Завдання 14
    static void task14() {
        System.out.println("=== Завдання 14 ===");
        System.out.print("Введіть X: ");
        double x = scanner.nextDouble();
        System.out.print("Введіть Y: ");
        double y = scanner.nextDouble();
        scanner.nextLine();
        if (x == 0 && y == 0) {
            System.out.println("Точка в початку координат.");
        } else if (x == 0 || y == 0) {
            System.out.println("Точка лежить на осі координат.");
        } else if (x > 0 && y > 0) {
            System.out.println("Точка (" + x + "; " + y + ") знаходиться у I чверті.");
        } else if (x < 0 && y > 0) {
            System.out.println("Точка (" + x + "; " + y + ") знаходиться у II чверті.");
        } else if (x < 0 && y < 0) {
            System.out.println("Точка (" + x + "; " + y + ") знаходиться у III чверті.");
        } else {
            System.out.println("Точка (" + x + "; " + y + ") знаходиться у IV чверті.");
        }
    }

    // Завдання 15
    static void task15() {
        System.out.println("=== Завдання 15 ===");
        int x = 5;
        int y = 20;
        // Без фігурних дужок else прив'язується до найближчого if (y > 10), а не до if (x > 10)
        if (x > 10)
            if (y > 10)
                System.out.println("x > 10 і y > 10");
            else
                System.out.println("Цей else належить до внутрішнього if (y > 10)");
        // Правильний варіант: дужки чітко показують, що else належить до зовнішнього if (x > 10)
        if (x > 10) {
            if (y > 10) {
                System.out.println("x > 10 і y > 10");
            }
        } else {
            System.out.println("x не більше 10 (else належить до зовнішнього if)");
        }
    }

    // Завдання 16
    static void task16() {
        System.out.println("=== Завдання 16 ===");
        System.out.print("Введіть спожито кВт·год: ");
        int kwh = scanner.nextInt();
        scanner.nextLine();
        double sum;
        if (kwh <= 100) {
            sum = kwh * 2.64;
        } else {
            sum = 100 * 2.64 + (kwh - 100) * 4.32;
        }
        System.out.println("Спожито: " + kwh + " кВт·год");
        System.out.println("Сума до сплати: " + Math.round(sum * 100) / 100.0 + " грн");
    }

    // Завдання 17
    static void task17() {
        System.out.println("=== Завдання 17 ===");
        System.out.print("Введіть x і y: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.nextLine();
        int max = (x > y) ? x : y;
        System.out.println("Більше число: " + max);
    }

    // Завдання 18
    static void task18() {
        System.out.println("=== Завдання 18 ===");
        System.out.print("Введіть число n: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        int abs = (n < 0) ? -n : n;
        System.out.println("Модуль числа: " + abs);
    }

    // Завдання 19
    static void task19() {
        System.out.println("=== Завдання 19 ===");
        System.out.print("Введіть число: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String result = (n % 2 == 0) ? "Парне" : "Непарне";
        System.out.println(result);
    }

    // Завдання 20
    static void task20() {
        System.out.println("=== Завдання 20 ===");
        System.out.print("Введіть бал: ");
        int score = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Результат: " + (score >= 60 ? "Зараховано" : "Незараховано"));
    }

    // Завдання 21
    static void task21() {
        System.out.println("=== Завдання 21 ===");
        System.out.print("Введіть число: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String status = (n > 0) ? "Додатне" : (n < 0) ? "Від'ємне" : "Нуль";
        System.out.println(status);
    }

    // Завдання 22
    static void task22() {
        System.out.println("=== Завдання 22 ===");
        System.out.print("Сума покупки: ");
        double sum = scanner.nextDouble();
        scanner.nextLine();
        double finalSum = (sum > 1000) ? sum * 0.9 : sum * 0.98;
        System.out.println("До сплати зі знижкою: " + finalSum + " грн");
    }

    // Завдання 23
    static void task23() {
        System.out.println("=== Завдання 23 ===");
        System.out.print("Введіть ділене a: ");
        int a = scanner.nextInt();
        System.out.print("Введіть дільник b: ");
        int b = scanner.nextInt();
        scanner.nextLine();
        String result = (b != 0) ? "Результат: " + ((double) a / b) : "Помилка: ділення на нуль неможливе!";
        System.out.println(result);
    }

    // Завдання 24
    static void task24() {
        System.out.println("=== Завдання 24 ===");
        System.out.print("Кількість помилок: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        String text = (count == 1) ? "Знайдено 1 помилку" : "Знайдено " + count + " помилок";
        System.out.println(text);
    }

    // Завдання 25
    static void task25() {
        System.out.println("=== Завдання 25 ===");
        int x = 10;
        int divisor = 0;
        if (divisor != 0 && (x / divisor > 1)) {
            System.out.println("Успішне ділення");
        } else {
            System.out.println("Ділення безпечно пропущено завдяки short-circuit!");
        }
        // Оператор && не обчислює праву частину, якщо ліва вже false (divisor != 0 — false),
        // тому ділення на нуль не виконується і ArithmeticException не виникає
    }

    // Завдання 26
    static void task26() {
        System.out.println("=== Завдання 26 ===");
        int counter1 = 0;
        int counter2 = 0;
        boolean b1 = false && (++counter1 > 0);
        boolean b2 = false & (++counter2 > 0);
        System.out.println("counter1 = " + counter1 + ", b1 = " + b1);
        System.out.println("counter2 = " + counter2 + ", b2 = " + b2);
        // && ліниве: права частина не обчислюється, тому counter1 залишився 0.
        // & обчислює обидві частини завжди, тому counter2 став 1.
    }

    // Завдання 27
    static void task27() {
        System.out.println("=== Завдання 27 ===");
        int number = 5;
        if (number > 0 || (10 / 0 == 0)) {
            System.out.println("Умова виконана, аварійне ділення не викликалося!");
        }
        // Оператор || при true у лівій частині вже знає результат, тому права частина (10 / 0) не виконується
    }

    // Завдання 28
    static void task28() {
        System.out.println("=== Завдання 28 ===");
        int counterA = 0;
        int counterB = 0;
        boolean test1 = true || (++counterA > 0);
        boolean test2 = true | (++counterB > 0);
        System.out.println("counterA = " + counterA + ", test1 = " + test1);
        System.out.println("counterB = " + counterB + ", test2 = " + test2);
        // || ліниве (counterA = 0), а | жадібне і завжди обчислює праву частину (counterB = 1)
    }

    // Завдання 29
    static void task29() {
        System.out.println("=== Завдання 29 ===");
        System.out.print("Введіть години (0-23): ");
        int hours = scanner.nextInt();
        System.out.print("Введіть хвилини (0-59): ");
        int minutes = scanner.nextInt();
        scanner.nextLine();
        boolean isValidTime = (hours >= 0 && hours <= 23) && (minutes >= 0 && minutes <= 59);
        if (isValidTime) {
            String h = (hours < 10) ? "0" + hours : "" + hours;
            String m = (minutes < 10) ? "0" + minutes : "" + minutes;
            System.out.println("Час: " + h + ":" + m);
        } else {
            System.out.println("Помилка: некоректний час!");
        }
    }

    // Завдання 30
    static void task30() {
        System.out.println("=== Завдання 30 ===");
        System.out.print("Введіть три сторони a b c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        scanner.nextLine();
        boolean exists = (a + b > c) && (a + c > b) && (b + c > a);
        System.out.println("Сторони: " + a + ", " + b + ", " + c + " -> Трикутник існує: " + exists);
    }

    // Завдання 31
    static void task31() {
        System.out.println("=== Завдання 31 ===");
        System.out.print("Введіть число n: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        boolean isEvenBitwise = (n & 1) == 0;
        boolean isEvenMod = n % 2 == 0;
        System.out.println("Через (n & 1) == 0: " + isEvenBitwise);
        System.out.println("Через n % 2 == 0: " + isEvenMod);
        // n & 1 залишає лише останній двійковий біт: у парних чисел він 0, у непарних 1
    }

    // Завдання 32
    static void task32() {
        System.out.println("=== Завдання 32 ===");
        boolean isPinCorrect = true;
        boolean isCardActive = true;
        double balance = 5000;
        double amount = 1500;
        boolean hasSufficientBalance = balance >= amount;
        boolean isDailyLimitExceeded = false;
        boolean allowed = isPinCorrect && isCardActive && hasSufficientBalance && !isDailyLimitExceeded;
        System.out.println("Транзакцію дозволено: " + allowed);
    }

    // Завдання 33
    static void task33() {
        System.out.println("=== Завдання 33 ===");
        System.out.print("Введіть номер дня (1-7): ");
        int day = scanner.nextInt();
        scanner.nextLine();
        switch (day) {
            case 1:
                System.out.println("Понеділок");
                break;
            case 2:
                System.out.println("Вівторок");
                break;
            case 3:
                System.out.println("Середа");
                break;
            case 4:
                System.out.println("Четвер");
                break;
            case 5:
                System.out.println("П'ятниця");
                break;
            case 6:
                System.out.println("Субота");
                break;
            case 7:
                System.out.println("Неділя");
                break;
            default:
                System.out.println("Некоректний номер дня");
        }
    }

    // Завдання 34
    static void task34() {
        System.out.println("=== Завдання 34 ===");
        System.out.print("Введіть номер дня (1-7): ");
        int day = scanner.nextInt();
        scanner.nextLine();
        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Будній (робочий) день");
                break;
            case 6:
            case 7:
                System.out.println("Вихідний день");
                break;
            default:
                System.out.println("Некоректний номер дня");
        }
    }

    // Завдання 35
    static void task35() {
        System.out.println("=== Завдання 35 ===");
        System.out.print("Введіть номер місяця (1-12): ");
        int month = scanner.nextInt();
        scanner.nextLine();
        int days = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> 0;
        };
        if (days == 0) {
            System.out.println("Такого місяця не існує");
        } else {
            System.out.println("Кількість днів: " + days);
        }
    }

    // Завдання 36
    static void task36() {
        System.out.println("=== Завдання 36 ===");
        System.out.print("Введіть місяць: ");
        String month = scanner.nextLine();
        String season = switch (month.toLowerCase()) {
            case "грудень", "січень", "лютий" -> "Зима";
            case "березень", "квітень", "травень" -> "Весна";
            case "червень", "липень", "серпень" -> "Літо";
            case "вересень", "жовтень", "листопад" -> "Осінь";
            default -> "Невідомий місяць";
        };
        System.out.println("Пора року: " + season);
    }

    // Завдання 37
    static void task37() {
        System.out.println("=== Завдання 37 ===");
        System.out.print("Спосіб доставки (1 - Самовивіз, 2 - Кур'єр, 3 - Поштомат): ");
        int type = scanner.nextInt();
        System.out.print("Вага товару (кг): ");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        int cost = switch (type) {
            case 1 -> 0;
            case 2 -> {
                if (weight > 5) {
                    yield 150;
                } else {
                    yield 90;
                }
            }
            case 3 -> 60;
            default -> -1;
        };
        if (cost == -1) {
            System.out.println("Некоректний вибір");
        } else {
            System.out.println("Вартість доставки: " + cost + " грн");
        }
    }

    // Завдання 38
    static void task38() {
        System.out.println("=== Завдання 38 ===");
        System.out.print("Число 1: ");
        double a = scanner.nextDouble();
        System.out.print("Оберіть операцію (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        System.out.print("Число 2: ");
        double b = scanner.nextDouble();
        scanner.nextLine();
        boolean error = false;
        double result = switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) {
                    error = true;
                    yield 0;
                } else {
                    yield a / b;
                }
            }
            default -> {
                error = true;
                yield 0;
            }
        };
        if (error) {
            System.out.println("Помилка: ділення на нуль або невідома операція!");
        } else {
            System.out.println("Результат: " + result);
        }
    }

    // Завдання 39
    static void task39() {
        System.out.println("=== Завдання 39 ===");
        System.out.print("Введіть команду (start, pause, stop, exit): ");
        String command = scanner.nextLine();
        // Оператор == порівнює посилання (адреси об'єктів), а рядок зі Scanner — це новий об'єкт,
        // тому command == "start" майже завжди false навіть при однаковому тексті
        System.out.println("command == \"start\": " + (command == "start"));
        System.out.println("equalsIgnoreCase: " + command.equalsIgnoreCase("start"));
        switch (command.toLowerCase()) {
            case "start" -> System.out.println("Система успішно запущена!");
            case "pause" -> System.out.println("Систему призупинено.");
            case "stop" -> System.out.println("Систему зупинено.");
            case "exit" -> System.out.println("Вихід з програми.");
            default -> System.out.println("Невідома команда!");
        }
    }

    // Завдання 40
    static void task40() {
        System.out.println("=== Завдання 40 ===");
        System.out.println("================ БАНКОМАТ ================");
        System.out.print("Введіть PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine();
        if (pin != 1234) {
            System.out.println("Невірний PIN. Роботу завершено.");
            return;
        }
        System.out.println("Авторизація успішна!");
        double balance = 5000.0;
        boolean working = true;
        while (working) {
            System.out.print("Оберіть дію (1 - Баланс, 2 - Поповнення, 3 - Зняття, 4 - Вихід): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> System.out.println("Ваш баланс: " + balance + " грн");
                case 2 -> {
                    System.out.print("Введіть суму поповнення: ");
                    double sum = scanner.nextDouble();
                    scanner.nextLine();
                    if (sum > 0) {
                        balance += sum;
                        System.out.println("Рахунок поповнено. Баланс: " + balance + " грн");
                    } else {
                        System.out.println("Некоректна сума!");
                    }
                }
                case 3 -> {
                    System.out.print("Введіть суму зняття: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    double fee = (amount > 1000) ? amount * 0.01 : 0;
                    if (amount > 0 && amount + fee <= balance) {
                        balance = balance - amount - fee;
                        System.out.println("Комісія операції: " + fee + " грн");
                        System.out.println("Видано: " + amount + " грн. Залишок на рахунку: " + balance + " грн");
                    } else {
                        System.out.println("Недостатньо коштів або некоректна сума!");
                    }
                }
                case 4 -> {
                    working = false;
                    System.out.println("Дякуємо, що скористались банкоматом!");
                }
                default -> System.out.println("Невідома команда!");
            }
        }
        System.out.println("==========================================");
    }
}
