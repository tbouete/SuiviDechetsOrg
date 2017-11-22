package elements;

/**
 * Created by Titouan on 13/11/2017.
 */

public enum MealType {
    breakfast("petit-d�jeuner"),
    lunch("d�jeuner"),
    afternoonMeal("go�ter"),
    dinner("d�ner"),
    other("autre");

    private String name = "";

    MealType(String name){ this.name = name; }

    public String toString(){ return name; }
}
