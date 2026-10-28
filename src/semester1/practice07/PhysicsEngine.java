package semester1.practice07;

public class PhysicsEngine {
    public static final double G = 9.80665;
    public static final double SPEED_OF_LIGHT = 299792458.0;

    private PhysicsEngine() {
    }

    public static double freeFallDistance(double seconds) {
        return G * seconds * seconds / 2;
    }

    public static double kineticEnergy(double massKg, double velocityMs) {
        return massKg * velocityMs * velocityMs / 2;
    }

    public static double restEnergy(double massKg) {
        return massKg * SPEED_OF_LIGHT * SPEED_OF_LIGHT;
    }
}
