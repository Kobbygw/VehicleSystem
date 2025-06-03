public class Motorcycle implements Vehicle, MotorVehicle {

    private final String make;
    private final String model;
    private String type;
    private final int year;
    private int numWheels;

    public Motorcycle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public String getMake() { return make; }
    @Override
    public String getModel() { return model; }
    @Override
    public int getYear() { return year; }

    @Override
    public void setNumWheels(int numWheels) { this.numWheels = numWheels; }
    @Override
    public int getNumWheels() { return numWheels; }

    @Override
    public void setType(String type) { this.type = type; }
    @Override
    public String getType() { return type; }

    @Override
    public String toString() {
        return "Motorcycle: " + make + " " + model + ", Year: " + year + ", Wheels: " + numWheels + ", Type: " + type;
    }
}
