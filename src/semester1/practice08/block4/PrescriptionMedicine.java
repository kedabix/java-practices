package semester1.practice08.block4;

public class PrescriptionMedicine extends Medicine {
    private String doctorLicense;

    public PrescriptionMedicine(String name, double price, boolean isExpired, String doctorLicense) {
        super(name, price, isExpired);
        this.doctorLicense = doctorLicense;
    }

    // Продаж можливий, якщо не прострочено І є рецепт
    public boolean canSell(boolean hasPrescription) {
        return !isExpired() && hasPrescription;
    }

    @Override
    public String toString() {
        return "PrescriptionMedicine{" + super.toString() + ", license='" + doctorLicense + "'}";
    }
}
