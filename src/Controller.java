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
    public void addRecipe() {
        System.out.println("we just added a recipe");

    }
    //method to edit current recipe
    public void editRecipe()
    {
        System.out.println("we edited the recipe");

    }
    //method to delete recipe
    public void delRecipe() {
        System.out.println("recipe deleted");
    }
}
