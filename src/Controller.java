/**
 * Created by newScanTron on 9/24/2014.
 */
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

    public Recipe addRecipe(Recipe newRecipe) {
        System.out.println("we just added a recipe");

        //@TODO: Add recipe to database

        return null;
    }
    //method to edit current recipe
    public void editRecipe(String oldRecipeName, Recipe newRecipe)
    {
        System.out.println("We edited the recipe ");
        delRecipe(findByName(oldRecipeName)); // Remove original
        addRecipe(newRecipe);   // Add modified original

    }
    //method to delete recipe
    public void delRecipe(Recipe deleteRecipe) {

        //@TODO: Remove recipe from database

        System.out.println("recipe deleted");
    }

    public String[] searchRecipe(String searchInput) {

        //@TODO: Search Function
        // Go through all recipes
        // Find if recipe's name, tags, or ingredients include search input
        // If so, add recipe to results list

        String[] results = new String[0];
        return results;

    }

    public Recipe findByName(String name) {

        //@TODO: Search for recipe with exact name match

        return new Recipe("test: findByName()");
    }
}
