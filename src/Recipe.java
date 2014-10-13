import java.util.ArrayList;

/**
 * Created by aaronc on 9/26/14.
 */
public class Recipe {

    public int id;
    public String name;

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredient[] ingredients;
    public String[] directions;
    public String[] tags = new String[0];
    //we need a recipe constructor with no agruments for the way hibernate likes classes
    // to be structured
    public Recipe(){
        ingredients = new Ingredient[0];
        directions = new String[0];
    }
    Recipe (String _name, boolean thisIsSoWeRememberToTakeOutTheseConstructors) {
        id = Controller.temporaryIdCounter;
        Controller.temporaryIdCounter += 1;
        name = _name;
        ingredients = new Ingredient[] {new Ingredient(name + " i1"),new Ingredient(name + " i2"),new Ingredient(name + " i3")};
        directions = new String[] {name + "d1",name + "d2",name + "d3"};
        tags = new String[3];
        tags[0] = (name + "tag1");
        tags[1] = (name + "tag2");
        tags[2] = (name + "tag3");

    }

    Recipe (int _id, String _name, Ingredient[] _ingredients, String[] _directions, String[] _tags) {
        id = _id;
        name = _name;
        ingredients = _ingredients;
        directions = _directions;
        tags = _tags;

    }


    public String[] getIngredientNames() {

            String[] names = new String[ingredients.length];

            for (int i = 0; i < names.length; i++) {
                names[0] = ingredients[i].name;
            }
            return names;

    }

    @Override
    public String toString() {
        String print = "\n" + name + " (" + id + ")\n";

        print = print.concat("Ingredients:\n");
        for (int i = 0; i < ingredients.length; i++) {
            print = print.concat("\t" + ingredients[i] + "\n");
        }

        print = print.concat("Directions:\n");
        for (int i = 0; i < directions.length; i++) {
            print = print.concat("\t" + directions[i] + "\n");
        }

        print = print.concat("Tags:\n");
        for (int i = 0; i < tags.length; i++) {
            print = print.concat("\t" + tags[i] + "\n");
        }

        //return print;
        return print;
    }
}
