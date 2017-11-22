package elements;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Titouan
 *
 * This class represent either an aliment or an organic waste.
 * It include several parameters to save information on its origin
 * as well as control what is and what is not possible within the application.
 */

public class Element implements Serializable{
	private String basicName;			//Basic name of the element used in everydayLife. Ex : 'apple'
    private String idName;              /* Used in the final Excel file.
    									   Format : '(dateCreation.toString) (basicName)(id.toString)'
    									   Ex : '01/01/2017 Apple2'
    									*/
    private String mealType;            //Type of the meal this element was first registered in
    private Date dateCreation;          //Date where this element first appeared
    private int toxicity;               //Set toxicity for a single element
    private int quantity;               //Quantity, as a quotient or a mass (depending on qtIsQuotient)
    private boolean qtIsQuotient;       //Determine whether quantity is a quotient or a mass


    private boolean isBio;              //If the element is bio
    private boolean isFromOwnGarden;    //If the element is from user's own garden

    //Action possible with this element
    private boolean isCompostable;
    private boolean isEdible;
    private boolean isFedable;
    private boolean isThrowable;
    private boolean isUsableForOther;

    //Wastes this element will generate
    private boolean isGeneratingBone;
    private boolean isGeneratingCore;
    private boolean isGeneratingCrust;
    private boolean isGeneratingFat;
    private boolean isGeneratingFilter;
    private boolean isGeneratingPeel;
    private boolean isGeneratingMeatSkin;
    private boolean isGeneratingTail;

    protected Element(String basicName,
    			   String idName,
                   String mealType,
                   Date dateCreation,
                   int toxicity,
                   int quantity,
                   boolean qtIsQuotient,
                   boolean isBio,
                   boolean isFromOwnGarden,
                   boolean isCompostable,
                   boolean isEdible,
                   boolean isFedable,
                   boolean isThrowable,
                   boolean isUsableForOther,
                   boolean isGeneratingBone,
                   boolean isGeneratingCore,
                   boolean isGeneratingCrust,
                   boolean isGeneratingFat,
                   boolean isGeneratingFilter,
                   boolean isGeneratingPeel,
                   boolean isGeneratingMeatSkin,
                   boolean isGeneratingTail){
    	this.basicName = basicName;
        this.idName = idName;
        this.mealType = mealType;
        this.dateCreation = dateCreation;
        this.toxicity = toxicity;
        this.quantity = quantity;
        this.qtIsQuotient = qtIsQuotient;
        this.isBio = isBio;
        this.isFromOwnGarden = isFromOwnGarden;
        this.isCompostable = isCompostable;
        this.isEdible = isEdible;
        this.isFedable = isFedable;
        this.isThrowable = isThrowable;
        this.isUsableForOther = isUsableForOther;
        this.isGeneratingBone = isGeneratingBone;
        this.isGeneratingCore = isGeneratingCore;
        this.isGeneratingCrust = isGeneratingCrust;
        this.isGeneratingFat = isGeneratingFat;
        this.isGeneratingFilter = isGeneratingFilter;
        this.isGeneratingPeel = isGeneratingPeel;
        this.isGeneratingMeatSkin = isGeneratingMeatSkin;
        this.isGeneratingTail = isGeneratingTail;
    }

    //Constructor used to create a waste from origin, will import most of the settings from origin.
    protected Element(Element origin,
    			   String basicName,
                   String idName,
                   String mealType,
                   int toxicity,
                   int quantity,
                   boolean qtIsQuotient,
                   boolean isCompostable,
                   boolean isEdible,
                   boolean isFedable,
                   boolean isThrowable,
                   boolean isUsableForOther){
        this(basicName,
        	 idName,
             mealType,
             origin.getDateCreation(),
             toxicity,
             quantity,
             qtIsQuotient,
             origin.isBio(),
             origin.isFromOwnGarden(),
             isCompostable,
             isEdible,
             isFedable,
             isThrowable,
             isUsableForOther,
             false,
             false,
             false,
             false,
             false,
             false,
             false,
             false);
    }

	@Override
	public String toString() {
		String ret = "Je suis une " + this.basicName + " ! \n";
		ret += "idName : " + this.idName + "\n";
		ret += "Issus d'un : " + this.mealType + " le " + this.dateCreation + "\n";
		if(this.isBio) ret+= "Je suis Bio. \n";
		if(this.isFromOwnGarden) ret+= "Je provient d'un potager. \n";
		
		ret += "Taitement(s) possible(s) : \n";
		if(this.isCompostable) ret+= " -compostable \n";
		if(this.isEdible) ret+= " -comestible \n";
		if(this.isFedable) ret+= " -donnable à manger aux animaux \n";
		if(this.isThrowable) ret+= " -jetable \n";
		if(this.isUsableForOther) ret+= " -utilisable pour d'autres usages \n";
		
		ret += "Je génère : \n";
		if(this.isGeneratingBone) ret+= " -un os \n";
		if(this.isGeneratingCore) ret+= " -un trognon \n";
		if(this.isGeneratingCrust) ret+= " -une croûte \n";
		if(this.isGeneratingFat) ret+= " -du gras \n";
		if(this.isGeneratingFilter) ret+= " -un filtre \n";
		if(this.isGeneratingPeel) ret+= " -une épluchure \n";
		if(this.isGeneratingMeatSkin) ret+= " -une peau \n";
		if(this.isGeneratingTail) ret+= " -une queue \n";
		return ret;
	}

	public String getBasicName() {
		return basicName;
	}

	public String getIdName() {
		return idName;
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

	public boolean isFedable() {
		return isFedable;
	}

	public boolean isThrowable() {
		return isThrowable;
	}

	public boolean isUsableForOther() {
		return isUsableForOther;
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

	public boolean isGeneratingTail() {
		return isGeneratingTail;
	}

	public boolean isGeneratingMeatSkin() {
		return isGeneratingMeatSkin;
	}

    
}
