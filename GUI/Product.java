public class Product {
    private double price;
    private double discountPercentage;

    public Product(double price, double discountPercentage) {
        this.price = price;
        this.discountPercentage = discountPercentage;
    }

    public double calculateDiscountedPrice() {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100.");
        }
        double discountAmount = price * (discountPercentage / 100.0);
        return price - discountAmount;
    }
}