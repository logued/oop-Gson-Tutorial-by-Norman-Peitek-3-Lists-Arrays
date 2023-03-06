package dkit.oop;
import java.util.List;

public class Restaurant {
    String name;
    List<MenuItem> menu;

    //MenuItem[] menu; // alternative, either one is fine

    public Restaurant(String name, List<MenuItem> menu) {
        this.name = name;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", menu=" + menu +
                '}';
    }
}