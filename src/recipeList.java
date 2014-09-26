import java.util.ArrayList;
/**
 * Created by DaTaMoNsTeReR on 9/9/2014 at 21:07.
 */
public class recipeList {
    public static void main(String[] args) {
        System.out.println("Recipe App");
        testRecipeClass();





        

    }

    public static void testRecipeClass() {
        Ingredient testIng = new Ingredient(10,"stuff","2","cups");
        Ingredient[] testIngList = new Ingredient[] {testIng};

        ArrayList<String> testTags = new ArrayList<String>();
        testTags.add("Unreal");
        testTags.add("Steazy");

        Recipe testRec = new Recipe(20,"Thing",new Ingredient[] {testIng}, new String[] {"Prepare stuff","Cook stuff","Serve stuff"}, testTags);
        testRec.addTag("Super");
        testRec.addTag("Unreal");
        System.out.println(testRec);
    }



}



