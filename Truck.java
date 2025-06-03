public class Truck implements Vehicle, TruckVehicle {

    private final String make;
    private final String model;
    private String transmissionType;
    private final int year;
    private double cargoCapacity;

    public Truck(String make, String model, int year) {
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
    public void setCargoCapacity(double capacity) { this.cargoCapacity = capacity; }
    @Override
    public double getCargoCapacity() { return cargoCapacity; }

    @Override
    public void setTransmissionType(String transmission) { this.transmissionType = transmission; }
    @Override
    public String getTransmissionType() { return transmissionType; }

    @Override
    public String toString() {
        return "Truck: " + make + " " + model + ", Year: " + year + ", Cargo: " + cargoCapacity + " tons, Transmission: " + transmissionType;
    }
}
