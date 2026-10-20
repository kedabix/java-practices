package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        scanner.useLocale(Locale.US);
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
        for (int i = 0; i < 7; i++) {
            System.out.println("Java - надійна та кросплатформна мова!");
        }
    }

    // Завдання 2
    static void task2() {
        System.out.println("=== Завдання 2 ===");
        System.out.print("Введіть текст: ");
        String text = scanner.nextLine();
        System.out.print("Введіть N: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= n; i++) {
            System.out.println("[" + i + "] " + text);
        }
    }

    // Завдання 3
    static void task3() {
        System.out.println("=== Завдання 3 ===");
        int balance = 0;
        for (int month = 1; month <= 12; month++) {
            balance += 500;
            System.out.println("Місяць " + month + ": " + balance + " грн");
        }
    }

    // Завдання 4
    static void task4() {
        System.out.println("=== Завдання 4 ===");
        System.out.print("Введіть курс євро до гривні: ");
        double rate = scanner.nextDouble();
        scanner.nextLine();
        for (int euro = 10; euro <= 100; euro += 10) {
            System.out.println(euro + " EUR = " + (euro * rate) + " UAH");
        }
    }

    // Завдання 5
    static void task5() {
        System.out.println("=== Завдання 5 ===");
        System.out.print("Введіть ширину рамки W: ");
        int w = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < w; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    // Завдання 6
    static void task6() {
        System.out.println("=== Завдання 6 ===");
        int i = 10;
        while (i >= 1) {
            System.out.println(i);
            i--;
        }
        System.out.println("Поїхали! Ракета запущена!");
    }

    // Завдання 7
    static void task7() {
        System.out.println("=== Завдання 7 ===");
        int sum = 0;
        System.out.print("Вводьте числа (0 - кінець): ");
        int number = scanner.nextInt();
        while (number != 0) {
            sum += number;
            number = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.println("Сума: " + sum);
    }

    // Завдання 8
    static void task8() {
        System.out.println("=== Завдання 8 ===");
        System.out.print("Введіть число M: ");
        int m = scanner.nextInt();
        scanner.nextLine();
        int power = 1;
        while (power <= m) {
            System.out.print(power + " ");
            power *= 2;
        }
        System.out.println();
    }

    // Завдання 9
    static void task9() {
        System.out.println("=== Завдання 9 ===");
        int n = 7425;
        int count = 0;
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
            count++;
        }
        System.out.println("Кількість цифр: " + count);
        System.out.println("Сума цифр: " + sum);
    }

    // Завдання 10
    static void task10() {
        System.out.println("=== Завдання 10 ===");
        int n = 12345;
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        System.out.println("Перевернуте число: " + reversed);
    }

    // Завдання 11
    static void task11() {
        System.out.println("=== Завдання 11 ===");
        System.out.print("Введіть суму внеску S: ");
        double s = scanner.nextDouble();
        System.out.print("Введіть відсоток P: ");
        double p = scanner.nextDouble();
        scanner.nextLine();
        if (s <= 0 || p <= 0) {
            System.out.println("Помилка: S і P мають бути додатними!");
            return;
        }
        double current = s;
        int years = 0;
        while (current < s * 2) {
            current = current * (1 + p / 100);
            years++;
        }
        System.out.println("Сума подвоїться через " + years + " р.");
    }

    // Завдання 12
    static void task12() {
        System.out.println("=== Завдання 12 ===");
        System.out.print("Введіть число N (> 1): ");
        int n = scanner.nextInt();
        scanner.nextLine();
        if (n <= 1) {
            System.out.println("Помилка: N має бути більше 1!");
            return;
        }
        int d = 2;
        while (n % d != 0) {
            d++;
        }
        System.out.println("Найменший дільник: " + d);
    }

    // Завдання 13
    static void task13() {
        System.out.println("=== Завдання 13 ===");
        int secret = (int) (Math.random() * 100) + 1;
        int attempts = 0;
        int guess = 0;
        while (guess != secret) {
            System.out.print("Ваша здогадка: ");
            guess = scanner.nextInt();
            attempts++;
            if (guess < secret) {
                System.out.println("Більше!");
            } else if (guess > secret) {
                System.out.println("Менше!");
            }
        }
        scanner.nextLine();
        System.out.println("Вгадали за " + attempts + " спроб!");
    }

    // Завдання 14
    static void task14() {
        System.out.println("=== Завдання 14 ===");
        int choice;
        do {
            System.out.println("1. Розпочати нову гру");
            System.out.println("2. Завантажити збереження");
            System.out.println("3. Налаштування");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Нова гра розпочата!");
            } else if (choice == 2) {
                System.out.println("Збереження завантажено.");
            } else if (choice == 3) {
                System.out.println("Налаштування відкрито.");
            } else if (choice != 0) {
                System.out.println("Невірний пункт меню!");
            }
        } while (choice != 0);
        scanner.nextLine();
        System.out.println("Вихід.");
    }

    // Завдання 15
    static void task15() {
        System.out.println("=== Завдання 15 ===");
        int age;
        do {
            System.out.print("Введіть вік (1-120): ");
            age = scanner.nextInt();
        } while (age < 1 || age > 120);
        scanner.nextLine();
        System.out.println("Вік підтверджено: " + age);
    }

    // Завдання 16
    static void task16() {
        System.out.println("=== Завдання 16 ===");
        int attempts = 0;
        int pin;
        boolean ok = false;
        do {
            System.out.print("Введіть PIN: ");
            pin = scanner.nextInt();
            attempts++;
            if (pin == 1234) {
                ok = true;
            }
        } while (!ok && attempts < 3);
        scanner.nextLine();
        if (ok) {
            System.out.println("Доступ надано");
        } else {
            System.out.println("Карту заблоковано!");
        }
    }

    // Завдання 17
    static void task17() {
        System.out.println("=== Завдання 17 ===");
        char answer;
        do {
            System.out.print("Введіть два числа для додавання: ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Сума: " + (a + b));
            System.out.print("Бажаєте продовжити? (y/n): ");
            answer = scanner.next().charAt(0);
        } while (answer == 'y');
        scanner.nextLine();
    }

    // Завдання 18
    static void task18() {
        System.out.println("=== Завдання 18 ===");
        int dice1;
        int dice2;
        int attempts = 0;
        do {
            dice1 = (int) (Math.random() * 6) + 1;
            dice2 = (int) (Math.random() * 6) + 1;
            attempts++;
            System.out.println("Кидок " + attempts + ": " + dice1 + " і " + dice2);
        } while (dice1 != dice2);
        System.out.println("Дубль випав за " + attempts + " спроб!");
    }

    // Завдання 19
    static void task19() {
        System.out.println("=== Завдання 19 ===");
        System.out.print("Введіть чисельник: ");
        int a = scanner.nextInt();
        int b;
        do {
            System.out.print("Введіть знаменник (не 0): ");
            b = scanner.nextInt();
        } while (b == 0);
        scanner.nextLine();
        System.out.println("Результат: " + ((double) a / b));
    }

    // Завдання 20
    static void task20() {
        System.out.println("=== Завдання 20 ===");
        int sum = 0;
        int count = 0;
        int score;
        do {
            do {
                System.out.print("Введіть бал (0-100, від'ємне - кінець): ");
                score = scanner.nextInt();
            } while (score > 100);
            if (score >= 0) {
                sum += score;
                count++;
            }
        } while (score >= 0);
        scanner.nextLine();
        if (count > 0) {
            System.out.println("Середній бал: " + ((double) sum / count));
        } else {
            System.out.println("Балів не введено.");
        }
    }

    // Завдання 21
    static void task21() {
        System.out.println("=== Завдання 21 ===");
        System.out.print("Введіть A і B: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.nextLine();
        for (int i = a; i <= b; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Завдання 22
    static void task22() {
        System.out.println("=== Завдання 22 ===");
        System.out.print("Введіть N (0-20): ");
        int n = scanner.nextInt();
        scanner.nextLine();
        if (n < 0 || n > 20) {
            System.out.println("Помилка: N має бути в діапазоні від 0 до 20!");
            return;
        }
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println(n + "! = " + factorial);
    }

    // Завдання 23
    static void task23() {
        System.out.println("=== Завдання 23 ===");
        System.out.println("Число\t| Квадрат\t| Куб");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "\t| " + (i * i) + "\t\t| " + (i * i * i));
        }
    }

    // Завдання 24
    static void task24() {
        System.out.println("=== Завдання 24 ===");
        for (int i = 1; i <= 50; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Завдання 25
    static void task25() {
        System.out.println("=== Завдання 25 ===");
        for (int i = 100; i <= 200; i++) {
            if (i % 13 == 0 && i % 7 == 0) {
                System.out.println("Перше число: " + i);
                break;
            }
        }
    }

    // Завдання 26
    static void task26() {
        System.out.println("=== Завдання 26 ===");
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.println(c + " - " + (int) c);
        }
    }

    // Завдання 27
    static void task27() {
        System.out.println("=== Завдання 27 ===");
        System.out.print("Введіть N: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                sum += i;
            } else {
                sum -= i;
            }
        }
        System.out.println("S = " + sum);
    }

    // Завдання 28
    static void task28() {
        System.out.println("=== Завдання 28 ===");
        System.out.print("Введіть a1, d, n: ");
        int a1 = scanner.nextInt();
        int d = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        int sum = 0;
        int member = a1;
        for (int i = 1; i <= n; i++) {
            System.out.print(member + " ");
            sum += member;
            member += d;
        }
        System.out.println();
        System.out.println("Сума: " + sum);
    }

    // Завдання 29
    static void task29() {
        System.out.println("=== Завдання 29 ===");
        byte b = 125;
        for (int i = 1; i <= 6; i++) {
            b = (byte) (b + 1);
            System.out.println("Крок " + i + ": " + b);
        }
        // Максимальне значення byte - 127, після нього відбувається переповнення і число стає -128
    }

    // Завдання 30
    static void task30() {
        System.out.println("=== Завдання 30 ===");
        System.out.print("Скільки чисел? ");
        int n = scanner.nextInt();
        if (n <= 0) {
            scanner.nextLine();
            System.out.println("Помилка: кількість чисел має бути більшою за 0!");
            return;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Число " + i + ": ");
            sum += scanner.nextInt();
        }
        scanner.nextLine();
        System.out.println("Без приведення: " + (sum / n));
        System.out.println("З приведенням: " + ((double) sum / n));
    }

    // Завдання 31
    static void task31() {
        System.out.println("=== Завдання 31 ===");
        String word = "Hello";
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            System.out.print((char) (ch + 1));
        }
        System.out.println();
    }

    // Завдання 32
    static void task32() {
        System.out.println("=== Завдання 32 ===");
        double[] prices = {19.99, 45.50, 12.10, 99.95, 3.40};
        int hryvnias = 0;
        double kopecks = 0;
        for (int i = 0; i < prices.length; i++) {
            hryvnias += (int) prices[i];
            kopecks += prices[i] - (int) prices[i];
        }
        System.out.println("Сума цілих гривень: " + hryvnias);
        System.out.println("Сума відкинутих копійок: " + Math.round(kopecks * 100) + " коп.");
    }

    // Завдання 33
    static void task33() {
        System.out.println("=== Завдання 33 ===");
        for (int i = 1; i <= 50; i++) {
            int percent = (int) (((double) i / 50) * 100);
            System.out.println("Завантажено: " + percent + "%");
        }
    }

    // Завдання 34
    static void task34() {
        System.out.println("=== Завдання 34 ===");
        long bigNumber = 3_000_000_000L;
        int small = (int) bigNumber;
        System.out.println("long: " + bigNumber);
        System.out.println("int: " + small);
        // Число 3 000 000 000 більше за максимум int (2 147 483 647), тому старші біти відкидаються
        // і виходить від'ємне число
    }

    // Завдання 35
    static void task35() {
        System.out.println("=== Завдання 35 ===");
        for (double d = 0.0; d <= 1.0; d += 0.1) {
            System.out.println(d);
        }
        System.out.println("Правильний варіант:");
        for (int i = 0; i <= 10; i++) {
            double val = i / 10.0;
            System.out.println(val);
        }
        // Через похибку double останнє значення 1.0 не потрапляє в перший цикл (сума стає 0.9999999999999999 або більше 1)
    }

    // Завдання 36
    static void task36() {
        System.out.println("=== Завдання 36 ===");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print((i * j) + "\t");
            }
            System.out.println();
        }
    }

    // Завдання 37
    static void task37() {
        System.out.println("=== Завдання 37 ===");
        System.out.print("Введіть висоту H і ширину W: ");
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (i == 1 || i == h || j == 1 || j == w) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Завдання 38
    static void task38() {
        System.out.println("=== Завдання 38 ===");
        System.out.print("Введіть висоту N: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Завдання 39
    static void task39() {
        System.out.println("=== Завдання 39 ===");
        System.out.print("Введіть N: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Завдання 40
    static void task40() {
        System.out.println("=== Завдання 40 ===");
        System.out.print("Введіть розмір дошки N: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("# ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
        System.out.println("Кінець практичної №4.");
    }
}
