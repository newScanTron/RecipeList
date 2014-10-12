/**
 * Created by newScanTron on 9/24/2014.
 */
import java.util.ArrayList;
public final class Controller {
    public static void Controller()
    {
        System.out.println("what is going on mang");
    }

    public static recipeList currentRecipes = new recipeList(new Recipe[] {
            new Recipe(0,"Burrito"),
            new Recipe(1,"Ramen"),
            new Recipe(2,"Brownie"),                        // This is where the current recipe objects used in the JList are stored
            new Recipe(3,"Pizza"),
            new Recipe(4,"Taco"),
            new Recipe(5,"Cereal"),
            new Recipe(6,"Waffles"),
    });


    public static Recipe addRecipe(Recipe newRecipe) {

        System.out.println(("Adding recipe '" + newRecipe.name + "' to database..."));
        //TODO: Add recipe to database

        return null;
    }
    //method to edit current recipe
    public static void editRecipe(int oldRecipeID, Recipe newRecipe)
    {
        System.out.println("Editing recipe '" + oldRecipeID + "'... ");

    }

    public static void saveRecipe(int id, Recipe newRecipe) {

        // TODO: Overwrite recipe with 'id' in database with newRecipe
    }

    //method to delete recipe
    public static void deleteRecipe(int deleteID) {

        System.out.println("Deleting recipe w/ ID '" + deleteID + "' from database...");

        //TODO: Remove recipe from database based on ID

    }

    public static void gatherRecipe(AddRecipeGUI rd) {
        // Retrieving name
        String _name = rd.nameField.getText();

        // Retreieving tags
        String[] _tags = rd.tagField.getText().split(" ");

        // Retrieving Ingredients list
        ArrayList<Ingredient> ingList = new ArrayList<Ingredient>();
        if (!rd.ingName1.getText().trim().equals("")) {ingList.add(new Ingredient(0,rd.ingName1.getText(),rd.ingAmount1.getText(),rd.ingUnit1.getText()));}
        if (!rd.ingName2.getText().trim().equals("")) {ingList.add(new Ingredient(0,rd.ingName2.getText(),rd.ingAmount2.getText(),rd.ingUnit2.getText()));}
        if (!rd.ingName3.getText().trim().equals("")) {ingList.add(new Ingredient(0,rd.ingName3.getText(),rd.ingAmount3.getText(),rd.ingUnit3.getText()));}
        if (!rd.ingName4.getText().trim().equals("")) {ingList.add(new Ingredient(0,rd.ingName4.getText(),rd.ingAmount4.getText(),rd.ingUnit4.getText()));}
        if (!rd.ingName5.getText().trim().equals("")) {ingList.add(new Ingredient(0,rd.ingName5.getText(),rd.ingAmount5.getText(),rd.ingUnit5.getText()));}
        if (!rd.ingName6.getText().trim().equals("")) {ingList.add(new Ingredient(0,rd.ingName6.getText(),rd.ingAmount6.getText(),rd.ingUnit6.getText()));}
        if (!rd.ingName7.getText().trim().equals("")) {ingList.add(new Ingredient(0,rd.ingName7.getText(),rd.ingAmount7.getText(),rd.ingUnit7.getText()));}
        if (!rd.ingName8.getText().trim().equals("")) {ingList.add(new Ingredient(0,rd.ingName8.getText(),rd.ingAmount8.getText(),rd.ingUnit8.getText()));}
        if (!rd.ingName9.getText().trim().equals("")) {ingList.add(new Ingredient(0,rd.ingName9.getText(),rd.ingAmount9.getText(),rd.ingUnit9.getText()));}
        if (!rd.ingName10.getText().trim().equals("")) {ingList.add(new Ingredient(0,rd.ingName10.getText(),rd.ingAmount10.getText(),rd.ingUnit10.getText()));}

        System.out.println("ArrayList Size: "  + ingList.size());

        ingList.trimToSize();
        Ingredient[] ingArray = new Ingredient[ingList.size()];
        for(int i = 0; i < ingArray.length; i++) {
            ingArray[i] = ingList.get(i);
        }
        System.out.println("Array Size: "  + ingArray.length);




        // Retrieving directions
        String[] _directions = rd.directionsArea.getText().split("\n");

        if (!_name.equals(""))
        	currentRecipes.add(new Recipe(0,_name,ingArray,_directions,_tags));

    }



    public static void searchRecipe(String searchInput) {

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

    public static void openAddWindow(Recipe r) {

        Driver.newPanel = new AddRecipeGUI();
        Driver.displayFrame.getContentPane().removeAll();
        Driver.displayFrame.getContentPane().add(Driver.newPanel);

        Driver.displayFrame.pack();

        Driver.displayFrame.setLocationRelativeTo(null);
        Driver.displayFrame.setVisible(true);


    }

    public static void closeAddWindow() {

        Driver.newPanel = new RecipeGUI();
        Driver.displayFrame.getContentPane().removeAll();
        Driver.displayFrame.getContentPane().add(Driver.newPanel);

        Driver.displayFrame.pack();

        Driver.displayFrame.setLocationRelativeTo(null);
        Driver.displayFrame.setVisible(true);


    }


}
