/**
 * Created by newScanTron on 9/17/2014.
 */
public class Ingredient {

    public int id;
    public String name;
    public String amountMeasure;
    public String unitMeasure;

    Ingredient(String _name) {
        name = _name;
    }

    Ingredient(int _id, String _name, String _amountMeasure, String _unitMeasure) {
        id = _id;
        name = _name;
        amountMeasure = _amountMeasure;
        unitMeasure = _unitMeasure;

    }

    public void setName(String _name){
        name = _name;
        System.out.println("this is your name");

    }


    @Override
    public String toString() {

        return amountMeasure + " " + unitMeasure + " " + name;

    }
}
