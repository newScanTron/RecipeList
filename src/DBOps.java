import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by newScanTron on 10/9/2014.
 */
public class DBOps {
    static Connection conn = null;
    static PreparedStatement pst = null;
    ResultSet resultSet = null;
    ResultSet workingSet = null;
    Recipe[] foundRecipes = {};
    int found_id = 0;
    //this connect method is really just to check for a connections
    //if thats something you want to do before you start manipulating
    //the database
    public void connect()
    {

        try {
            // The newInstance() call is a work around for some
            // broken Java implementations
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
            System.out.println("we hate you so much and cant find the driver");
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipes?allowMultiQueries=true"
                    , "root","");
            // Do something with the Connection
            //doing something with this connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            // going to close all these things but in this program is probable less
            //necessary cus this thing is using basically no memory.
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {
                } // ignore
                resultSet = null;
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException sqlEx) {
                } // ignore
                pst = null;
            }
        }
    }

    //sort of obvious this method searches the recipes
    public Recipe[] searchAll(String name)
    {
        resultSet = searchIngredients(name);
        //
        resultSet = searchRecipe(name);
        //now to tryp to populate a new recipe
        try
        {
            int search_id_int = resultSet.getInt(1);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        String search_id_name = null;
        try
        {
            search_id_name = resultSet.getString(2);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        Recipe foundRecipe = new Recipe(search_id_name, true);
        Recipe[] newRecipes = {foundRecipe};
        foundRecipes = newRecipes;
        //im not sure this is going to work
        resultSet = searchTag(name);

        return foundRecipes;
    }

    public ResultSet searchRecipe(String name)
    {

        try {

            String statement = "SELECT * FROM recipes.recipes WHERE name = \"" + name + "\"";
            pst = conn.prepareStatement(statement);
            resultSet = pst.executeQuery();

            return resultSet;
        }
        catch (SQLException error) {
            System.out.println("prepared statement failed " + error.getMessage());
        }

       return resultSet;
    }
    //method to search by tag
    public ResultSet searchTag(String name)
    {
        try {

            String statement = "SELECT * FROM recipes.tags WHERE name = \"" + name + "\"";
            pst = conn.prepareStatement(statement);
            resultSet = pst.executeQuery();
            return resultSet;
        }
        catch (SQLException error) {
            System.out.println("prepared statement failed " + error.getMessage());
        }
        return resultSet;
    }
    //one last search method to look through the ingreients
    public ResultSet searchIngredients(String name)
    {
        try
        {
            String statement = "SELECT * FROM recipes.ingredients WHERE name = \"" + name + "\"";
            pst = conn.prepareStatement(statement);
            resultSet = pst.executeQuery();
            return resultSet;
        }
        catch (SQLException error)
        {
            System.out.println("prepared statement failed " + error.getMessage());
        }
        return resultSet;
    }
    //this method is to add recipes right now with all th stuff later hope to just
    //add recipe object
    public int addRecipe(Recipe recipe)
    {
        Set<String> set = new HashSet<String>();
        for (int i = recipe.directions.length; i < recipe.directions.length; i -- )
        {
            set.add(recipe.directions[i]);
        }
        try
        {

            //stmnt = "INSERT INTO recipes.recipes(name, description) VALUES(_name, _directions)";
            String stmnt = "INSERT recipes SET name=\"" + recipe.name + "\", description = \"" + recipe.name + "\"";
            pst = conn.prepareStatement(stmnt);
            pst.execute();
            //a while loop to add all the directions to the direction database
            //no real reason for a while over for just is
            resultSet = searchRecipe(recipe.name);
            found_id = resultSet.getInt(1);
            System.out.println("resutl set:" + found_id);

            int addCount = 0;
            String[] directions = recipe.directions;
            while (addCount < directions.length)
            {

                stmnt = "INSERT directions SET directOrder=\"" + addCount + "\", descriptions = \"" + directions[addCount] +
                        "\", recipes_id = (SELECT id FROM recipes WHERE name = \"" + recipe.name + "\")";
                pst = conn.prepareStatement(stmnt);
                pst.execute();

                addCount ++;
            }
            //a for loop to add all the ingredients
            for (Ingredient ingredient: recipe.getIngredients())
            {
                try
                {

                    resultSet = searchIngredients(ingredient.name);
                    if (resultSet != null)
                    System.out.println(resultSet.getInt(1));
                }
                catch (Exception e)
                {
                    System.out.println("this is the lamest exception handeling ever " );
                    e.printStackTrace();
                }

                stmnt = "INSERT ingredients SET name=\"" + ingredient.name + "\"";
                pst = conn.prepareStatement(stmnt);
                pst.execute();
                //now im hopping to add the many to many relationship table
                stmnt = "INSERT recipes_to_ingredients SET ingredients_id = (SELECT id FROM ingredients WHERE name = \"" + ingredient.name + "\")," +
                        "recipes_id = (SELECT id FROM recipes WHERE name = \"" + recipe.name + "\")";
                pst = conn.prepareStatement(stmnt);
                pst.execute();
                //now some more loop action to associate the quality and quanity of ingredients
                stmnt = "INSERT value_of_measurement SET amount = \""+ingredient.amountMeasure + "\";" +
                        "INSERT unit_of_measurement SET description = \"" +ingredient.unitMeasure + "\"";
                pst = conn.prepareStatement(stmnt);
                pst.execute();
                stmnt = "INSERT ingredients_value SET ingredients_id = (SELECT id FROM ingredients WHERE name = \"" + ingredient.name + "\")," +
                        "value_of_measurement_id = (SELECT id FROM value_of_measurement WHERE amount = \"" + ingredient.amountMeasure + "\");" +
                        "INSERT ingredients_quantity SET unit_of_measurement_id = (SELECT id FROM unit_of_measurement WHERE description = \"" + ingredient.unitMeasure + "\")," +
                        "ingredients_id = (SELECT id FROM ingredients WHERE name = \"" + ingredient.name + "\")";
                pst = conn.prepareStatement(stmnt);
                pst.execute();

            }
            //loop to do the tags just like the ingredients
            for (String ingredient: recipe.tags)
            {
                stmnt = "INSERT tags SET name=\"" + ingredient + "\"";
                pst = conn.prepareStatement(stmnt);
                pst.execute();
                //now im hopping to add the many to many relationship table
                stmnt = "INSERT recipes_to_tags SET tags_id = (SELECT id FROM tags WHERE name = \"" + ingredient + "\")," +
                        "recipes_id = (SELECT id FROM recipes WHERE name = \"" + recipe.name + "\")";
                pst = conn.prepareStatement(stmnt);
                pst.execute();
            }


        } catch (SQLException ex)
        {
            System.out.print("we have an SQLException " + ex.getMessage());
        }
        return found_id;
    }
    public void delete(int id)
    {
        String stmnt = "DELETE FROM recipes.recipes WHERE id =\" " + id +  "\"";
        try
        {
            pst = conn.prepareStatement(stmnt);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
