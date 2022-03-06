package dkit.oop;

import java.util.List;

public class RestaurantWithMenu {
    String name;

    List<RestaurantMenuItem> menu;
    //RestaurantMenuItem[] menu; // alternative, either one is fine


    public RestaurantWithMenu(String name, List<RestaurantMenuItem> menu) {
        this.name = name;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "RestaurantWithMenu{" +
                "name='" + name + '\'' +
                ", menu=" + menu +
                '}';
    }
}