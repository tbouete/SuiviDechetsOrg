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

public abstract class Element implements Serializable{
	private String basicName;			//Basic name of the element used in everydayLife. Ex : 'apple'
	private int id;
    
    private int minWeightCompost = 0;
    private int maxWeightCompost = 0;
    private double quantity;            //Quantity, as a quotient or a mass (depending on qtIsQuotient)
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

    public Element(double quantity, boolean qtIsQuotient, boolean isBio, boolean isFromOwnGarden){
        this.quantity = quantity;
        this.qtIsQuotient = qtIsQuotient;
        this.isBio = isBio;
        this.isFromOwnGarden = isFromOwnGarden;
    }

	@Override
	public String toString() {
		String ret = "Je suis une " + this.basicName + " ! \n";
		if(this.isBio) ret+= "Je suis Bio. \n";
		if(this.isFromOwnGarden) ret+= "Je provient d'un potager. \n";
		
		ret += "Taitement(s) possible(s) : \n";
		if(this.isCompostable) ret+= " -compostable \n";
		if(this.isEdible) ret+= " -comestible \n";
		if(this.isFedable) ret+= " -donnable � manger aux animaux \n";
		if(this.isThrowable) ret+= " -jetable \n";
		if(this.isUsableForOther) ret+= " -utilisable pour d'autres usages \n";
		
		ret += "Je g�n�re : \n";
		if(this.isGeneratingBone) ret+= " -un os \n";
		if(this.isGeneratingCore) ret+= " -un trognon \n";
		if(this.isGeneratingCrust) ret+= " -une cro�te \n";
		if(this.isGeneratingFat) ret+= " -du gras \n";
		if(this.isGeneratingFilter) ret+= " -un filtre \n";
		if(this.isGeneratingPeel) ret+= " -une �pluchure \n";
		if(this.isGeneratingMeatSkin) ret+= " -une peau \n";
		if(this.isGeneratingTail) ret+= " -une queue \n";
		return ret;
	}


    public String getBasicName() {
		return basicName;
	}
	
	public int getId(){
		return id;
	}

	public int getMinWeightCompost() {
		return minWeightCompost;
	}
	
	public int getMaxWeightCompost() {
		return maxWeightCompost;
	}

	public double getQuantity() {
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

	public boolean isGeneratingMeatSkin() {
		return isGeneratingMeatSkin;
	}

	public boolean isGeneratingTail() {
		return isGeneratingTail;
	}

	public void setBasicName(String basicName) {
		this.basicName = basicName;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public void setMinWeightCompost(int minWeightCompost) {
		this.minWeightCompost = minWeightCompost;
	}
	
	public void setMaxWeightCompost(int maxWeightCompost) {
		this.maxWeightCompost = maxWeightCompost;
	}

	public void setCompostable(boolean isCompostable) {
		this.isCompostable = isCompostable;
	}

	public void setEdible(boolean isEdible) {
		this.isEdible = isEdible;
	}

	public void setFedable(boolean isFedable) {
		this.isFedable = isFedable;
	}

	public void setThrowable(boolean isThrowable) {
		this.isThrowable = isThrowable;
	}

	public void setUsableForOther(boolean isUsableForOther) {
		this.isUsableForOther = isUsableForOther;
	}

	public void setGeneratingBone(boolean isGeneratingBone) {
		this.isGeneratingBone = isGeneratingBone;
	}

	public void setGeneratingCore(boolean isGeneratingCore) {
		this.isGeneratingCore = isGeneratingCore;
	}

	public void setGeneratingCrust(boolean isGeneratingCrust) {
		this.isGeneratingCrust = isGeneratingCrust;
	}

	public void setGeneratingFat(boolean isGeneratingFat) {
		this.isGeneratingFat = isGeneratingFat;
	}

	public void setGeneratingFilter(boolean isGeneratingFilter) {
		this.isGeneratingFilter = isGeneratingFilter;
	}

	public void setGeneratingPeel(boolean isGeneratingPeel) {
		this.isGeneratingPeel = isGeneratingPeel;
	}

	public void setGeneratingMeatSkin(boolean isGeneratingMeatSkin) {
		this.isGeneratingMeatSkin = isGeneratingMeatSkin;
	}

	public void setGeneratingTail(boolean isGeneratingTail) {
		this.isGeneratingTail = isGeneratingTail;
	}
	
	
}
