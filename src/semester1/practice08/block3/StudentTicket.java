package semester1.practice08.block3;

public class StudentTicket extends Ticket {
    private String studentCardNumber;

    public StudentTicket(String eventName, double basePrice, String studentCardNumber) {
        super(eventName, basePrice);
        this.studentCardNumber = studentCardNumber;
    }

    // Знижка 50%
    @Override
    public double getFinalPrice() {
        return super.getFinalPrice() * 0.5;
    }

    @Override
    public String toString() {
        return "Student" + super.toString() + " [студ. квиток: " + studentCardNumber + "]";
    }
}
