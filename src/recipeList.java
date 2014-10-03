import java.util.ArrayList;

/**
 * Created by aaronc on 9/26/14.
 */
public class RecipeList {

    public Recipe[] recipes = new Recipe[0];

    RecipeList(Recipe[] list) {

        recipes = list;

    }


    public void add(String _tag) {

        // TODO: add function? may not be necessary

    }

    public String[] getNames() {
        String[] names = new String[recipes.length];
        for(int i = 0; i < recipes.length; i++) {
            names[i] = recipes[i].name;
        }
        return names;
    }

    public void remove(int i) {

        Recipe[] newRecipes = new Recipe[recipes.length-1];
        for(int a = 0; a < i; a++){
            newRecipes[a] = recipes[a];
        }
        for(int a = i; a < recipes.length-1; a++){
            newRecipes[a] = recipes[a+1];
        }
        recipes = newRecipes;

    }

    public void clear() {

        recipes = new Recipe[0];

    }

    public Recipe findByName(String name) {
        for(int i = 0; i < recipes.length; i++) {
            if (recipes[i].name == name) {return recipes[i];}
        }
        return null;
    }

}
