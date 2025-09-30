public class Car implements Vehicle {
    private String brand;
    private String model;
    private int fuel_volume;
    private int fuelLevel;

    // Constructor
    public Car(String brand, String model, int fuel_volume, int fuelLevel) {
        this.brand = brand;
        this.model = model;
        this.fuel_volume = fuel_volume;
        this.fuelLevel = fuelLevel;
    }

    // Implement methods from Vehicle interface
    @Override
    public void startingEngine() {
        System.out.println("Engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Engine stopped.");
    }

    @Override
    public void getFuelLevel(int fuelLevel) {
        System.out.println("Current fuel level is " + fuelLevel + " liters.");
    }

    // Custom method to display information
    public void displayCarInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Fuel_volume: " + fuel_volume + " L.");
    }
}