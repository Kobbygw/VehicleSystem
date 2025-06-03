import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect a vehicle to enter:");
            System.out.println("1. Car");
            System.out.println("2. Motorcycle");
            System.out.println("3. Truck");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1-4): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> createCar(scanner);
                case "2" -> createMotorcycle(scanner);
                case "3" -> createTruck(scanner);
                case "4" -> {
                    System.out.println("Goodbye.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void createCar(Scanner scanner) {
        try {
            System.out.println("\nEnter Car details:");
            System.out.print("Make: "); String make = scanner.nextLine();
            System.out.print("Model: "); String model = scanner.nextLine();
            System.out.print("Year: "); int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Number of doors: "); int doors = Integer.parseInt(scanner.nextLine());
            System.out.print("Fuel type (petrol/diesel/electric): "); String fuel = scanner.nextLine();

            Car car = new Car(make, model, year);
            car.setNumDoors(doors);
            car.setFuelType(fuel);

            System.out.println("\n" + car);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Try again.");
        }
    }

    private static void createMotorcycle(Scanner scanner) {
        try {
            System.out.println("\nEnter Motorcycle details:");
            System.out.print("Make: "); String make = scanner.nextLine();
            System.out.print("Model: "); String model = scanner.nextLine();
            System.out.print("Year: "); int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Number of wheels: "); int wheels = Integer.parseInt(scanner.nextLine());
            System.out.print("Type (sport/cruiser/off-road): "); String type = scanner.nextLine();

            Motorcycle motorcycle = new Motorcycle(make, model, year);
            motorcycle.setNumWheels(wheels);
            motorcycle.setType(type);

            System.out.println("\n" + motorcycle);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Try again.");
        }
    }

    private static void createTruck(Scanner scanner) {
        try {
            System.out.println("\nEnter Truck details:");
            System.out.print("Make: "); String make = scanner.nextLine();
            System.out.print("Model: "); String model = scanner.nextLine();
            System.out.print("Year: "); int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Cargo capacity (in tons): "); double capacity = Double.parseDouble(scanner.nextLine());
            System.out.print("Transmission type (manual/automatic): "); String transmission = scanner.nextLine();

            Truck truck = new Truck(make, model, year);
            truck.setCargoCapacity(capacity);
            truck.setTransmissionType(transmission);

            System.out.println("\n" + truck);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Try again.");
        }
    }
}
