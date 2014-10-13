/**
 * Created by newScanTron on 9/24/2014.
 */
import java.util.ArrayList;
public final class Controller {

    static int temporaryIdCounter = 0;
    static DBOps ops = new DBOps();
    public static void Controller()
    {
        System.out.println("what is going on mang");
    }

    public static recipeList currentRecipes = new recipeList(new Recipe[] {
            new Recipe("Burrito",true),
            new Recipe("Ramen",true),
            new Recipe("Brownie",true),                        // This is where the current recipe objects used in the JList are stored
            new Recipe("Pizza",true),
            new Recipe("Taco",true),
            new Recipe("Cereal",true),
            new Recipe("Waffles",true)
    });


    public static Recipe addRecipe(Recipe newRecipe) {

        currentRecipes.add(newRecipe);

        //TODO: Add recipe to database

        return null;

    }

    public static void deleteRecipeByID(int id) {

        currentRecipes.remove(currentRecipes.findIndexByID(id));

        // TODO: Also delete recipe from database
        ops.delete(id);

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

        Recipe addedRecipe = new Recipe(0,_name,ingArray,_directions,_tags);
        if (!_name.equals(""))
        	;
            currentRecipes.add(addedRecipe);

        ops.connect();
        ops.addRecipe(addedRecipe);


    }

    public static void searchRecipe(String searchInput) {

        System.out.println("Searching for '" + searchInput + "' in database...");

        //TODO: Search function that compiles all recipes in database containing searchInput into an array of recipes

        Recipe[] results = new Recipe[] {
                new Recipe("Search Result 1",true),
                new Recipe("Search Result 2",true),
                new Recipe("Search Result 3",true),          // Placeholder for search results
                new Recipe("Search Result 4",true)
        };

        currentRecipes.recipes = results;

    }

    public static void openAddWindow(Recipe r,boolean editting) {

    	AddRecipeGUI newPanel = new AddRecipeGUI();
        Driver.newPanel = newPanel;
        Driver.displayFrame.getContentPane().removeAll();
        Driver.displayFrame.getContentPane().add(Driver.newPanel);

        Driver.displayFrame.pack();

        Driver.displayFrame.setLocationRelativeTo(null);
        Driver.displayFrame.setVisible(true);

        newPanel.nameField.setText("New Recipe");
        newPanel.submit.setText("Save New Recipe");


        if (editting) {

            newPanel.edittingID = r.id;

            newPanel.submit.setText("Save Editted Recipe");

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
    }

    public static void closeAddWindow(int edittingID) {

        Driver.newPanel = new RecipeGUI();
        Driver.displayFrame.getContentPane().removeAll();
        Driver.displayFrame.getContentPane().add(Driver.newPanel);

        Driver.displayFrame.pack();

        Driver.displayFrame.setLocationRelativeTo(null);
        Driver.displayFrame.setVisible(true);

        if (edittingID != -1) {
            Controller.deleteRecipeByID(edittingID);
        }


    }


}
