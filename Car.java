public class Car implements Vehicle, CarVehicle {

    private final String make;
    private final String model;
    private String fuelType;
    private int year, numDoors;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    @Override
    public String getMake() { return make; }
    @Override
    public String getModel() { return model; }
    @Override
    public int getYear() { return year; }

    @Override
    public void setNumDoors(int numDoors) { this.numDoors = numDoors; }
    @Override
    public int getNumDoors() { return numDoors; }

    @Override
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }
    @Override
    public String getFuelType() { return fuelType; }

    @Override
    public String toString() {
        return "Car: " + make + " " + model + ", Year: " + year + ", Doors: " + numDoors + ", Fuel: " + fuelType;
    }
}