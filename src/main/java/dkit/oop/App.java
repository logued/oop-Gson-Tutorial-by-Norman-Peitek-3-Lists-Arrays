package dkit.oop;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Gson Tutorial 3 - Parsing Lists and Arrays
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Gson Tutorial 3 - parsing arrays and Lists");
        App app = new App();
        app.start();
    }

    public void start() {
        List<RestaurantMenuItem> menu = new ArrayList<>();
        menu.add(new RestaurantMenuItem("Spaghetti", 7.99f));
        menu.add(new RestaurantMenuItem("Steak", 12.99f));
        menu.add(new RestaurantMenuItem("Salad", 5.99f));

        RestaurantWithMenu restaurantWithMenu =
                new RestaurantWithMenu("Future Studio Steak House", menu);

        Gson gsonParser = new Gson();
        String restaurantJsonString = gsonParser.toJson(restaurantWithMenu);

        System.out.println("Restaurant object as JSON String: ");
        System.out.println(restaurantJsonString);

        // MenuItems as list only style
        List<RestaurantMenuItem> menuList = new ArrayList<>();
        menuList.add(new RestaurantMenuItem("Spaghetti", 7.99f));
        menuList.add(new RestaurantMenuItem("Steak", 12.99f));
        menuList.add(new RestaurantMenuItem("Salad", 5.99f));
        gsonParser = new Gson();
        String restaurantJsonString2 = gsonParser.toJson(menuList);

        System.out.println("Restaurant object as JSON String: (list only style)");
        System.out.println(restaurantJsonString2);

        ////////////////////////////////////////////////////////////////////////
        //
        // De-serialization

        String founderJson = "[{'name': 'Christian','flowerCount': 1}, {'name': 'Marcus', 'flowerCount': 3}, {'name': 'Norman', 'flowerCount': 2}]";

        Founder[] founderArray = gsonParser.fromJson(founderJson, Founder[].class);

        System.out.println("Founder array : ");
        for(Founder founder : founderArray)
            System.out.println("Founder: "+ founder);

        // Using List type

        Type founderListType = new TypeToken<ArrayList<Founder>>(){}.getType();

        List<Founder> founderList = gsonParser.fromJson(founderJson, founderListType);

        System.out.println("Founder List :  (Uses TypeToken to determine type)");
        for(Founder founder : founderList)
            System.out.println("Founder: "+ founder);

    }

}

//TODO  Implement the following Array of RiseTime objects.
// Populate an ArrayList of RiseTime objects, then
// Serialize and Deserialize them
//  [
//        {
//        "duration": 529,
//        "risetime": 1646759846
//        },
//        {
//        "duration": 635,
//        "risetime": 1646765582
//        },
//        {
//        "duration": 226,
//        "risetime": 1646771636
//        }
//    ]
