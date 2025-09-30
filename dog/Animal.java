// Animal.java
abstract class Animal {
    // abstract method
    abstract void sound();

    // normal method
    void sleep() {
        System.out.println("Sleep");
    }

    // normal method with parameter
    void feed(int amount) {
        System.out.println("Animals eat " + amount + " kilograms of food.");
    }
}
