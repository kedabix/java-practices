package semester1.practice10.homework;

/** Контракт CAN-DO: фігуру можна масштабувати. */
public interface Scalable2D {

    /** Мінімально допустимий коефіцієнт масштабування (неявно public static final). */
    double MIN_SCALE_FACTOR = 0.1;

    /** Масштабує фігуру. Якщо factor < MIN_SCALE_FACTOR, використовується MIN_SCALE_FACTOR. */
    void scale(double factor);
}
