package semester1.practice11;

import java.util.*;

/**
 * Практична робота №11: Списки в Java (ArrayList, обгортки, ієрархія колекцій, Iterator).
 * 40 завдань у 5 блоках.
 */
public class Practice11 {

    // ======================= БЛОК 1: Wrapper Classes (1-8) =======================

    // Завдання 1
    public static void demonstrateWrapperTwins() {
        Byte b = Byte.valueOf((byte) 10);
        Short s = Short.valueOf((short) 500);
        Integer i = Integer.valueOf(42);
        Long l = Long.valueOf(100L);
        Float f = Float.valueOf(3.14f);
        Double d = Double.valueOf(2.718);
        Character c = Character.valueOf('A');
        Boolean bool = Boolean.valueOf(true);

        // ArrayList<int> numbers = new ArrayList<int>(); // ПОМИЛКА: колекції зберігають лише посилальні типи
        ArrayList<Integer> numbers = new ArrayList<Integer>(); // ✅ Integer — клас-близнюк int
        numbers.add(7);
        System.out.println("ArrayList<Integer>: " + numbers);

        Object[] all = {b, s, i, l, f, d, c, bool};
        for (Object o : all) {
            System.out.println("  " + o + " -> " + o.getClass().getSimpleName());
        }
    }

    // Завдання 2
    public static void showCompilerUnderTheHood() {
        ArrayList<Integer> list = new ArrayList<>();
        // Неявно (синтаксичний цукор)
        int a = 42;
        Integer boxed = a;
        list.add(100);
        int unboxed = list.get(0);
        System.out.println("Неявно: boxed=" + boxed + ", unboxed=" + unboxed);

        // Явно (як бачить компілятор)
        ArrayList<Integer> list2 = new ArrayList<>();
        Integer boxed2 = Integer.valueOf(a);
        list2.add(Integer.valueOf(100));
        int unboxed2 = list2.get(0).intValue();
        System.out.println("Явно:   boxed=" + boxed2 + ", unboxed=" + unboxed2);

        Double d = Double.valueOf(3.14);
        double dp = d.doubleValue();
        Boolean bl = Boolean.valueOf(true);
        boolean bp = bl.booleanValue();
        System.out.println("Double: " + d + " -> " + dp + " | Boolean: " + bl + " -> " + bp);
    }

    // Завдання 3
    public static List<Integer> parseNumbersFromStrings(String[] inputs) {
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (String str : inputs) {
            try {
                int prim = Integer.parseInt(str);      // примітив int
                Integer obj = Integer.valueOf(str);    // об'єкт Integer
                sum += prim;
                result.add(obj);
            } catch (NumberFormatException e) {
                System.out.println("  ⚠️ Некоректний рядок: '" + str + "'");
            }
        }
        System.out.println("  Сума (int): " + sum);
        return result;
    }

    // Завдання 4
    public static void findMinAndMax(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : numbers) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        System.out.println("  min = " + min + ", max = " + max);
    }

    public static void demonstrateLimitsAndOverflow() {
        System.out.println("  Integer: " + Integer.MIN_VALUE + " .. " + Integer.MAX_VALUE);
        System.out.println("  Byte:    " + Byte.MIN_VALUE + " .. " + Byte.MAX_VALUE);
        System.out.println("  Short:   " + Short.MIN_VALUE + " .. " + Short.MAX_VALUE);
        System.out.println("  Long:    " + Long.MIN_VALUE + " .. " + Long.MAX_VALUE);
        int overflow = Integer.MAX_VALUE + 1;
        System.out.println("  MAX_VALUE + 1 == MIN_VALUE: " + (overflow == Integer.MIN_VALUE));
        int x = Integer.MAX_VALUE;
        int add = 5;
        if (x > Integer.MAX_VALUE - add) {
            System.out.println("  Безпечна перевірка: додавання " + add + " призведе до переповнення!");
        }
    }

    // Завдання 5
    public static void testIntegerPool() {
        Integer a = 100, b = 100;
        Integer x = 250, y = 250;
        System.out.println("  100: a == b -> " + (a == b) + ", a.equals(b) -> " + a.equals(b));
        System.out.println("  250: x == y -> " + (x == y) + ", x.equals(y) -> " + x.equals(y));
        System.out.println("  Пояснення: 100 у кеші [-128; 127] (той самий об'єкт), 250 — два різні об'єкти в Heap;");
        System.out.println("  == порівнює посилання, а equals() — значення.");
    }

    // Завдання 6
    public static int sumIgnoringNulls(List<Integer> list) {
        int sum = 0;
        for (Integer element : list) {
            if (element != null) {
                sum += element;
            }
        }
        return sum;
    }

    public static void testNullUnboxing() {
        ArrayList<Integer> temperatures = new ArrayList<>();
        temperatures.add(18);
        temperatures.add(22);
        temperatures.add(null);
        temperatures.add(15);
        temperatures.add(null);
        temperatures.add(20);
        try {
            int t = temperatures.get(2); // null.intValue()
            System.out.println(t);
        } catch (NullPointerException e) {
            System.out.println("  💥 NullPointerException: розпакування null (null.intValue())");
        }
        System.out.println("  Сума без null: " + sumIgnoringNulls(temperatures));
    }

    // Завдання 7
    public static List<Integer> extractDigitsFromText(String text) {
        List<Integer> digits = new ArrayList<>();
        for (char ch : text.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.add(Character.getNumericValue(ch));
            }
        }
        return digits;
    }

    public static void demonstrateDoubleMethods() {
        double a = Double.parseDouble("36.6");
        Double b = Double.valueOf("99.95");
        System.out.println("  parseDouble: " + a + ", valueOf: " + b);
        double nan = 0.0 / 0.0;
        double inf = 1.0 / 0.0;
        System.out.println("  isNaN(0/0): " + Double.isNaN(nan) + ", isInfinite(1/0): " + Double.isInfinite(inf));
    }

    // Завдання 8
    public static void convertNumberSystems(int number) {
        System.out.println("  " + number + " -> bin: " + Integer.toBinaryString(number)
                + ", oct: " + Integer.toOctalString(number)
                + ", hex: " + Integer.toHexString(number));
        System.out.println("  parseInt(\"101010\", 2) = " + Integer.parseInt("101010", 2));
        System.out.println("  parseInt(\"FF\", 16) = " + Integer.parseInt("FF", 16));
    }

    // ======================= БЛОК 2: ArrayList і внутрішня будова (9-16) =======================

    // Завдання 9
    public static void arrayVsArrayList() {
        String[] fixedArray = new String[3];
        fixedArray[0] = "Київ";
        fixedArray[1] = "Львів";
        fixedArray[2] = "Одеса";
        try {
            fixedArray[3] = "Харків";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  💥 Масив фіксований: ArrayIndexOutOfBoundsException");
        }
        ArrayList<String> dynamicList = new ArrayList<>(Arrays.asList(fixedArray));
        dynamicList.add("Харків");
        dynamicList.add("Дніпро");
        dynamicList.add(1, "Вінниця");
        dynamicList.remove(0);
        System.out.println("  Масив:  " + Arrays.toString(fixedArray));
        System.out.println("  Список: " + dynamicList);
    }

    // Завдання 10
    public static List<Integer> traceArrayListCapacity(int elementsCount) {
        List<Integer> capacities = new ArrayList<>();
        int capacity = 10;
        capacities.add(capacity);
        for (int size = 1; size <= elementsCount; size++) {
            if (size > capacity) {
                int old = capacity;
                capacity = old + (old >> 1);
                capacities.add(capacity);
                System.out.println("  Елемент №" + size + ": розширення " + old + " -> " + capacity);
            }
        }
        return capacities;
    }

    // Завдання 11
    public static Object[] growArrayManually(Object[] oldData) {
        int newLength = oldData.length + (oldData.length >> 1);
        Object[] newData = new Object[newLength];
        System.arraycopy(oldData, 0, newData, 0, oldData.length);
        newData[oldData.length] = oldData.length + 1; // 11-й елемент
        return newData;
    }

    public static void demonstrateArrayCopy() {
        Object[] oldData = new Object[10];
        for (int i = 0; i < 10; i++) oldData[i] = i + 1;
        Object[] newData = growArrayManually(oldData);
        System.out.println("  Старий: " + Arrays.toString(oldData));
        System.out.println("  Новий:  " + Arrays.toString(newData));

        // Вставка на індекс 2: зсув вправо
        System.arraycopy(newData, 2, newData, 3, 11 - 2);
        newData[2] = 99;
        System.out.println("  Після вставки 99 на індекс 2: " + Arrays.toString(newData));
    }

    // Завдання 12
    public static void pipelineDemo() {
        ArrayList<String> pipeline = new ArrayList<>();
        pipeline.add("Compile");
        pipeline.add("Package");
        pipeline.add("Deploy");
        System.out.println("  " + pipeline + " size=" + pipeline.size());
        pipeline.add(0, "Checkout Git");
        System.out.println("  " + pipeline + " size=" + pipeline.size());
        pipeline.add(pipeline.indexOf("Package"), "Run Unit Tests");
        System.out.println("  " + pipeline + " size=" + pipeline.size());
    }

    // Завдання 13
    public static void speedsDemo() {
        ArrayList<Integer> speeds = new ArrayList<>(List.of(60, 85, 110, 95, 130));
        System.out.println("  Перший: " + speeds.get(0) + ", центральний: " + speeds.get(speeds.size() / 2)
                + ", останній: " + speeds.get(speeds.size() - 1));
        for (int i = 0; i < speeds.size(); i++) {
            if (speeds.get(i) > 100) {
                Integer old = speeds.set(i, 100);
                System.out.println("  Індекс " + i + ": старе значення " + old + " -> 100");
            }
        }
        System.out.println("  Результат: " + speeds);
    }

    // Завдання 14
    static class SimpleArrayList {
        private Object[] data = new Object[10];
        private int size = 0;

        public void add(Object element) {
            if (size == data.length) {
                int newCap = data.length + (data.length >> 1);
                Object[] newData = new Object[newCap];
                System.arraycopy(data, 0, newData, 0, size);
                data = newData;
            }
            data[size++] = element;
        }

        public Object get(int index) {
            if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
            return data[index];
        }

        public int size() {
            return size;
        }

        public int getCapacity() {
            return data.length;
        }
    }

    public static void simpleArrayListDemo() {
        SimpleArrayList list = new SimpleArrayList();
        System.out.println("  Початково: size=" + list.size() + ", capacity=" + list.getCapacity());
        for (int i = 1; i <= 12; i++) list.add("E" + i);
        System.out.println("  Після 12 елементів: size=" + list.size() + ", capacity=" + list.getCapacity()
                + ", get(11)=" + list.get(11));
    }

    // Завдання 15
    public static void capacityManagement() {
        // Відомо заздалегідь ~500 елементів -> один масив одразу, без зайвих System.arraycopy при рості
        ArrayList<String> logs = new ArrayList<>(500);
        for (int i = 0; i < 300; i++) logs.add("log-" + i);
        logs.ensureCapacity(1000); // гарантує місце під 1000 елементів
        System.out.println("  size=" + logs.size() + " після ensureCapacity(1000)");
        logs.trimToSize(); // внутрішній масив рівно під size
        System.out.println("  після trimToSize(): внутрішній масив = size = " + logs.size());
    }

    // Завдання 16
    public static ArrayList<Integer> extractPassedScores(List<Integer> allScores, int minPassScore) {
        ArrayList<Integer> passed = new ArrayList<>();
        for (int i = 0; i < allScores.size(); i++) {
            if (allScores.get(i) >= minPassScore) {
                passed.add(allScores.get(i));
            }
        }
        return passed;
    }

    public static void scoresDemo() {
        ArrayList<Integer> scores = new ArrayList<>(List.of(45, 88, 92, 59, 74, 100, 38, 65));
        ArrayList<Integer> passed = extractPassedScores(scores, 60);
        System.out.println("  Усього: " + scores.size() + ", відраховано: " + (scores.size() - passed.size())
                + ", зараховані: " + passed);
    }

    // ======================= БЛОК 3: Методи ArrayList (17-24) =======================

    // Завдання 17
    public static void removeIndexVsObject() {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(10, 20, 30, 1, 40, 2));
        numbers.remove(1); // за ІНДЕКСОМ 1 -> зникло 20
        System.out.println("  remove(1): " + numbers + " (видалено елемент за індексом 1, тобто 20)");
        numbers.remove(Integer.valueOf(1));
        numbers.remove(Integer.valueOf(2));
        System.out.println("  remove(Integer.valueOf(1)), remove(Integer.valueOf(2)): " + numbers);
    }

    // Завдання 18
    public static int countOccurrences(List<String> list, String target) {
        int count = 0;
        for (String s : list) {
            if (Objects.equals(s, target)) count++;
        }
        return count;
    }

    public static void containsAndIndexOf() {
        ArrayList<String> langs = new ArrayList<>(List.of("Java", "Python", "C++", "Java", "Kotlin", "Java"));
        System.out.println("  contains(Kotlin): " + langs.contains("Kotlin") + ", contains(Rust): " + langs.contains("Rust"));
        System.out.println("  indexOf(Java): " + langs.indexOf("Java") + ", lastIndexOf(Java): " + langs.lastIndexOf("Java"));
        System.out.println("  countOccurrences(Java): " + countOccurrences(langs, "Java"));
    }

    // Завдання 19
    public static void cartDemo() {
        ArrayList<String> cart = new ArrayList<>();
        System.out.println("  Порожній: isEmpty=" + cart.isEmpty() + ", size=" + cart.size());
        cart.add("Хліб");
        cart.add("Молоко");
        cart.add("Сир");
        cart.add("Кава");
        System.out.println("  Після додавання: isEmpty=" + cart.isEmpty() + ", size=" + cart.size());
        cart.clear();
        System.out.println("  Після clear(): isEmpty=" + cart.isEmpty() + ", size=" + cart.size()
                + " (усі комірки Object[] занульовані, size = 0)");
    }

    // Завдання 20
    public static void toArrayDemo() {
        ArrayList<String> cities = new ArrayList<>(List.of("Київ", "Львів", "Одеса", "Харків", "Дніпро"));
        Object[] objArray = cities.toArray();
        String[] strArray = cities.toArray(new String[0]);
        System.out.println("  Object[]: " + Arrays.toString(objArray));
        System.out.println("  String[]: " + Arrays.toString(strArray));
        ArrayList<String> back = new ArrayList<>(Arrays.asList(strArray));
        back.add("Полтава");
        System.out.println("  Назад у ArrayList: " + back);
    }

    // Завдання 21
    public static void manageTaskList() {
        ArrayList<String> tasks = new ArrayList<>();
        System.out.println("  isEmpty: " + tasks.isEmpty());
        for (int i = 1; i <= 5; i++) tasks.add("Задача " + i);
        tasks.add(0, "ТЕРМІНОВА задача");
        System.out.println("  " + tasks);
        String first = tasks.get(1);
        tasks.set(1, first + " (оновлено)");
        System.out.println("  contains('Задача 3'): " + tasks.contains("Задача 3"));
        tasks.remove("Задача 3");
        tasks.remove(0);
        System.out.println("  size: " + tasks.size() + ", список: " + tasks);
        Object[] exported = tasks.toArray();
        System.out.println("  toArray: " + Arrays.toString(exported));
        tasks.clear();
        System.out.println("  після clear: " + tasks);
    }

    // Завдання 22
    public static <T> ArrayList<T> deduplicate(List<T> source) {
        ArrayList<T> unique = new ArrayList<>();
        for (T item : source) {
            if (!unique.contains(item)) {
                unique.add(item);
            }
        }
        return unique;
    }

    // Завдання 23
    public static List<String> passedBoth(List<String> a, List<String> b) {
        List<String> result = new ArrayList<>(a);
        result.retainAll(b);
        return result;
    }

    public static List<String> passedOnlyFirst(List<String> a, List<String> b) {
        List<String> result = new ArrayList<>(a);
        result.removeAll(b);
        return result;
    }

    // Завдання 24
    public static int replaceAllValues(List<String> list, String oldValue, String newValue) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), oldValue)) {
                list.set(i, newValue);
                count++;
            }
        }
        return count;
    }

    // ======================= БЛОК 4: var, ієрархія, Iterator (25-32) =======================

    // Завдання 25
    public static void demonstrateTypeInference() {
        List<Integer> list1 = new ArrayList<>();
        var list2 = new ArrayList<Integer>();
        var names = new ArrayList<String>(List.of("Анна", "Богдан"));
        list1.add(1);
        list2.add(2);
        names.add("Віка");
        // list1.add("текст"); // ПОМИЛКА КОМПІЛЯЦІЇ: очікується Integer
        // names.add(5);       // ПОМИЛКА КОМПІЛЯЦІЇ: очікується String
        System.out.println("  list1=" + list1 + ", list2=" + list2 + ", names=" + names);
    }

    // Завдання 26
    public static void demonstrateVarDiamondDanger() {
        var unsafeList = new ArrayList<>(); // ArrayList<Object>!
        unsafeList.add(42);
        unsafeList.add("Java");
        unsafeList.add(true);
        try {
            for (Object o : unsafeList) {
                Integer n = (Integer) o;
                System.out.println("  ok: " + n);
            }
        } catch (ClassCastException e) {
            System.out.println("  💥 ClassCastException: " + e.getMessage());
        }
        var safeList = new ArrayList<Integer>();
        safeList.add(42);
        System.out.println("  Правильно: " + safeList);
    }

    // Завдання 27
    public static void exploreCollectionHierarchy() {
        Object[] objs = {
                new ArrayList<String>(), new LinkedList<String>(), new Vector<String>(), new Stack<String>(),
                new HashSet<String>(), new ArrayDeque<String>()
        };
        for (Object o : objs) {
            System.out.println("  " + o.getClass().getSimpleName()
                    + " | List: " + (o instanceof List)
                    + " | Set: " + (o instanceof Set)
                    + " | Queue: " + (o instanceof Queue)
                    + " | Collection: " + (o instanceof Collection)
                    + " | Iterable: " + (o instanceof Iterable));
        }
    }

    // Завдання 28
    public static <E> void printElements(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        StringBuilder sb = new StringBuilder("  Елементи:");
        while (it.hasNext()) {
            sb.append(' ').append(it.next());
        }
        System.out.println(sb);
    }

    public static <E> void printSummary(Collection<E> collection) {
        System.out.println("  size=" + collection.size() + ", isEmpty=" + collection.isEmpty());
    }

    public static <E> E getFirstAndLast(List<E> list) {
        System.out.println("  Перший: " + list.get(0) + ", останній: " + list.get(list.size() - 1));
        return list.get(0);
    }

    public static void polymorphismDemo() {
        List<List<String>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(List.of("a", "b", "c")));
        lists.add(new LinkedList<>(List.of("d", "e", "f")));
        lists.add(new Vector<>(List.of("g", "h", "i")));
        Stack<String> stack = new Stack<>();
        stack.push("j");
        stack.push("k");
        stack.push("l");
        lists.add(stack);
        for (List<String> l : lists) {
            System.out.println(" " + l.getClass().getSimpleName() + ":");
            printElements(l);
            printSummary(l);
            getFirstAndLast(l);
        }
    }

    // Завдання 29
    public static void listBranchDemo() {
        ArrayList<String> al = new ArrayList<>(List.of("a", "b", "c"));
        System.out.println("  ArrayList get(1): " + al.get(1));

        LinkedList<String> ll = new LinkedList<>(List.of("b"));
        ll.addFirst("a");
        ll.addLast("c");
        System.out.println("  LinkedList: " + ll);

        Vector<String> v = new Vector<>();
        v.addElement("x");
        v.addElement("y");
        System.out.println("  Vector elementAt(1): " + v.elementAt(1));

        Stack<String> stack = new Stack<>();
        stack.push("Книга 1");
        stack.push("Книга 2");
        stack.push("Книга 3");
        System.out.println("  Stack peek: " + stack.peek());
        while (!stack.isEmpty()) {
            System.out.println("  pop: " + stack.pop());
        }
    }

    // Завдання 30
    public static void iteratorDemo() {
        ArrayList<String> modules = new ArrayList<>(List.of("Core Java", "OOP", "Collections", "Streams", "Multithreading"));
        Iterator<String> it = modules.iterator();
        int totalChars = 0;
        while (it.hasNext()) {
            String m = it.next();
            System.out.println("  " + m);
            totalChars += m.length();
        }
        System.out.println("  Сумарна кількість символів: " + totalChars);
    }

    // Завдання 31
    public static void removeNegativesWithIterator(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() < 0) {
                it.remove();
            }
        }
    }

    public static void concurrentModificationDemo() {
        ArrayList<Integer> data = new ArrayList<>(List.of(15, -3, 42, -10, 8, -1, 25));
        try {
            for (Integer x : data) {
                if (x < 0) {
                    data.remove(x);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("  💥 ConcurrentModificationException: список змінено повз ітератор (змінився modCount)");
        }
        ArrayList<Integer> data2 = new ArrayList<>(List.of(15, -3, 42, -10, 8, -1, 25));
        removeNegativesWithIterator(data2);
        System.out.println("  Очищений список: " + data2);
    }

    // Завдання 32
    public static void logsDemo() {
        ArrayList<String> logs = new ArrayList<>(List.of("INFO: Start", "DEBUG: Init", "ERROR: Timeout", "DEBUG: Retry", "INFO: Done"));
        Iterator<String> it = logs.iterator();
        while (it.hasNext()) {
            if (it.next().startsWith("DEBUG:")) {
                it.remove();
            }
        }
        System.out.println("  Після видалення DEBUG: " + logs);
        ListIterator<String> listIt = logs.listIterator();
        while (listIt.hasNext()) listIt.next(); // доходимо до кінця
        while (listIt.hasPrevious()) {
            String s = listIt.previous();
            if (s.contains("ERROR")) {
                listIt.set("CRITICAL ERROR: Timeout");
            }
        }
        System.out.println("  Після ListIterator.set: " + logs);
    }

    // ======================= БЛОК 5: Алгоритми + Git (33-40) =======================

    // Завдання 33
    public static void splitEvenAndOdd(List<Integer> source, List<Integer> evens, List<Integer> odds) {
        Iterator<Integer> it = source.iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (n % 2 == 0) evens.add(n);
            else odds.add(n);
        }
    }

    private static int maxOf(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int n : list) if (n > max) max = n;
        return max;
    }

    // Завдання 34
    public static int removeInRange(List<Integer> list, int min, int max) {
        int removed = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (n >= min && n <= max) {
                it.remove();
                removed++;
            }
        }
        return removed;
    }

    // Завдання 35
    public static <T> void reverseInPlace(List<T> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            int j = list.size() - 1 - i;
            T tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
        }
    }

    // Завдання 36
    public static String[] mergeUniqueToArray(List<String> first, List<String> second) {
        var merged = new ArrayList<String>();
        for (String s : first) if (!merged.contains(s)) merged.add(s);
        for (String s : second) if (!merged.contains(s)) merged.add(s);
        return merged.toArray(new String[0]);
    }

    // Завдання 37
    public static <T> void rotateRight(List<T> list, int k) {
        if (list.isEmpty()) return;
        int steps = k % list.size();
        for (int i = 0; i < steps; i++) {
            T last = list.remove(list.size() - 1);
            list.add(0, last);
        }
    }

    // Завдання 38
    public static ArrayList<Integer> parsePrices(List<String> receiptLines) {
        var prices = new ArrayList<Integer>();
        for (String line : receiptLines) {
            int idx = line.indexOf(':');
            if (idx < 0) continue;
            try {
                prices.add(Integer.parseInt(line.substring(idx + 1).trim()));
            } catch (NumberFormatException e) {
                System.out.println("  ⚠️ Пропущено рядок: " + line);
            }
        }
        return prices;
    }

    public static void receiptDemo() {
        List<String> receiptLines = List.of("Хліб: 35", "Молоко: 48", "Помилка сканера: N/A", "Кава: 240", "Пакет: 5", "Сир: 185");
        ArrayList<Integer> prices = parsePrices(receiptLines);
        System.out.println("  Усі ціни: " + prices);
        Iterator<Integer> it = prices.iterator();
        while (it.hasNext()) {
            if (it.next() < 40) it.remove();
        }
        int total = 0;
        for (int p : prices) total += p;
        System.out.println("  Після видалення < 40: " + prices + ", до сплати: " + total + " грн");
    }

    // Завдання 39
    public static void benchmarkLists() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        int n = 20_000;

        long t = System.nanoTime();
        for (int i = 0; i < n; i++) arrayList.add(0, i);
        long arrInsert = System.nanoTime() - t;

        t = System.nanoTime();
        for (int i = 0; i < n; i++) linkedList.add(0, i);
        long linkInsert = System.nanoTime() - t;

        t = System.nanoTime();
        long s1 = 0;
        for (int i = 0; i < n; i++) s1 += arrayList.get(arrayList.size() / 2);
        long arrGet = System.nanoTime() - t;

        t = System.nanoTime();
        long s2 = 0;
        for (int i = 0; i < n; i++) s2 += linkedList.get(linkedList.size() / 2);
        long linkGet = System.nanoTime() - t;

        System.out.println("  Вставка на початок: ArrayList " + arrInsert / 1_000_000 + " мс, LinkedList " + linkInsert / 1_000_000 + " мс");
        System.out.println("  (ArrayList повільніший: кожна вставка копіює масив через System.arraycopy)");
        System.out.println("  get(size/2): ArrayList " + arrGet / 1_000_000 + " мс, LinkedList " + linkGet / 1_000_000 + " мс");
        System.out.println("  (ArrayList миттєвий: доступ за індексом до Object[]; LinkedList йде по вузлах) [" + (s1 + s2) + "]");
    }

    // ======================= MAIN =======================

    private static void title(String text) {
        System.out.println();
        System.out.println(text);
    }

    public static void main(String[] args) {
        System.out.println("================ ПРАКТИЧНА РОБОТА №11 ================");

        System.out.println("\n########## БЛОК 1: Wrapper Classes ##########");
        title("Завдання 1:");
        demonstrateWrapperTwins();
        title("Завдання 2:");
        showCompilerUnderTheHood();
        title("Завдання 3:");
        List<Integer> parsed = parseNumbersFromStrings(new String[]{"120", "-45", "300", "abc", "1024", ""});
        System.out.println("  Список: " + parsed);
        title("Завдання 4:");
        demonstrateLimitsAndOverflow();
        findMinAndMax(parsed);
        title("Завдання 5:");
        testIntegerPool();
        title("Завдання 6:");
        testNullUnboxing();
        title("Завдання 7:");
        System.out.println("  Цифри: " + extractDigitsFromText("Server-04: CPU 85%, RAM 16GB"));
        demonstrateDoubleMethods();
        title("Завдання 8:");
        convertNumberSystems(42);

        System.out.println("\n########## БЛОК 2: ArrayList ##########");
        title("Завдання 9:");
        arrayVsArrayList();
        title("Завдання 10:");
        System.out.println("  Ланцюжок ємностей: " + traceArrayListCapacity(100));
        title("Завдання 11:");
        demonstrateArrayCopy();
        title("Завдання 12:");
        pipelineDemo();
        title("Завдання 13:");
        speedsDemo();
        title("Завдання 14:");
        simpleArrayListDemo();
        title("Завдання 15:");
        capacityManagement();
        title("Завдання 16:");
        scoresDemo();

        System.out.println("\n########## БЛОК 3: Методи ArrayList ##########");
        title("Завдання 17:");
        removeIndexVsObject();
        title("Завдання 18:");
        containsAndIndexOf();
        title("Завдання 19:");
        cartDemo();
        title("Завдання 20:");
        toArrayDemo();
        title("Завдання 21:");
        manageTaskList();
        title("Завдання 22:");
        System.out.println("  " + deduplicate(new ArrayList<>(List.of(5, 12, 5, 8, 12, 20, 5))));
        System.out.println("  " + deduplicate(new ArrayList<>(List.of("a", "b", "a", "c", "b"))));
        title("Завдання 23:");
        List<String> listA = List.of("Анна", "Богдан", "Віка", "Гліб");
        List<String> listB = List.of("Богдан", "Гліб", "Дмитро");
        System.out.println("  Обидва іспити: " + passedBoth(listA, listB));
        System.out.println("  Лише Java: " + passedOnlyFirst(listA, listB));
        title("Завдання 24:");
        List<String> colors = new ArrayList<>(List.of("red", "green", "red", "blue", "red"));
        int replaced = replaceAllValues(colors, "red", "black");
        System.out.println("  " + colors + ", замін: " + replaced);

        System.out.println("\n########## БЛОК 4: var, ієрархія, Iterator ##########");
        title("Завдання 25:");
        demonstrateTypeInference();
        title("Завдання 26:");
        demonstrateVarDiamondDanger();
        title("Завдання 27:");
        exploreCollectionHierarchy();
        title("Завдання 28:");
        polymorphismDemo();
        title("Завдання 29:");
        listBranchDemo();
        title("Завдання 30:");
        iteratorDemo();
        title("Завдання 31:");
        concurrentModificationDemo();
        title("Завдання 32:");
        logsDemo();

        System.out.println("\n########## БЛОК 5: Алгоритми + Git ##########");
        title("Завдання 33:");
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        splitEvenAndOdd(List.of(7, 2, 9, 14, 3, 8, 21, 6), evens, odds);
        System.out.println("  Парні: " + evens + " size=" + evens.size() + " max=" + maxOf(evens));
        System.out.println("  Непарні: " + odds + " size=" + odds.size() + " max=" + maxOf(odds));
        title("Завдання 34:");
        List<Integer> nums = new ArrayList<>(List.of(5, 12, 18, 3, 25, 14, 30, 9, 16, 20));
        int removed = removeInRange(nums, 10, 20);
        System.out.println("  Видалено: " + removed + ", залишилось: " + nums);
        title("Завдання 35:");
        List<String> rev = new ArrayList<>(List.of("a", "b", "c", "d", "e"));
        reverseInPlace(rev);
        System.out.println("  " + rev);
        title("Завдання 36:");
        System.out.println("  " + Arrays.toString(mergeUniqueToArray(List.of("a", "b", "c"), List.of("b", "d", "a", "e"))));
        title("Завдання 37:");
        List<Integer> rot = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        rotateRight(rot, 2);
        System.out.println("  " + rot);
        title("Завдання 38:");
        receiptDemo();
        title("Завдання 39:");
        benchmarkLists();
        title("Завдання 40:");
        System.out.println("  Усі 40 завдань виконано. Далі: git add / git commit / git push origin main");
        System.out.println("\n================ КІНЕЦЬ ================");
    }
}
