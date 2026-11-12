package semester1.practice10.homework;

/** Контракт CAN-DO: фігуру можна повертати. */
public interface Rotatable2D {

    /** Додає кут deltaDegrees до поточного і нормалізує результат у діапазон [0; 360). */
    void rotate(double deltaDegrees);

    double getRotationAngle();
}
