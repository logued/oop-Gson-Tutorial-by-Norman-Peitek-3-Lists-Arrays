package dkit.oop;

public class RestaurantMenuItem {
    String description;
    float price;

    public RestaurantMenuItem(String description, float price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "RestaurantMenuItem{" +
                "description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}