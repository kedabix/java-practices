package semester1.practice08.block1;

public class SensorNode {
    private String sensorId;
    protected double calibrationOffset; // доступне спадкоємцям та класам пакету
    private double rawValue;

    public SensorNode(String sensorId, double rawValue, double calibrationOffset) {
        this.sensorId = sensorId;
        this.rawValue = rawValue;
        this.calibrationOffset = calibrationOffset;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setRawValue(double rawValue) {
        this.rawValue = rawValue;
    }

    public double getCalibratedValue() {
        return rawValue + calibrationOffset;
    }

    @Override
    public String toString() {
        return "SensorNode{id='" + sensorId + "', raw=" + rawValue + ", calibrated=" + getCalibratedValue() + "}";
    }
}
