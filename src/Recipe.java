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
    public ArrayList<String> tags = new ArrayList<String>();
    //we need a recipe constructor with no agruments for the way hibernate likes classes
    // to be structured
    public Recipe()
    {}
    Recipe (int _id, String _name) {
        id = _id;
        name = _name;
        ingredients = new Ingredient[] {new Ingredient(name + " i1"),new Ingredient(name + " i2"),new Ingredient(name + " i3")};
        directions = new String[] {name + "d1",name + "d2",name + "d3"};
        tags = new ArrayList<String>();
        tags.add(name + "tag1");
        tags.add(name + "tag2");
        tags.add(name + "tag3");

    }

    Recipe (int _id, String _name, Ingredient[] _ingredients, String[] _directions, ArrayList<String> _tags) {
        id = _id;
        name = _name;
        ingredients = _ingredients;
        directions = _directions;
        tags = _tags;

    }

    public void addTag(String _tag) {

        if (!tags.contains(_tag)) {
            tags.add(_tag);
            System.out.println(">Tag added: " + _tag);

           // TODO: Add tag to database

        }
        else {
            System.out.println(">Recipe already contains this tag");
        }

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
        for (int i = 0; i < tags.size(); i++) {
            print = print.concat("\t" + tags.get(i) + "\n");
        }

        //return print;
        return name;
    }
}
