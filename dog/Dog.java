// Dog.java
public class Dog extends Animal {
    private String name;
    private int age;
    private int foodAmount;

    // Constructor
    public Dog(String name, int age, int foodAmount) {
        this.name = name;
        this.age = age;
        this.foodAmount = foodAmount;
    }

    // Override abstract method
    @Override
    void sound() {
        System.out.println("Woof!");
    }

    // Display info
    public void displayInfo() {
        System.out.println("Dog: " + name);
        System.out.println("Age: " + age + " Years");
        System.out.println("Food: " + foodAmount + " kilograms");
    }

    // Override sleep (optional)
    @Override
    void sleep() {
        System.out.println(name + " Sleep!");
    }
}
