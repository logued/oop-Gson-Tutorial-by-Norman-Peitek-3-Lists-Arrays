package dkit.oop;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
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
        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Spaghetti", 7.99f));
        menu.add(new MenuItem("Steak", 12.99f));
        menu.add(new MenuItem("Salad", 5.99f));

        // Initialize an object that has a List field called "menu" that stores
        // a list of MenuItems. (List embedded in Object)
        Restaurant restaurant = new Restaurant("Fairways Steak House", menu);

        Gson gsonParser = new Gson();
        String restaurantJsonString = gsonParser.toJson(restaurant);
        //note how the list is presented in the output with square brackets
        //  "{ "name":"Future...", "menu":[ {...."


        System.out.println("Restaurant object with Menu Items (as JSON String): ");
        System.out.println(restaurantJsonString);

        // MenuItems as "list only" style.
        // Sometimes, an API may return simply a list of objects
        // that are not embedded in any object. The following code demonstrates
        // this, by serializing the ArrayList into a Json String.
        // Note that the JSON String starts and ends with a square bracket "[" and "]"
        // indicating that it is a list.

        List<MenuItem> menuList = new ArrayList<>();
        menuList.add(new MenuItem("Spaghetti", 7.99f));
        menuList.add(new MenuItem("Steak", 12.99f));
        menuList.add(new MenuItem("Salad", 5.99f));

        gsonParser = new Gson();
        String menuListJson = gsonParser.toJson(menuList);

        System.out.println("List of manu items as JSON String: (list only style)");
        System.out.println(menuListJson);

        ////////////////////////////////////////////////////////////////////////
        //
        // De-serialization
        // -  parse a JSON String containing an object that has an
        //    embedded list (the "menu" field) of objects and generate
        //    a Java Object with an embedded Array ( Founder[] )


        //////////////// Founder sample ////////////////////


        String founderJson = "[{'name': 'Christian','flowerCount': 1}, {'name': 'Marcus', 'flowerCount': 3}, {'name': 'Norman', 'flowerCount': 2}]";

        // To 'tell' the Gson parser that we are processing a list of objects
        // that are to be mapped to an Array of Founder objects, we use
        // the syntax Founder[].class. (Note the square brackets to indicate array).
        // This will cause the Gson parser to return
        // a reference to the newly created and populated Array of Founder objects.
        Founder[] founderArray = gsonParser.fromJson(founderJson, Founder[].class);

        System.out.println("Founder array : ");
        for(Founder founder : founderArray)
            System.out.println("Founder: "+ founder);

        // Using TypeToken to configure Gson parser so that it will create an
        // ArrayList of Founder objects.

        Type founderListType = new TypeToken<ArrayList<Founder>>(){}.getType();

        // for a LinkedList ....
        // Type founderListType = new TypeToken<LinkedList<Founder>>(){}.getType();

        List<Founder> founderList = gsonParser.fromJson(founderJson, founderListType);

        System.out.println("Founder List :  (Uses TypeToken to determine type)");
        for(Founder founder : founderList)
            System.out.println("Founder: "+ founder);
    }
}
//TODO Q1
// http://api.open-notify.org/astros.json
// The above API endpoint will return a list of astronauts who are currently in space.
// A sample of the returned data is shown below.
// Initialize a string with this data.
// Write an appropriate AstronautsInSpace class that stores a list of Astronauts.
// Use the Gson parser to convert the string into an AstronautsInSpace object.
// Output the objet.
// Convert the object back to a JSON string.



//TODO  Q2
// Implement the following Array of RiseTime objects.
// Populate an ArrayList of RiseTime objects, then
// Serialize and Deserialize them.
// Note that the following is NOT in Json String Format !
// so you must edit it to make it into a JSON String.
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
