package semester1.practice11.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Домашнє завдання 1 (2 бали): типи-обгортки, IntegerCache, Autoboxing/Unboxing,
 * парсинг рядків та екстремуми через MAX_VALUE / MIN_VALUE.
 */
public class Task1WrapperAndAutoboxingMemory {

    public static void inspectIntegerCache(int[] testValues) {
        for (int val : testValues) {
            Integer first = Integer.valueOf(val);
            Integer second = Integer.valueOf(val);
            boolean sameRef = (first == second);
            String source = (val >= -128 && val <= 127) ? "IntegerCache" : "Новий об'єкт у Heap!";
            System.out.printf("  Значення: %5d | (a == b): %-5b | a.equals(b): %-5b | Джерело: %s%n",
                    val, sameRef, first.equals(second), source);
        }
    }

    public static void demonstrateAutoboxingUnderTheHood() {
        // Integer: неявно та явно
        int a = 42;
        Integer implicitBox = a;
        Integer explicitBox = Integer.valueOf(a);
        int implicitUnbox = implicitBox;
        int explicitUnbox = explicitBox.intValue();
        System.out.println("  Явне пакування: Integer.valueOf(" + a + ") -> " + explicitBox
                + " | Розпакування: .intValue() -> " + explicitUnbox
                + " | Неявно: " + implicitBox + " / " + implicitUnbox);

        // Double
        Double d = Double.valueOf(3.14);
        double dPrim = d.doubleValue();
        Double dAuto = 3.14;
        System.out.println("  Double.valueOf(3.14) -> " + d + " | .doubleValue() -> " + dPrim
                + " | автопакування equals: " + d.equals(dAuto));

        // Boolean
        Boolean flag = Boolean.valueOf(true);
        boolean flagPrim = flag.booleanValue();
        Boolean flagAuto = true;
        System.out.println("  Boolean.valueOf(true) -> " + flag + " | .booleanValue() -> " + flagPrim
                + " | автопакування equals: " + flag.equals(flagAuto));

        // Захист від NullPointerException
        List<Integer> sensors = new ArrayList<>();
        sensors.add(45);
        sensors.add(null);
        sensors.add(-12);
        sensors.add(88);
        sensors.add(null);
        sensors.add(102);
        System.out.println("  Вхідний список із датчиків (з null): " + sensors);

        try {
            int bad = sensors.get(1); // під капотом: null.intValue()
            System.out.println(bad);
        } catch (NullPointerException e) {
            System.out.println("  💥 Пряме розпакування null кинуло NullPointerException");
        }

        int sum = 0;
        for (int i = 0; i < sensors.size(); i++) {
            Integer element = sensors.get(i);
            if (element != null) {
                sum += element.intValue();
            } else {
                System.out.println("  ⚠️ Пропущено null-елемент на індексі " + i
                        + " (запобігання NullPointerException при intValue()!)");
            }
        }
        System.out.println("  Сума валідних розпакованих елементів: " + sum);
    }

    public static List<Integer> parseTelemetryStream(String[] rawPackets) {
        List<Integer> result = new ArrayList<>();
        for (String packet : rawPackets) {
            if (packet == null || packet.trim().isEmpty()) {
                System.out.println("  ❌ Порожній або null-пакет відхилено");
                continue;
            }
            String cleaned = packet.trim();
            try {
                int value = Integer.parseInt(cleaned);
                result.add(value); // Autoboxing
            } catch (NumberFormatException e) {
                System.out.println("  ❌ Пакет '" + cleaned + "' відхилено (NumberFormatException)");
            }
        }
        return result;
    }

    public static void printExtremesAndStats(List<Integer> validData) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;
        System.out.println("  Початкові межі пошуку: min = " + min + " (MAX_VALUE), max = " + max + " (MIN_VALUE)");
        for (Integer value : validData) {
            int v = value;
            if (v < min) {
                min = v;
            }
            if (v > max) {
                max = v;
            }
            sum += v;
        }
        System.out.println("  Успішно розпізнаний список Integer: " + validData);
        System.out.println("  Знайдений мінімум: " + min + " | Знайдений максимум: " + max + " | Сума: " + sum);

        // Капкан видалення: remove(index) проти remove(Object)
        List<Integer> copy = new ArrayList<>(validData);
        List<Integer> copy2 = new ArrayList<>(validData);
        copy.remove(0); // за ІНДЕКСОМ 0
        System.out.println("  Після remove(0) (за індексом): " + copy);
        copy2.remove(Integer.valueOf(-30)); // за ЗНАЧЕННЯМ
        System.out.println("  Після remove(Integer.valueOf(-30)) (за значенням): " + copy2);
    }

    public static void main(String[] args) {
        System.out.println("================ ДОСЛІДЖЕННЯ WRAPPER CLASSES ТА INTEGER CACHE ================");
        System.out.println("[1. ЕКСПЕРИМЕНТ: INTEGER CACHE [-128..127] (== проти .equals())]:");
        inspectIntegerCache(new int[]{-128, -50, 0, 127, 128, 500, 2026});

        System.out.println();
        System.out.println("[2. AUTOBOXING / UNBOXING ПІД КАПОТОМ ТА ЗАХИСТ ВІД NULL]:");
        demonstrateAutoboxingUnderTheHood();

        System.out.println();
        System.out.println("[3. ПАРСИНГ РЯДКІВ (Integer.parseInt) ТА ЕКСТРЕМУМИ (MAX_VALUE / MIN_VALUE)]:");
        String[] raw = {"  145 ", "-30", "ERR_404", "980", "", null, "2147483647", "-85"};
        List<Integer> parsed = parseTelemetryStream(raw);
        printExtremesAndStats(parsed);
        System.out.println("==============================================================================");
    }
}
