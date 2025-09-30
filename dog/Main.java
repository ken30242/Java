public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Bella",3,2);

        dog.displayInfo();     // แสดงข้อมูลสุนัข
        dog.sound();           // "Woof!"
        dog.feed(2);           // "Animals eat 2 kilograms of food."
        dog.sleep();           // "Bella Sleep!"
    }
}
