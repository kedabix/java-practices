package semester1.practice03.homework;

import java.util.Locale;
import java.util.Scanner;

// Завдання 2
public class Task2DeliveryService {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        scanner.useLocale(Locale.US);

        System.out.println("=== ТАРИФІКАТОР СЛУЖБИ ДОСТАВКИ ===");
        System.out.print("Введіть вагу відправлення (кг): ");
        double weight = scanner.nextDouble();
        System.out.print("Введіть відстань транспортування (км): ");
        int distance = scanner.nextInt();
        System.out.print("Оберіть пункт призначення (1 - Відділення, 2 - Поштомат, 3 - Кур'єр): ");
        int deliveryType = scanner.nextInt();
        scanner.nextLine(); // очищаємо буфер
        System.out.print("Чи є у вас карта Premium? (так/ні): ");
        String premium = scanner.nextLine();

        if (weight <= 0 || weight > 50.0) {
            System.out.println("Помилка: вага має бути більшою за 0 та не більшою за 50 кг!");
            scanner.close();
            return;
        }
        if (distance <= 0) {
            System.out.println("Помилка: відстань має бути більшою за 0 км!");
            scanner.close();
            return;
        }

        double baseTariff = switch (deliveryType) {
            case 1 -> 50.0;
            case 2 -> {
                if (weight > 15.0) {
                    System.out.println("Поштомат не підтримує вантажі понад 15 кг!");
                    yield -1;
                } else {
                    yield 60.0;
                }
            }
            case 3 -> 100.0;
            default -> -1;
        };

        if (baseTariff == -1) {
            System.out.println("Розрахунок неможливий.");
            scanner.close();
            return;
        }

        double distanceFee;
        if (distance <= 50) {
            distanceFee = 0;
        } else if (distance <= 200) {
            distanceFee = 35.0;
        } else {
            distanceFee = 80.0;
        }

        String typeName = switch (deliveryType) {
            case 1 -> "Відділення";
            case 2 -> "Поштомат";
            default -> "Кур'єр";
        };

        double sum = baseTariff + distanceFee;
        boolean isPremium = premium.equalsIgnoreCase("так");
        double total = isPremium ? sum * 0.8 : sum;

        System.out.println();
        System.out.println("------------- НАКЛАДНА ДОСТАВКИ -------------");
        System.out.printf("Тип доставки:              %s (базовий тариф: %.2f грн)%n", typeName, baseTariff);
        System.out.printf("Доплата за відстань:       %.2f грн (%d км)%n", distanceFee, distance);
        System.out.printf("Сума до знижки:            %.2f грн%n", sum);
        System.out.println("Статус клієнта:            " + (isPremium ? "Premium (-20%)" : "Звичайний"));
        System.out.println("---------------------------------------------");
        System.out.printf("РАЗОМ ДО СПЛАТИ:           %.2f грн%n", total);
        System.out.println("=============================================");

        scanner.close();
    }
}
