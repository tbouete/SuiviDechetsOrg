package elements;

/**
 * Created by Titouan on 13/11/2017.
 */

public enum MealType {
    breakfast("petit-déjeuner"),
    lunch("déjeuner"),
    afternoonMeal("goûter"),
    dinner("dîner"),
    other("autre");

    private String name = "";

    MealType(String name){ this.name = name; }

    public String toString(){ return name; }
}
