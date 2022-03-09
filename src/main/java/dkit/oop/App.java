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

        // Initialize an object that has a field called "menu" that is
        // a List of RestaurantMenuItems. (List embedded in Object)
        RestaurantWithMenu restaurantWithMenu =
                new RestaurantWithMenu("Future Studio Steak House", menu);

        Gson gsonParser = new Gson();
        String restaurantJsonString = gsonParser.toJson(restaurantWithMenu);
        //note how the list is presented in the output with square brackets
        //  "{ "name":"Future...", "menu":[ {...."


        System.out.println("Restaurant object as JSON String: ");
        System.out.println(restaurantJsonString);

        // MenuItems as list only style.
        // Sometimes, an API may return simply a list of objects
        // that are not embedded in any object. The following code demonstrates
        // this, by serializing the ArrayList into a Json String.
        // Note that the JSON String starts with a square bracket "["
        // indicating that it is a List.

        List<RestaurantMenuItem> menuList = new ArrayList<>();
        menuList.add(new RestaurantMenuItem("Spaghetti", 7.99f));
        menuList.add(new RestaurantMenuItem("Steak", 12.99f));
        menuList.add(new RestaurantMenuItem("Salad", 5.99f));

        gsonParser = new Gson();
        String menuListJson = gsonParser.toJson(menuList);

        System.out.println("Restaurant object as JSON String: (list only style)");
        System.out.println(menuListJson);

        ////////////////////////////////////////////////////////////////////////
        //
        // De-serialization
        // -  parse a JSON String containing an object that has an
        //    embedded list (the "menu" field) of objects and generate
        //    a Java Object with an embedded Array ( Founder[] )


        //////////////// Founder sample ////////////////////


        String founderJson = "[{'name': 'Christian','flowerCount': 1}, {'name': 'Marcus', 'flowerCount': 3}, {'name': 'Norman', 'flowerCount': 2}]";

        // To tell the Gson parser that we are processing a list of objects
        // that are to be mapped to an Array of Founder objects, we use
        // the syntax Founder[].class.  This will cause the Gson parser to return
        // a reference to the newly created and populated Array of Founder objects.
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
// Serialize and Deserialize them.
// Note that the following is NOT in Json String Format !
// so you must edit it to make it a JSON String.
//
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
