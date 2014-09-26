/**
 * Created by DaTaMoNsTeReR on 9/9/2014 at 21:07.
 */
public class recipeList {
    public static void main(String[] args) {
        System.out.println("Recipe App");
        Ingredient ingredient = new Ingredient();
        System.out.println(ingredient.printIt());
        Controller controller = new Controller();
        System.out.println(controller.toString());

    }

}

