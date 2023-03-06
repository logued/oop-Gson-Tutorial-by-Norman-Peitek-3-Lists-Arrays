package dkit.oop;

public class MenuItem {
    String description;     // e.g. Cod and Chips
    float price;            // 12.50

    public MenuItem(String description, float price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}