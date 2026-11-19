package semester1.practice11.homework;

import java.util.ArrayList;

/**
 * Домашнє завдання 2 (3 бали): емулятор внутрішньої будови ArrayList.
 */
public class Task2ArrayListCapacityAndDynamicGrowth {

    static class CustomArrayCapacityEmulator<E> {
        private static final int DEFAULT_CAPACITY = 10;

        private Object[] elementData;
        private int size = 0;
        private int resizeCount = 0;
        private int totalElementsCopied = 0;

        public CustomArrayCapacityEmulator() {
            this.elementData = new Object[DEFAULT_CAPACITY];
        }

        /** Повертає true, якщо відбулося розширення. */
        private boolean ensureCapacityInternal() {
            if (size == elementData.length) {
                int oldCapacity = elementData.length;
                int newCapacity = oldCapacity + (oldCapacity >> 1); // 10 -> 15 -> 22 -> 33 -> 49
                Object[] newBuffer = new Object[newCapacity];
                System.arraycopy(elementData, 0, newBuffer, 0, size);
                elementData = newBuffer;
                resizeCount++;
                totalElementsCopied += size;
                return true;
            }
            return false;
        }

        public void add(E element) {
            int oldCap = elementData.length;
            int copied = size;
            if (ensureCapacityInternal()) {
                System.out.println("  ⚡ [GROW #" + resizeCount + "] Переповнення при додаванні "
                        + (size + 1) + "-го елемента! Ємність: " + oldCap + " -> " + elementData.length
                        + " (System.arraycopy скопіював " + copied + " ел.)");
            }
            elementData[size++] = element;
        }

        public void add(int index, E element) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            ensureCapacityInternal();
            System.arraycopy(elementData, index, elementData, index + 1, size - index);
            elementData[index] = element;
            size++;
        }

        @SuppressWarnings("unchecked")
        public E remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            E old = (E) elementData[index];
            int numMoved = size - index - 1;
            if (numMoved > 0) {
                System.arraycopy(elementData, index + 1, elementData, index, numMoved);
            }
            elementData[--size] = null; // щоб не було витоку пам'яті для GC
            return old;
        }

        @SuppressWarnings("unchecked")
        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            return (E) elementData[index];
        }

        @SuppressWarnings("unchecked")
        public E set(int index, E element) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            E old = (E) elementData[index];
            elementData[index] = element;
            return old;
        }

        public int size() {
            return size;
        }

        public int getCapacity() {
            return elementData.length;
        }

        public int getResizeCount() {
            return resizeCount;
        }

        public int getTotalElementsCopied() {
            return totalElementsCopied;
        }

        public void trimToSize() {
            if (size < elementData.length) {
                Object[] trimmed = new Object[size];
                System.arraycopy(elementData, 0, trimmed, 0, size);
                elementData = trimmed;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("================ ЕМУЛЯТОР ВНУТРІШНЬОЇ БУДОВИ ARRAYLIST (ПІД КАПОТОМ) ================");

        var emulator = new CustomArrayCapacityEmulator<String>();
        // ⚠️ Небезпека: var raw = new ArrayList<>(); -> тип стає ArrayList<Object>, тип елементів втрачається!
        var raw = new ArrayList<>();
        raw.add(1);
        raw.add("рядок"); // компілятор це дозволяє, бо тип Object
        System.out.println("[ІНІЦІАЛІЗАЦІЯ]: Створено CustomArrayCapacityEmulator<String> | size = "
                + emulator.size() + " | capacity = " + emulator.getCapacity());
        System.out.println("  (Попередження: var raw = new ArrayList<>() -> ArrayList<Object>: " + raw + ")");

        System.out.println();
        System.out.println("--- Додавання 35 елементів у список ---");
        for (int i = 1; i <= 35; i++) {
            emulator.add("Block-" + i);
        }
        System.out.println("Стан після додавання 35 елементів: size = " + emulator.size()
                + " | capacity = " + emulator.getCapacity()
                + " (Вільний резерв: " + (emulator.getCapacity() - emulator.size()) + " комірок null)");

        System.out.println();
        System.out.println("--- Тестування вставки add(0, 'HEADER') та видалення remove(5) ---");
        int beforeInsert = emulator.size();
        emulator.add(0, "HEADER");
        System.out.println("  -> Вставлено 'HEADER' на індекс 0 (зсунуто праворуч " + beforeInsert
                + " елементів через System.arraycopy)");
        int beforeRemove = emulator.size();
        String removed = emulator.remove(5);
        System.out.println("  -> Видалено елемент '" + removed + "' з індексу 5 (зсунуто ліворуч "
                + (beforeRemove - 5 - 1) + " елементів, хвіст занулено для GC)");
        System.out.println("  Поточний стан: size = " + emulator.size() + " | capacity = " + emulator.getCapacity()
                + " | Перший: '" + emulator.get(0) + "' | Останній: '" + emulator.get(emulator.size() - 1) + "'");

        System.out.println();
        System.out.println("--- Оптимізація пам'яті trimToSize() ---");
        int capBefore = emulator.getCapacity();
        emulator.trimToSize();
        System.out.println("  -> Викликано trimToSize(): буфер Object[" + capBefore
                + "] стиснуто рівно до Object[" + emulator.getCapacity() + "]!");
        System.out.println("  Фінальна телеметрія: size = " + emulator.size() + " | capacity = "
                + emulator.getCapacity() + " | Кількість розширень: " + emulator.getResizeCount()
                + " | Скопійовано елементів при розширеннях: " + emulator.getTotalElementsCopied());
        System.out.println("=====================================================================================");
    }
}
