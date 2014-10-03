/**
 * Created by newScanTron on 9/24/2014.
 */
import java.util.ArrayList;
public class Controller {
    public static void Controller()
    {
        System.out.println("what is going on mang");
    }
    //not real sure we need this but
    public String toString()
    {
        return("im in control");
    }
    //need a search function will want it to return a recipe
    //but that class does not yet exsist
    public void search(String searchWord)
    {
        System.out.println("im searching for, " + searchWord);
    }
    //addRecipe method pretty standard

    //Recipe (int _id, String _name, Ingredient[] _ingredients, String[] _directions, ArrayList<String> _tags) {

    public RecipeList currentRecipes = new RecipeList(new Recipe[] {
            new Recipe(0,"Burrito"),
            new Recipe(1,"Ramen"),
            new Recipe(2,"Brownie"),                        // This is where the current recipe objects used in the JList are stored
            new Recipe(3,"Pizza"),
            new Recipe(4,"Taco"),
            new Recipe(5,"Cereal"),
            new Recipe(6,"Waffles"),
    });


    public Recipe addRecipe(Recipe newRecipe) {

        System.out.println(("Adding recipe '" + newRecipe.name + "' to database..."));
        //TODO: Add recipe to database

        return null;
    }
    //method to edit current recipe
    public void editRecipe(int oldRecipeID, Recipe newRecipe)
    {
        System.out.println("Editing recipe '" + oldRecipeID + "'... ");
        deleteRecipe(oldRecipeID); // Remove original
        addRecipe(newRecipe);   // Add modified original

    }

    public void saveRecipe(int id, Recipe newRecipe) {

        // TODO: Overwrite recipe with 'id' in database with newRecipe
    }

    //method to delete recipe
    public void deleteRecipe(int deleteID) {

        System.out.println("Deleting recipe w/ ID '" + deleteID + "' from database...");

        //TODO: Remove recipe from database based on ID

    }

    public void searchRecipe(String searchInput) {

        System.out.println("Searching for '" + searchInput + "' in database...");

        //TODO: Search function that compiles all recipes in database containing searchInput into an array of recipes

        Recipe[] results = new Recipe[] {
                new Recipe(123,"Search Result 1"),
                new Recipe(124,"Search Result 2"),
                new Recipe(125,"Search Result 3"),          // Placeholder for search results
                new Recipe(126,"Search Result 4"),
        };

        currentRecipes.recipes = results;

    }

}
