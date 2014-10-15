import java.util.ArrayList;

/**
 * Created by aaronc on 9/26/14.
 */
public class recipeList {

    public Recipe[] recipes = new Recipe[0];

    recipeList(Recipe[] list) {

        recipes = list;

    }

    recipeList() {

    }


    public void add(Recipe r) {
        Recipe[] newValues = new Recipe[recipes.length+1];
        for(int a = 0; a < recipes.length; a++){
            newValues[a] = recipes[a];
        }
        newValues[recipes.length] = r;
        recipes = newValues;

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

    public int findIndexByName(String name) {
        for(int i = 0; i < recipes.length; i++) {
            if (recipes[i].name == name) {return i;}
        }
        return -1;
    }

    public int findIndexByID(int id) {

        for(int i = 0; i < recipes.length; i++) {
            if (recipes[i].id == id) {return i;}
        }
        return -1;
    }

    @Override
    public String toString() {
        String print = "";
        for(int i = 0; i < recipes.length; i++) {
            print = print + " " + recipes[i].name;
        }
        return print;

    }

}
