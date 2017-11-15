package elements;

import java.util.Date;

/**
 * Created by Titouan on 13/11/2017.
 */

public class Element {
    private String name;                //Format to be determined
    private String mealType;            //Type of the meal this element was first registered in
    private Date dateCreation;          //Date where this element first appeared
    private int toxicity;               //Set toxicity for a single element
    private int quantity;               //Quantity, as a quotient or a mass (depending on qtIsQuotient)
    private boolean qtIsQuotient;       //Determine whether quantity is a quotient or a mass


    private boolean isBio;              //If the element is biological
    private boolean isFromOwnGarden;    //If the element is from user's own garden

    private boolean isCompostable;
    private boolean isEdible;
    private boolean isFeedable;
    private boolean isThrowable;
    private boolean isUsableForOther;


    private boolean isGeneratingBag;
    private boolean isGeneratingBone;
    private boolean isGeneratingCore;
    private boolean isGeneratingCrust;
    private boolean isGeneratingFat;
    private boolean isGeneratingFilter;
    private boolean isGeneratingPeel;
    private boolean isGeneratingQueue;
    private boolean isGeneratingSkin;

    public Element(String name,
                   String mealType,
                   Date dateCreation,
                   int toxicity,
                   int quantity,
                   boolean qtIsQuotient,
                   boolean isBio,
                   boolean isFromOwnGarden,
                   boolean isCompostable,
                   boolean isEatable,
                   boolean isFeedable,
                   boolean isThrowable,
                   boolean isUsableForOther,
                   boolean isGeneratingBag,
                   boolean isGeneratingBone,
                   boolean isGeneratingCore,
                   boolean isGeneratingCrust,
                   boolean isGeneratingFat,
                   boolean isGeneratingFilter,
                   boolean isGeneratingPeel,
                   boolean isGeneratingQueue,
                   boolean isGeneratingSkin){
        this.name = name;
        this.mealType = mealType;
        this.dateCreation = dateCreation;
        this.toxicity = toxicity;
        this.quantity = quantity;
        this.qtIsQuotient = qtIsQuotient;
        this.isBio = isBio;
        this.isFromOwnGarden = isFromOwnGarden;
        this.isCompostable = isCompostable;
        this.isEdible = isEatable;
        this.isFeedable = isFeedable;
        this.isThrowable = isThrowable;
        this.isUsableForOther = isUsableForOther;
        this.isGeneratingBag = isGeneratingBag;
        this.isGeneratingBone = isGeneratingBone;
        this.isGeneratingCore = isGeneratingCore;
        this.isGeneratingCrust = isGeneratingCrust;
        this.isGeneratingFat = isGeneratingFat;
        this.isGeneratingFilter = isGeneratingFilter;
        this.isGeneratingPeel = isGeneratingPeel;
        this.isGeneratingQueue = isGeneratingQueue;
        this.isGeneratingSkin = isGeneratingSkin;
    }

    //Constructor used to create a waste from origin, will import most of the settings from origin.
    public Element(Element origin,
                   String name,
                   String mealType,
                   int toxicity,
                   int quantity,
                   boolean qtIsQuotient,
                   boolean isCompostable,
                   boolean isEdible,
                   boolean isFeedable,
                   boolean isThrowable,
                   boolean isUsableForOther){
        this(name,
                mealType,
                origin.getDateCreation(),
                toxicity,
                quantity,
                qtIsQuotient,
                origin.isBio(),
                origin.isFromOwnGarden(),
                isCompostable,
                isEdible,
                isFeedable,
                isThrowable,
                isUsableForOther,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false);
    }

    public String getName() {
        return name;
    }

    public String getMealType() {
        return mealType;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public int getToxicity() {
        return toxicity;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isQtIsQuotient() {
        return qtIsQuotient;
    }

    public boolean isBio() {
        return isBio;
    }

    public boolean isFromOwnGarden() {
        return isFromOwnGarden;
    }

    public boolean isCompostable() {
        return isCompostable;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public boolean isFeedable() {
        return isFeedable;
    }

    public boolean isThrowable() {
        return isThrowable;
    }

    public boolean isUsableForOther() {
        return isUsableForOther;
    }

    public boolean isGeneratingBag() {
        return isGeneratingBag;
    }

    public boolean isGeneratingBone() {
        return isGeneratingBone;
    }

    public boolean isGeneratingCore() {
        return isGeneratingCore;
    }

    public boolean isGeneratingCrust() {
        return isGeneratingCrust;
    }

    public boolean isGeneratingFat() {
        return isGeneratingFat;
    }

    public boolean isGeneratingFilter() {
        return isGeneratingFilter;
    }

    public boolean isGeneratingPeel() {
        return isGeneratingPeel;
    }

    public boolean isGeneratingQueue() {
        return isGeneratingQueue;
    }

    public boolean isGeneratingSkin() {
        return isGeneratingSkin;
    }
}
