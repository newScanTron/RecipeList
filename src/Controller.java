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
    public static void editRecipe(int oldRecipeID)
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

        // Retrieving tags
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

    	AddRecipeGUI newPanel = new AddRecipeGUI();
        Driver.newPanel = newPanel;
        Driver.displayFrame.getContentPane().removeAll();
        Driver.displayFrame.getContentPane().add(Driver.newPanel);

        Driver.displayFrame.pack();

        Driver.displayFrame.setLocationRelativeTo(null);
        Driver.displayFrame.setVisible(true);

        newPanel.nameField.setText(r.name);
        
        String tagString = "";
        for (int i = 0; i < r.tags.length; i++) {
        	tagString = tagString + " " + r.tags[i];
        }
        newPanel.tagField.setText(tagString.trim());
        
        if (r.ingredients.length >= 1) {
        	newPanel.ingAmount1.setText(r.ingredients[0].amountMeasure);
        	newPanel.ingUnit1.setText(r.ingredients[0].unitMeasure);
        	newPanel.ingName1.setText(r.ingredients[0].name);
        }
        if (r.ingredients.length >= 2) {
        	newPanel.ingAmount2.setText(r.ingredients[1].amountMeasure);
        	newPanel.ingUnit2.setText(r.ingredients[1].unitMeasure);
        	newPanel.ingName2.setText(r.ingredients[1].name);
        }
        if (r.ingredients.length >= 3) {
        	newPanel.ingAmount3.setText(r.ingredients[2].amountMeasure);
        	newPanel.ingUnit3.setText(r.ingredients[2].unitMeasure);
        	newPanel.ingName3.setText(r.ingredients[2].name);
        }
        if (r.ingredients.length >= 4) {
        	newPanel.ingAmount4.setText(r.ingredients[3].amountMeasure);
        	newPanel.ingUnit4.setText(r.ingredients[3].unitMeasure);
        	newPanel.ingName4.setText(r.ingredients[3].name);
        }
        if (r.ingredients.length >= 5) {
        	newPanel.ingAmount5.setText(r.ingredients[4].amountMeasure);
        	newPanel.ingUnit5.setText(r.ingredients[4].unitMeasure);
        	newPanel.ingName5.setText(r.ingredients[4].name);
        }
        if (r.ingredients.length >= 6) {
        	newPanel.ingAmount6.setText(r.ingredients[5].amountMeasure);
        	newPanel.ingUnit6.setText(r.ingredients[5].unitMeasure);
        	newPanel.ingName6.setText(r.ingredients[5].name);
        }
        if (r.ingredients.length >= 7) {
        	newPanel.ingAmount7.setText(r.ingredients[6].amountMeasure);
        	newPanel.ingUnit7.setText(r.ingredients[6].unitMeasure);
        	newPanel.ingName7.setText(r.ingredients[6].name);
        }
        if (r.ingredients.length >= 8) {
        	newPanel.ingAmount8.setText(r.ingredients[7].amountMeasure);
        	newPanel.ingUnit8.setText(r.ingredients[7].unitMeasure);
        	newPanel.ingName8.setText(r.ingredients[7].name);
        }
        if (r.ingredients.length >= 9) {
        	newPanel.ingAmount9.setText(r.ingredients[8].amountMeasure);
        	newPanel.ingUnit9.setText(r.ingredients[8].unitMeasure);
        	newPanel.ingName9.setText(r.ingredients[8].name);
        }
        if (r.ingredients.length >= 10) {
        	newPanel.ingAmount10.setText(r.ingredients[9].amountMeasure);
        	newPanel.ingUnit10.setText(r.ingredients[9].unitMeasure);
        	newPanel.ingName10.setText(r.ingredients[9].name);
        }
        
        String directions = "";
        for (int i = 0; i < r.directions.length; i++) {
        	directions = directions + "\n" + r.directions[i];
        }
        directions = directions.trim();
        newPanel.directionsArea.setText(directions);
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
