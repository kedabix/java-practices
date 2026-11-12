package semester1.practice10.homework;

import semester1.practice10.homework.AbstractShape2D;
import semester1.practice10.homework.CircleShape;
import semester1.practice10.homework.ImmutableReferenceSquare;
import semester1.practice10.homework.RectangleShape;
import semester1.practice10.homework.Rotatable2D;
import semester1.practice10.homework.Scalable2D;

import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/** Завдання 1: поліморфна геометрія, інтерфейси трансформацій, instanceof та final. */
public class Task1PolymorphicShapesAndTransforms {

    /** Сумарна площа — чистий поліморфізм, без жодних перевірок типів. */
    public static double calculateTotalArea(semester1.practice10.homework.AbstractShape2D[] shapes) {
        double total = 0;
        for (semester1.practice10.homework.AbstractShape2D shape : shapes) {
            total += shape.getArea();
        }
        return total;
    }

    /** Вибіркова трансформація через Pattern Matching instanceof (без ClassCastException). */
    public static void transformScene(semester1.practice10.homework.AbstractShape2D[] shapes, double scaleFactor, double rotateDeg) {
        for (semester1.practice10.homework.AbstractShape2D shape : shapes) {
            boolean transformed = false;

            if (shape instanceof Scalable2D s) {
                s.scale(scaleFactor);
                System.out.printf(Locale.US, "   [Scalable2D] '%s' масштабовано в %.1f разів (%s)%n",
                        shape.getName(), scaleFactor, shape.getDimensionsInfo());
                transformed = true;
            }
            if (shape instanceof Rotatable2D r) {
                r.rotate(rotateDeg);
                System.out.printf(Locale.US, "   [Rotatable2D] '%s' повернуто на %+.1f° (поточний кут: %.1f°)%n",
                        shape.getName(), rotateDeg, r.getRotationAngle());
                transformed = true;
            }
            if (!transformed) {
                String kind = Modifier.isFinal(shape.getClass().getModifiers()) ? "final class" : "class";
                System.out.printf("   [Info] '%s' (%s) пропущено — не підтримує трансформації.%n",
                        shape.getName(), kind);
            }
        }
    }

    private static void printScene(semester1.practice10.homework.AbstractShape2D[] shapes) {
        for (int i = 0; i < shapes.length; i++) {
            System.out.printf("  %d. %s%n", i + 1, shapes[i]);
        }
    }

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        AbstractShape2D[] shapes = {
                new CircleShape("Коло-Лінза", 0.0, 0.0, 5.0),
                new RectangleShape("Рамка-А", 2.0, 3.0, 4.0, 6.0),
                new ImmutableReferenceSquare("Еталон-Квадрат", 10.0, 10.0, 5.0)
        };

        System.out.println("================ ПОЛІМОРФНА ГЕОМЕТРІЯ ТА ІНТЕРФЕЙСИ ТРАНСФОРМАЦІЙ ================");
        System.out.println("[СТАН СЦЕНИ ДО ТРАНСФОРМАЦІЇ]:");
        printScene(shapes);
        System.out.printf(Locale.US, "Сумарна площа сцени: %.2f кв.од.%n%n", calculateTotalArea(shapes));

        System.out.println("-> Виконуємо пакетну трансформацію (scale x2.0, rotate +45.0°) через instanceof...");
        transformScene(shapes, 2.0, 45.0);

        System.out.println();
        System.out.println("[СТАН СЦЕНИ ПІСЛЯ ТРАНСФОРМАЦІЇ]:");
        printScene(shapes);
        System.out.printf(Locale.US, "Нова сумарна площа сцени: %.2f кв.од.%n", calculateTotalArea(shapes));
        System.out.println("==================================================================================");
    }
}
