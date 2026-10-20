package semester1.practice05;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Practice05 {
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
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        numbers[0] = 10;
        numbers[2] = 30;
        numbers[4] = 50;
        System.out.println(Arrays.toString(numbers));
    }

    // Завдання 2
    static void task2() {
        System.out.println("=== Завдання 2 ===");
        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
        System.out.println("Кількість днів: " + days.length);
        System.out.println("Перший день: " + days[0]);
        System.out.println("Останній день: " + days[days.length - 1]);
        days[5] = "Вихідний (Сб)";
        days[6] = "Вихідний (Нд)";
        System.out.println(Arrays.toString(days));
    }

    // Завдання 3
    static void task3() {
        System.out.println("=== Завдання 3 ===");
        double[] prices = {120.50, 45.00, 890.99, 15.30, 420.00};
        System.out.println(Arrays.toString(prices));
        prices[2] = prices[2] * 0.8;
        System.out.println(Arrays.toString(prices));
    }

    // Завдання 4
    static void task4() {
        System.out.println("=== Завдання 4 ===");
        System.out.print("Введіть N: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        if (n < 0) {
            System.out.println("Помилка: N не може бути від'ємним!");
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    // Завдання 5
    static void task5() {
        System.out.println("=== Завдання 5 ===");
        int[] arr = {4, 8, 15, 16, 23, 42};
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // Завдання 6
    static void task6() {
        System.out.println("=== Завдання 6 ===");
        int[] powers = new int[10];
        powers[0] = 1;
        for (int i = 1; i < powers.length; i++) {
            powers[i] = powers[i - 1] * 2;
        }
        System.out.println(Arrays.toString(powers));
    }

    // Завдання 7
    static void task7() {
        System.out.println("=== Завдання 7 ===");
        int[] original = {3, 7, 1, 9, 4};
        int[] copy = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        copy[0] = 999;
        System.out.println("original: " + Arrays.toString(original));
        System.out.println("copy: " + Arrays.toString(copy));
    }

    // Завдання 8
    static void task8() {
        System.out.println("=== Завдання 8 ===");
        int[] grades = {95, 84, 70, 99, 65, 88, 92};
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        double average = (double) sum / grades.length;
        System.out.println("Сума: " + sum + ", Середній бал: " + average);
    }

    // Завдання 9
    static void task9() {
        System.out.println("=== Завдання 9 ===");
        int[] temps = {18, 21, 15, 24, 13, 27, 20};
        int min = temps[0];
        int max = temps[0];
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < temps.length; i++) {
            if (temps[i] < min) {
                min = temps[i];
                minIndex = i;
            }
            if (temps[i] > max) {
                max = temps[i];
                maxIndex = i;
            }
        }
        System.out.println("Мінімум: " + min + " (індекс " + minIndex + ")");
        System.out.println("Максимум: " + max + " (індекс " + maxIndex + ")");
    }

    // Завдання 10
    static void task10() {
        System.out.println("=== Завдання 10 ===");
        int[] data = {12, -5, 0, 43, -19, 0, -2, 8, 0, 15};
        int positive = 0;
        int negative = 0;
        int zero = 0;
        for (int x : data) {
            if (x > 0) {
                positive++;
            } else if (x < 0) {
                negative++;
            } else {
                zero++;
            }
        }
        System.out.println("Додатних: " + positive + ", від'ємних: " + negative + ", нулів: " + zero);
    }

    // Завдання 11
    static void task11() {
        System.out.println("=== Завдання 11 ===");
        int[] arr = {5, 8, 12, 7, 3, 10, 21, 6, 9, 14};
        int evenCount = 0;
        int oddSum = 0;
        for (int x : arr) {
            if (x % 2 == 0) {
                evenCount++;
            } else {
                oddSum += x;
            }
        }
        System.out.println("Парних чисел: " + evenCount);
        System.out.println("Сума непарних: " + oddSum);
    }

    // Завдання 12
    static void task12() {
        System.out.println("=== Завдання 12 ===");
        int[] students = {1042, 2031, 3055, 4018, 5099};
        System.out.print("Введіть шуканий номер: ");
        int target = scanner.nextInt();
        scanner.nextLine();
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == target) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println("Номер знайдено на позиції " + index);
        } else {
            System.out.println("Студента з таким номером не знайдено");
        }
    }

    // Завдання 13
    static void task13() {
        System.out.println("=== Завдання 13 ===");
        int[] rolls = {3, 6, 2, 6, 1, 4, 6, 5, 2, 6};
        System.out.print("Введіть число від 1 до 6: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        int count = 0;
        for (int roll : rolls) {
            if (roll == number) {
                count++;
            }
        }
        System.out.println("Число " + number + " випало " + count + " разів");
    }

    // Завдання 14
    static void task14() {
        System.out.println("=== Завдання 14 ===");
        int[] salaries = {18000, 25000, 32000, 15000, 41000, 29000};
        int sum = 0;
        for (int s : salaries) {
            sum += s;
        }
        double average = (double) sum / salaries.length;
        System.out.println("Середня зарплата: " + average);
        for (int s : salaries) {
            if (s > average) {
                System.out.println(s);
            }
        }
    }

    // Завдання 15
    static void task15() {
        System.out.println("=== Завдання 15 ===");
        double[] prices = {42.5, 41.8, 44.1, 40.9, 43.6, 45.0};
        double min = prices[0];
        double max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        System.out.println("Розмах цін: " + Math.round((max - min) * 100) / 100.0);
    }

    // Завдання 16
    static void task16() {
        System.out.println("=== Завдання 16 ===");
        String[] cities = {"Київ", "Львів", "Харків", "Одеса", "Дніпро"};
        for (String city : cities) {
            System.out.println("Ласкаво просимо до міста " + city + "!");
        }
    }

    // Завдання 17
    static void task17() {
        System.out.println("=== Завдання 17 ===");
        double[] salaries = {20000.0, 25000.0, 18000.0, 30000.0};
        for (int i = 0; i < salaries.length; i++) {
            salaries[i] *= 1.10;
        }
        System.out.println(Arrays.toString(salaries));
    }

    // Завдання 18
    static void task18() {
        System.out.println("=== Завдання 18 ===");
        int[] arr = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    // Завдання 19
    static void task19() {
        System.out.println("=== Завдання 19 ===");
        int[] base = {2, 4, 6, 8, 10};
        int[] squares = new int[base.length];
        for (int i = 0; i < base.length; i++) {
            squares[i] = base[i] * base[i];
        }
        System.out.println(Arrays.toString(base));
        System.out.println(Arrays.toString(squares));
    }

    // Завдання 20
    static void task20() {
        System.out.println("=== Завдання 20 ===");
        int[] arr = {1, 3, 5, 8, 12, 20};
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }
        System.out.println("Масив відсортований: " + isSorted);
    }

    // Завдання 21
    static void task21() {
        System.out.println("=== Завдання 21 ===");
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6, 7};
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[a.length + i] = b[i];
        }
        System.out.println(Arrays.toString(c));
    }

    // Завдання 22
    static void task22() {
        System.out.println("=== Завдання 22 ===");
        int[] test = {45, 12, 89, 3, 27};
        System.out.println(Arrays.toString(test));
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));
        Arrays.fill(test, -1);
        System.out.println(Arrays.toString(test));
    }

    // Завдання 23
    static void task23() {
        System.out.println("=== Завдання 23 ===");
        int[][] table = new int[3][3];
        int value = 5;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = value;
                value += 3;
            }
        }
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Завдання 24
    static void task24() {
        System.out.println("=== Завдання 24 ===");
        int[][] matrix = {
                {10, 20, 30, 40},
                {50, 60, 70, 80}
        };
        System.out.println("Рядків: " + matrix.length);
        System.out.println("Стовпчиків: " + matrix[0].length);
        System.out.println("Лівий верхній: " + matrix[0][0]);
        System.out.println("Правий верхній: " + matrix[0][matrix[0].length - 1]);
        System.out.println("Лівий нижній: " + matrix[matrix.length - 1][0]);
        System.out.println("Правий нижній: " + matrix[matrix.length - 1][matrix[0].length - 1]);
    }

    // Завдання 25
    static void task25() {
        System.out.println("=== Завдання 25 ===");
        int[][] grid = new int[3][4];
        int counter = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = counter;
                counter++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Завдання 26
    static void task26() {
        System.out.println("=== Завдання 26 ===");
        int[][] randomGrid = new int[4][3];
        for (int i = 0; i < randomGrid.length; i++) {
            for (int j = 0; j < randomGrid[i].length; j++) {
                randomGrid[i][j] = (int) (Math.random() * 90) + 10;
            }
        }
        System.out.println(Arrays.deepToString(randomGrid));
        for (int i = 0; i < randomGrid.length; i++) {
            for (int j = 0; j < randomGrid[i].length; j++) {
                System.out.print(randomGrid[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Завдання 27
    static void task27() {
        System.out.println("=== Завдання 27 ===");
        int[][] multTable = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                multTable[i][j] = (i + 1) * (j + 1);
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf("%4d", multTable[i][j]);
            }
            System.out.println();
        }
    }

    // Завдання 28
    static void task28() {
        System.out.println("=== Завдання 28 ===");
        int[][] identity = new int[5][5];
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (row == col) {
                    identity[row][col] = 1;
                } else {
                    identity[row][col] = 0;
                }
            }
        }
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.print(identity[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Завдання 29
    static void task29() {
        System.out.println("=== Завдання 29 ===");
        int[][] m = new int[4][4];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(m[i], 1);
        }
        for (int j = 0; j < 4; j++) {
            m[1][j] = 0;
        }
        for (int i = 0; i < 4; i++) {
            m[i][2] = 7;
        }
        System.out.println(Arrays.deepToString(m));
    }

    // Завдання 30
    static void task30() {
        System.out.println("=== Завдання 30 ===");
        int[][] m = {{4, 8, 1}, {7, 3, 9}, {2, 6, 5}};
        int sum = 0;
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                sum += m[i][j];
                count++;
            }
        }
        System.out.println("Сума: " + sum);
        System.out.println("Кількість елементів: " + count);
        System.out.println("Середнє: " + ((double) sum / count));
    }

    // Завдання 31
    static void task31() {
        System.out.println("=== Завдання 31 ===");
        int[][] m = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] rowSums = new int[3];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                rowSums[i] += m[i][j];
            }
            System.out.println("Рядок " + i + ": сума = " + rowSums[i]);
        }
    }

    // Завдання 32
    static void task32() {
        System.out.println("=== Завдання 32 ===");
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] colSums = new int[3];
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                colSums[col] += m[row][col];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------");
        for (int col = 0; col < 3; col++) {
            System.out.print(colSums[col] + "\t");
        }
        System.out.println();
    }

    // Завдання 33
    static void task33() {
        System.out.println("=== Завдання 33 ===");
        int[][] m = {{3, -7, 12, 5}, {-2, 18, 4, -9}, {6, 1, 25, -3}};
        int max = m[0][0];
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] > max) {
                    max = m[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println("Максимум: " + max + " у комірці [" + maxRow + ", " + maxCol + "]");
    }

    // Завдання 34
    static void task34() {
        System.out.println("=== Завдання 34 ===");
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int mainSum = 0;
        int antiSum = 0;
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m.length; col++) {
                if (row == col) {
                    mainSum += m[row][col];
                }
                if (row + col == m.length - 1) {
                    antiSum += m[row][col];
                }
            }
        }
        System.out.println("Головна діагональ: " + mainSum);
        System.out.println("Побічна діагональ: " + antiSum);
        if (mainSum == antiSum) {
            System.out.println("Суми рівні");
        } else if (mainSum > antiSum) {
            System.out.println("Головна діагональ більша");
        } else {
            System.out.println("Побічна діагональ більша");
        }
    }

    // Завдання 35
    static void task35() {
        System.out.println("=== Завдання 35 ===");
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transposed = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        System.out.println("Початкова\tТранспонована");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\t\t");
            for (int j = 0; j < 3; j++) {
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Завдання 36
    static void task36() {
        System.out.println("=== Завдання 36 ===");
        int[][] ladder = new int[4][];
        for (int i = 0; i < ladder.length; i++) {
            ladder[i] = new int[i + 1];
            for (int j = 0; j < ladder[i].length; j++) {
                ladder[i][j] = i;
            }
        }
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                System.out.print(ladder[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Завдання 37
    static void task37() {
        System.out.println("=== Завдання 37 ===");
        String[] weekDays = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця"};
        String[][] weekSchedule = new String[5][];
        weekSchedule[0] = new String[]{"Вища математика", "Основи програмування", "Фізика"};
        weekSchedule[1] = new String[]{"Англійська мова", "Історія України"};
        weekSchedule[2] = new String[]{"Основи програмування", "Основи програмування", "Бази даних", "Фізвиховання"};
        weekSchedule[3] = new String[]{"Дискретна математика"};
        weekSchedule[4] = new String[]{"Філософія", "Основи алгоритмізації", "Практикум"};
        for (int i = 0; i < weekSchedule.length; i++) {
            System.out.println(weekDays[i] + " (пар: " + weekSchedule[i].length + "):");
            for (int j = 0; j < weekSchedule[i].length; j++) {
                System.out.println("  " + (j + 1) + ". " + weekSchedule[i][j]);
            }
        }
    }

    // Завдання 38
    static void task38() {
        System.out.println("=== Завдання 38 ===");
        int[][] pascal = new int[5][];
        for (int i = 0; i < pascal.length; i++) {
            pascal[i] = new int[i + 1];
            pascal[i][0] = 1;
            pascal[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
        for (int i = 0; i < pascal.length; i++) {
            for (int j = 0; j < pascal[i].length; j++) {
                System.out.print(pascal[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Завдання 39
    static void task39() {
        System.out.println("=== Завдання 39 ===");
        int[][][] cube = new int[3][3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    cube[x][y][z] = x + y + z;
                }
            }
        }
        for (int x = 0; x < 3; x++) {
            System.out.println("--- Шар " + x + " ---");
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    System.out.print(cube[x][y][z] + " ");
                }
                System.out.println();
            }
        }
    }

    // Завдання 40
    static void task40() {
        System.out.println("=== Завдання 40 ===");
        String[] cities = {"Київ", "Львів", "Одеса"};
        // [місто][день][0 - день, 1 - ніч]
        double[][][] weather = {
                {{18, 9}, {20, 11}, {22, 12}, {19, 10}, {17, 8}, {21, 12}, {23, 13}},
                {{15, 7}, {16, 8}, {18, 9}, {14, 6}, {13, 5}, {17, 8}, {19, 10}},
                {{22, 14}, {24, 15}, {25, 16}, {23, 14}, {21, 13}, {26, 17}, {27, 18}}
        };
        double coldest = weather[0][0][1];
        String coldestCity = cities[0];
        int coldestDay = 1;
        for (int city = 0; city < 3; city++) {
            double sum = 0;
            for (int day = 0; day < 7; day++) {
                sum += weather[city][day][0];
                if (weather[city][day][1] < coldest) {
                    coldest = weather[city][day][1];
                    coldestCity = cities[city];
                    coldestDay = day + 1;
                }
            }
            System.out.println(cities[city] + ": середня денна температура " + Math.round(sum / 7 * 100) / 100.0 + "°C");
        }
        System.out.println("Найхолодніша ніч: " + coldest + "°C (" + coldestCity + ", день " + coldestDay + ")");
    }
}
