/**
 * Created by newScanTron on 9/17/2014.
 */
public class Ingredient {

    public int id;
    public String name;
    public String valueMeasure;
    public String unitMeasure;

    Ingredient(int _id, String _name, String _valueMeasure, String _unitMeasure) {
        id = _id;
        name = _name;
        valueMeasure = _valueMeasure;
        unitMeasure = _unitMeasure;

    }

    public void setName(String _name){
        name = _name;
        System.out.println("this is your name");

    }

    @Override
    public String toString() {
        return valueMeasure + " " + unitMeasure + " of " + name;
    }
}
