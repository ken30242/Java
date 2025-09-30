public class Main {
    public static void main(String[] args) {
        // Create an object of Car
        Car myCar = new Car("Honda", "City", 40, 50);

        // Display car information
        myCar.displayCarInfo();

        // Call other methods
        myCar.startingEngine();
        myCar.getFuelLevel(20);
        myCar.stopEngine();
    }
}