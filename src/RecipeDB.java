/**
 * Created by aaronc on 10/15/14.
 */

import java.util.ArrayList;


public final class RecipeDB {

    private static ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    private static int idCounter = 0;


    public RecipeDB() {
        add(new Recipe("Spaghetti",
                new Ingredient[] {new Ingredient("Spaghetti","105","pieces"),new Ingredient("Sauce","1/2","cup"),new Ingredient("Meatball","3","")},
                new String[] {"Cook spag.","Slather sauce.","Roll the meatballs."},
                new String[] {"Italian","Dinner"}));
        add(new Recipe("PB & J",
                new Ingredient[] {new Ingredient("Bread","2","slices"),new Ingredient("Peanutbutter","2","tbsp"),new Ingredient("Jelly","2","tbsp")},
                new String[] {"Place bread on flat surface.","Put peanutbutter on one slice.","Put jelly on the other.","Slam it together."},
                new String[] {"Snack","Lunch","Easy","American"}));
        add(new Recipe("Bean Burrito",
                new Ingredient[] {new Ingredient("Tortilla","1",""),new Ingredient("Beans","1/2","cup"),new Ingredient("Rice","1","cup")},
                new String[] {"Place tortilla on flat surface.","Put rice and beans in center.","Roll that burrito."},
                new String[] {"Mexican","Lunch","Dinner","Snack","Easy"}));
        add(new Recipe("Veggie Burrito",
                new Ingredient[] {new Ingredient("Tortilla","1",""),new Ingredient("Rice","1/2","cup"),new Ingredient("Lettuce","1","cup")},
                new String[] {"Place tortilla on flat surface.","Put rice and lettuce in center.","Roll that burrito.","Starve."},
                new String[] {"Mexican","Lunch","Dinner","Snack","Easy","Veggie"}));
        add(new Recipe("Scrambled Eggs",
                new Ingredient[] {new Ingredient("Eggs","2",""),new Ingredient("Salt","1","dash"),new Ingredient("Pepper","1","schouch")},
                new String[] {"Scramble dem eggs.","Apply salt.","Install pepper."},
                new String[] {"Breakfast","Easy"}));
        add(new Recipe("Hamburger",
                new Ingredient[] {new Ingredient("beef","1",""),new Ingredient("salt","1/2","tbsp"),new Ingredient("onion","1","whole")},
                new String[] {"add salt to beef","form patties","grill beef"},
                new String[] {"fast food","Lunch","Dinner","American"}));
        add(new Recipe("Lamb shank",
                new Ingredient[] {new Ingredient("lamb leg","1",""),new Ingredient("rosemary","1/2","cup"),new Ingredient("mustard","1","cup"),
                        new Ingredient("fin mix","1/2","cup"), new Ingredient("tyme","1/2","tsp")},
                new String[] {"mix all herbs in a mortal and pestal","rub lamb shank with herbs and mustard", "roast the lamb"},
                new String[] {"old world","Dinner"}));
        add(new Recipe("French Dip ",
                new Ingredient[] {new Ingredient("beef","1",""),new Ingredient("salt","1/2","tbsp"),new Ingredient("carmalized onion","1","whole")},
                new String[] {"add salt to beef","roast beef","make au ju"},
                new String[] {"fast food","Lunch","Dinner","sliced", "sandwich"}));
        add(new Recipe("Bon Mi",
                new Ingredient[] {new Ingredient("pork","1",""),new Ingredient("salt","1/2","tbsp"),new Ingredient("carrot","1","whole"),
                new Ingredient("diakon radish", "1", ""), new Ingredient("slaw", "1", "parts")},
                new String[] {"add salt to beef","form patties","grill beef"},
                new String[] {"fast food","Lunch","Dinner"}));
        add(new Recipe("Brass Monkey",
                new Ingredient[] {new Ingredient("malt liqour","1",""),new Ingredient("orange juice","1/2","cup")},
                new String[] {"add orange juice to malt liquor", "form patties", "grill beef"},
                new String[] {"fast food","Lunch","Dinner","Drank"}));
        add(new Recipe("Side Car",
                new Ingredient[] {new Ingredient("wiskey","1",""),new Ingredient("orange juice","1/2","tbsp")},
                new String[] {"mix the drink"},
                new String[] {"fast food","Drank"}));





                        //String _name, Ingredient[] _ingredients, String[] _directions, String[] _tags) {
    }


    public static Recipe getByName(String input) {
        for(int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).name.equalsIgnoreCase(input)) {
                return recipes.get(i);
            }
        }

        return null;
    }

    public static Recipe getByID(int input) {
        for(int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).id == input) {
                return recipes.get(i);
            }
        }

        return null;
    }

    public static int add(Recipe newRecipe) {
        newRecipe.id = idCounter;
        idCounter++;
        recipes.add(newRecipe);

        return newRecipe.id;
    }

    public static boolean removeByID(int input) {
        for(int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).id == input) {
                recipes.remove(i);
                return true;
            }
        }

        return false;
    }

    public static boolean removeByName(String input) {
        for(int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).name.equalsIgnoreCase(input)) {
                recipes.remove(i);
                return true;
            }
        }

        return false;
    }

    public static Recipe[] arrayListToArray (ArrayList<Recipe> arrayList) {
        arrayList.trimToSize();
        Recipe[] returnArray = new Recipe[arrayList.size()];
        for(int x = 0; x < arrayList.size(); x++) {
            returnArray[x] = arrayList.get(x);
        }

        return returnArray;

    }

    public static Recipe[] search(String input) {

        input = input.trim().toLowerCase();


        if (input.isEmpty()) {
            return arrayListToArray(recipes);
        }
        else {
            ArrayList<Recipe> returnList = new ArrayList<Recipe>();
            for (int r = 0; r < recipes.size(); r++) {
                Recipe thisRecipe = recipes.get(r);
                String compile = thisRecipe.name.toLowerCase();
                for(int i = 0; i < thisRecipe.ingredients.length; i++) {
                    compile = compile.concat(thisRecipe.ingredients[i].name.toLowerCase());
                }
                for(int t = 0; t < thisRecipe.tags.length; t++) {
                    compile = compile.concat(thisRecipe.tags[t].toLowerCase());
                }

                if (compile.contains(input)) {
                    returnList.add(recipes.get(r));

                }
            }
            return arrayListToArray(returnList);
        }



    }
}
