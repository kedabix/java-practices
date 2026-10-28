package semester1.practice07;

public class FleetCar {
    private static int totalCars = 0;
    private static double totalCompanyMileage = 0.0;

    private String vinCode;
    private double currentMileage;

    public FleetCar(String vinCode, double initialMileage) {
        this.vinCode = vinCode;
        this.currentMileage = initialMileage;
        totalCars++;
        totalCompanyMileage += initialMileage;
    }

    public void addTrip(double km) {
        this.currentMileage += km;
        totalCompanyMileage += km;
    }

    public static void printFleetSummary() {
        System.out.println("Автопарк: авто " + totalCars + ", загальний пробіг " + totalCompanyMileage + " км");
    }

    public void printCar() {
        System.out.println("Авто " + vinCode + ", пробіг " + currentMileage + " км");
    }
}
