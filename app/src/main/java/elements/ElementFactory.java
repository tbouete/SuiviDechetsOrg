package elements;

import java.util.Date;

/**
 * Created by Titouan on 15/11/2017.
 */

public abstract class ElementFactory {
	
	private int id = 1;
	private boolean isBio = false;
	private boolean isFromOwnGarden = false;

	public void setIsBio(boolean isBio){ this.isBio = isBio; }
	public void setIsFromOwnGarden(boolean isFromOwnGarden){ this.isFromOwnGarden = isFromOwnGarden; }
	
		
public Element getElementAbricot(String mealType, Date dateCreation){
    	
    	String basicName = "Abricot";
    	this.id++;
    	
        return new Element(basicName,
        				   this.getIdName(basicName, mealType, dateCreation),
		        		   mealType,
		        		   dateCreation,
		        		   0, 				 //TODO : Toxicity : to be determined !!!
		        		   1,  				 //quantity
		        		   true,     		 //qtIsQuotient
		        		   this.isBio,
		        		   this.isFromOwnGarden,
		        		   true,			//isCompostable
		        		   true,			//isEdible
		        		   true,			//isFedable
		        		   true,			//isThrowable
		        		   true,			//isUsableForOther
		        		   false,			//isGeneratingBone
		        		   true,			//isGeneratingCore
		        		   false,			//isGeneratingCrust
		        		   false,			//isGeneratingFat
		        		   false,			//isGeneratingFilter
		        		   true,			//isGeneratingPeel
		        		   false,			//isGeneratingMeatSkin
		        		   false);			//isGeneratingTail
    }
    
    public Element getElementAbricotDechets(String mealType, Date dateCreation, Element abricot){
    	String basicName = "AbricotDechets(Epluchures, Noyau)";
    	
    	return new Element(abricot,
    					   basicName,
    					   this.getIdName(basicName, mealType, dateCreation),
    					   mealType,
    					   0, 			//TODO : Toxicity : to be determined
    					   1,			//quantity
    					   true,		//qtIsQuotient    					   
    					   true,		//isCompostable
    					   false,		//isEdible
    					   true,		//isFedable
    					   true,		//isThrowable
    					   true);		//isUsableForOther
    	
    }
	
    public Element getElementAil(String mealType, Date dateCreation){
    	
    	String basicName = "Ail";
    	this.id++;
    	
        return new Element(basicName,
        				   this.getIdName(basicName, mealType, dateCreation),
		        		   mealType,
		        		   dateCreation,
		        		   0, 				 //TODO : Toxicity : to be determined !!!
		        		   1,  				 //quantity
		        		   true,     		 //qtIsQuotient
		        		   this.isBio,
		        		   this.isFromOwnGarden,
		        		   true,			//isCompostable
		        		   true,			//isEdible
		        		   true,			//isFedable
		        		   true,			//isThrowable
		        		   true,			//isUsableForOther
		        		   false,			//isGeneratingBone
		        		   false,			//isGeneratingCore
		        		   false,			//isGeneratingCrust
		        		   false,			//isGeneratingFat
		        		   false,			//isGeneratingFilter
		        		   true,			//isGeneratingPeel
		        		   false,			//isGeneratingMeatSkin
		        		   false);			//isGeneratingTail
    }
    
    public Element getElementAilDechets(String mealType, Date dateCreation, Element ail){
    	String basicName = "AilD�chets(Epluchures)";
    	
    	return new Element(ail,
    					   basicName,
    					   this.getIdName(basicName, mealType, dateCreation),
    					   mealType,
    					   0, 			//TODO : Toxicity : to be determined
    					   1,			//quantity
    					   true,		//qtIsQuotient    					   
    					   true,		//isCompostable
    					   false,		//isEdible
    					   true,		//isFedable
    					   true,		//isThrowable
    					   true);		//isUsableForOther
    	
    }
    
    public Element getElementAvocat(String mealType, Date dateCreation){
    	
    	String basicName = "Avocat";
    	this.id++;
    	
        return new Element(basicName,
        				   this.getIdName(basicName, mealType, dateCreation),
		        		   mealType,
		        		   dateCreation,
		        		   0, 				 //TODO : Toxicity : to be determined !!!
		        		   1,  				 //quantity
		        		   true,     		 //qtIsQuotient
		        		   this.isBio,
		        		   this.isFromOwnGarden,
		        		   true,			//isCompostable
		        		   true,			//isEdible
		        		   true,			//isFedable
		        		   true,			//isThrowable
		        		   true,			//isUsableForOther
		        		   false,			//isGeneratingBone
		        		   true,			//isGeneratingCore
		        		   false,			//isGeneratingCrust
		        		   false,			//isGeneratingFat
		        		   false,			//isGeneratingFilter
		        		   true,			//isGeneratingPeel
		        		   false,			//isGeneratingMeatSkin
		        		   false);			//isGeneratingTail
    }
    
    public Element getElementAvocatDechets(String mealType, Date dateCreation, Element avocat){
    	String basicName = "AvocatD�chets(Peau, Noyau)";
    	
    	return new Element(avocat,
    					   basicName,
    					   this.getIdName(basicName, mealType, dateCreation),
    					   mealType,
    					   0, 			//TODO : Toxicity : to be determined
    					   1,			//quantity
    					   true,		//qtIsQuotient    					   
    					   true,		//isCompostable
    					   false,		//isEdible
    					   true,		//isFedable
    					   true,		//isThrowable
    					   true);		//isUsableForOther
    	
    }
    
	public Element getElementBanane(String mealType, Date dateCreation){
    	
    	String basicName = "Banane";
    	this.id++;
    	
        return new Element(basicName,
        				   this.getIdName(basicName, mealType, dateCreation),
		        		   mealType,
		        		   dateCreation,
		        		   0, 				 //TODO : Toxicity : to be determined !!!
		        		   1,  				 //quantity
		        		   true,     		 //qtIsQuotient
		        		   this.isBio,
		        		   this.isFromOwnGarden,
		        		   true,			//isCompostable
		        		   true,			//isEdible
		        		   true,			//isFedable
		        		   true,			//isThrowable
		        		   true,			//isUsableForOther
		        		   false,			//isGeneratingBone
		        		   false,			//isGeneratingCore
		        		   false,			//isGeneratingCrust
		        		   false,			//isGeneratingFat
		        		   false,			//isGeneratingFilter
		        		   true,			//isGeneratingPeel
		        		   false,			//isGeneratingMeatSkin
		        		   false);			//isGeneratingTail
    }
    
    public Element getElementBananeDechets(String mealType, Date dateCreation, Element banane){
    	String basicName = "BananeD�chets(Peau)";
    	
    	return new Element(banane,
    					   basicName,
    					   this.getIdName(basicName, mealType, dateCreation),
    					   mealType,
    					   0, 			//TODO : Toxicity : to be determined
    					   1,			//quantity
    					   true,		//qtIsQuotient    					   
    					   true,		//isCompostable
    					   false,		//isEdible
    					   true,		//isFedable
    					   true,		//isThrowable
    					   true);		//isUsableForOther
    	
    }
    
    public Element getElementCarotte(String mealType, Date dateCreation){
    	
    	String basicName = "Carotte";
    	this.id++;
    	
        return new Element(basicName,
        				   this.getIdName(basicName, mealType, dateCreation),
		        		   mealType,
		        		   dateCreation,
		        		   0, 				 //TODO : Toxicity : to be determined !!!
		        		   1,  				 //quantity
		        		   true,     		 //qtIsQuotient
		        		   this.isBio,
		        		   this.isFromOwnGarden,
		        		   true,			//isCompostable
		        		   true,			//isEdible
		        		   true,			//isFedable
		        		   true,			//isThrowable
		        		   true,			//isUsableForOther
		        		   false,			//isGeneratingBone
		        		   false,			//isGeneratingCore
		        		   false,			//isGeneratingCrust
		        		   false,			//isGeneratingFat
		        		   false,			//isGeneratingFilter
		        		   true,			//isGeneratingPeel
		        		   false,			//isGeneratingMeatSkin
		        		   false);			//isGeneratingTail
    }
    
    public Element getElementCarotteDechets(String mealType, Date dateCreation, Element carotte){
    	String basicName = "CarotteD�chets(Epluchures)";
    	
    	return new Element(carotte,
    					   basicName,
    					   this.getIdName(basicName, mealType, dateCreation),
    					   mealType,
    					   0, 			//TODO : Toxicity : to be determined
    					   1,			//quantity
    					   true,		//qtIsQuotient    					   
    					   true,		//isCompostable
    					   false,		//isEdible
    					   true,		//isFedable
    					   true,		//isThrowable
    					   true);		//isUsableForOther
    	
    }
    
    public Element getElementCitron(String mealType, Date dateCreation){
    	
    	String basicName = "Citron";
    	this.id++;
    	
        return new Element(basicName,
        				   this.getIdName(basicName, mealType, dateCreation),
		        		   mealType,
		        		   dateCreation,
		        		   0, 				 //TODO : Toxicity : to be determined !!!
		        		   1,  				 //quantity
		        		   true,     		 //qtIsQuotient
		        		   this.isBio,
		        		   this.isFromOwnGarden,
		        		   true,			//isCompostable
		        		   true,			//isEdible
		        		   true,			//isFedable
		        		   true,			//isThrowable
		        		   true,			//isUsableForOther
		        		   false,			//isGeneratingBone
		        		   false,			//isGeneratingCore
		        		   false,			//isGeneratingCrust
		        		   false,			//isGeneratingFat
		        		   false,			//isGeneratingFilter
		        		   true,			//isGeneratingPeel
		        		   false,			//isGeneratingMeatSkin
		        		   false);			//isGeneratingTail
    }
    
    public Element getElementCitronDechets(String mealType, Date dateCreation, Element citron){
    	String basicName = "CitronD�chets(Epluchures)";
    	
    	return new Element(citron,
    					   basicName,
    					   this.getIdName(basicName, mealType, dateCreation),
    					   mealType,
    					   0, 			//TODO : Toxicity : to be determined
    					   1,			//quantity
    					   true,		//qtIsQuotient    					   
    					   true,		//isCompostable
    					   false,		//isEdible
    					   true,		//isFedable
    					   true,		//isThrowable
    					   true);		//isUsableForOther
    	
    }
	
    public Element getElementClementine(String mealType, Date dateCreation){
    	
    	String basicName = "Cl�mentine";
    	this.id++;
    	
        return new Element(basicName,
        				   this.getIdName(basicName, mealType, dateCreation),
		        		   mealType,
		        		   dateCreation,
		        		   0, 				 //TODO : Toxicity : to be determined !!!
		        		   1,  				 //quantity
		        		   true,     		 //qtIsQuotient
		        		   this.isBio,
		        		   this.isFromOwnGarden,
		        		   true,			//isCompostable
		        		   true,			//isEdible
		        		   true,			//isFedable
		        		   true,			//isThrowable
		        		   true,			//isUsableForOther
		        		   false,			//isGeneratingBone
		        		   false,			//isGeneratingCore
		        		   false,			//isGeneratingCrust
		        		   false,			//isGeneratingFat
		        		   false,			//isGeneratingFilter
		        		   true,			//isGeneratingPeel
		        		   false,			//isGeneratingMeatSkin
		        		   false);			//isGeneratingTail
    }
    
    public Element getElementClementineDechets(String mealType, Date dateCreation, Element clementine){
    	String basicName = "Cl�mentineD�chets(Epluchures)";
    	
    	return new Element(clementine,
    					   basicName,
    					   this.getIdName(basicName, mealType, dateCreation),
    					   mealType,
    					   0, 			//TODO : Toxicity : to be determined
    					   1,			//quantity
    					   true,		//qtIsQuotient    					   
    					   true,		//isCompostable
    					   false,		//isEdible
    					   true,		//isFedable
    					   true,		//isThrowable
    					   true);		//isUsableForOther
    	
    }
    
    public Element getElementFraise(String mealType, Date dateCreation){
    	
    	String basicName = "Fraise";
    	this.id++;
    	
        return new Element(basicName,
        				   this.getIdName(basicName, mealType, dateCreation),
		        		   mealType,
		        		   dateCreation,
		        		   0, 				 //TODO : Toxicity : to be determined !!!
		        		   1,  				 //quantity
		        		   true,     		 //qtIsQuotient
		        		   this.isBio,
		        		   this.isFromOwnGarden,
		        		   true,			//isCompostable
		        		   true,			//isEdible
		        		   true,			//isFedable
		        		   true,			//isThrowable
		        		   true,			//isUsableForOther
		        		   false,			//isGeneratingBone
		        		   false,			//isGeneratingCore
		        		   false,			//isGeneratingCrust
		        		   false,			//isGeneratingFat
		        		   false,			//isGeneratingFilter
		        		   false,			//isGeneratingPeel
		        		   false,			//isGeneratingMeatSkin
		        		   true);			//isGeneratingTail
    }
    
    public Element getElementFraiseDechets(String mealType, Date dateCreation, Element fraise){
    	String basicName = "FraiseD�chets(Noyau)";
    	
    	return new Element(fraise,
    					   basicName,
    					   this.getIdName(basicName, mealType, dateCreation),
    					   mealType,
    					   0, 			//TODO : Toxicity : to be determined
    					   1,			//quantity
    					   true,		//qtIsQuotient    					   
    					   true,		//isCompostable
    					   false,		//isEdible
    					   true,		//isFedable
    					   true,		//isThrowable
    					   true);		//isUsableForOther
    	
    }
    
    public Element getElementOignon(String mealType, Date dateCreation){
    	
    	String basicName = "Oignon";
    	this.id++;
    	
        return new Element(basicName,
        				   this.getIdName(basicName, mealType, dateCreation),
		        		   mealType,
		        		   dateCreation,
		        		   0, 				 //TODO : Toxicity : to be determined !!!
		        		   1,  				 //quantity
		        		   true,     		 //qtIsQuotient
		        		   this.isBio,
		        		   this.isFromOwnGarden,
		        		   true,			//isCompostable
		        		   true,			//isEdible
		        		   true,			//isFedable
		        		   true,			//isThrowable
		        		   true,			//isUsableForOther
		        		   false,			//isGeneratingBone
		        		   false,			//isGeneratingCore
		        		   false,			//isGeneratingCrust
		        		   false,			//isGeneratingFat
		        		   false,			//isGeneratingFilter
		        		   true,			//isGeneratingPeel
		        		   false,			//isGeneratingMeatSkin
		        		   false);			//isGeneratingTail
    }
    
    public Element getElementOignonDechets(String mealType, Date dateCreation, Element oignon){
    	String basicName = "OignonD�chets(Peau)";
    	
    	return new Element(oignon,
    					   basicName,
    					   this.getIdName(basicName, mealType, dateCreation),
    					   mealType,
    					   0, 			//TODO : Toxicity : to be determined
    					   1,			//quantity
    					   true,		//qtIsQuotient    					   
    					   true,		//isCompostable
    					   false,		//isEdible
    					   true,		//isFedable
    					   true,		//isThrowable
    					   true);		//isUsableForOther
    	
    }
    
    public Element getElementOrange(String mealType, Date dateCreation){
    	
    	String basicName = "Orange";
    	this.id++;
    	
        return new Element(basicName,
        				   this.getIdName(basicName, mealType, dateCreation),
		        		   mealType,
		        		   dateCreation,
		        		   0, 				 //TODO : Toxicity : to be determined !!!
		        		   1,  				 //quantity
		        		   true,     		 //qtIsQuotient
		        		   this.isBio,
		        		   this.isFromOwnGarden,
		        		   true,			//isCompostable
		        		   true,			//isEdible
		        		   true,			//isFedable
		        		   true,			//isThrowable
		        		   true,			//isUsableForOther
		        		   false,			//isGeneratingBone
		        		   false,			//isGeneratingCore
		        		   false,			//isGeneratingCrust
		        		   false,			//isGeneratingFat
		        		   false,			//isGeneratingFilter
		        		   true,			//isGeneratingPeel
		        		   false,			//isGeneratingMeatSkin
		        		   false);			//isGeneratingTail
    }
    
    public Element getElementOrangeDechets(String mealType, Date dateCreation, Element pomme){
    	String basicName = "OrangeD�chets(Epluchures)";
    	
    	return new Element(pomme,
    					   basicName,
    					   this.getIdName(basicName, mealType, dateCreation),
    					   mealType,
    					   0, 			//TODO : Toxicity : to be determined
    					   1,			//quantity
    					   true,		//qtIsQuotient    					   
    					   true,		//isCompostable
    					   false,		//isEdible
    					   true,		//isFedable
    					   true,		//isThrowable
    					   true);		//isUsableForOther
    	
    }
    
    public Element getElementPeche(String mealType, Date dateCreation){
    	
    	String basicName = "P�che";
    	this.id++;
    	
        return new Element(basicName,
        				   this.getIdName(basicName, mealType, dateCreation),
		        		   mealType,
		        		   dateCreation,
		        		   0, 				 //TODO : Toxicity : to be determined !!!
		        		   1,  				 //quantity
		        		   true,     		 //qtIsQuotient
		        		   this.isBio,
		        		   this.isFromOwnGarden,
		        		   true,			//isCompostable
		        		   true,			//isEdible
		        		   true,			//isFedable
		        		   true,			//isThrowable
		        		   true,			//isUsableForOther
		        		   false,			//isGeneratingBone
		        		   true,			//isGeneratingCore
		        		   false,			//isGeneratingCrust
		        		   false,			//isGeneratingFat
		        		   false,			//isGeneratingFilter
		        		   true,			//isGeneratingPeel
		        		   false,			//isGeneratingMeatSkin
		        		   false);			//isGeneratingTail
    }
    
    public Element getElementPecheDechets(String mealType, Date dateCreation, Element peche){
    	String basicName = "P�cheD�chets(Epluchures, Noyau)";
    	
    	return new Element(peche,
    					   basicName,
    					   this.getIdName(basicName, mealType, dateCreation),
    					   mealType,
    					   0, 			//TODO : Toxicity : to be determined
    					   1,			//quantity
    					   true,		//qtIsQuotient    					   
    					   true,		//isCompostable
    					   false,		//isEdible
    					   true,		//isFedable
    					   true,		//isThrowable
    					   true);		//isUsableForOther
    	
    }
    
	public Element getElementPoire(String mealType, Date dateCreation){
    	String basicName = "Poire";
    	
    	return new Element(basicName,
				   this.getIdName(basicName, mealType, dateCreation),
				   mealType,
	     		   dateCreation,
	     		   0, 				 //TODO : Toxicity : to be determined !!!
	     		   1,  				 //quantity
	     		   true,     		 //qtIsQuotient
	     		   this.isBio,
	     		   this.isFromOwnGarden,
	     		   true,			//isCompostable
	     		   true,			//isEdible
	     		   true,			//isFedable
	     		   true,			//isThrowable
	     		   true,			//isUsableForOther
	     		   false,			//isGeneratingBone
	     		   true,			//isGeneratingCore
	     		   false,			//isGeneratingCrust
	     		   false,			//isGeneratingFat
	     		   false,			//isGeneratingFilter
	     		   true,			//isGeneratingPeel
	     		   false,			//isGeneratingMeatSkin
	     		   false);			//isGeneratingTail
    	
    }
	
	public Element getElementPoireDechet(String mealType, Date dateCreation, Element poire){
    	String basicName = "PoireD�chets(Epluchures, Trogon)";
    	
    	return new Element(poire,
    					   basicName,
    					   this.getIdName(basicName, mealType, dateCreation),
    					   mealType,
    					   0, 			//TODO : Toxicity : to be determined
    					   1,			//quantity
    					   true,		//qtIsQuotient
    					   true,		//isCompostable
    					   false,		//isEdible
    					   true,		//isFedable
    					   true,		//isThrowable
    					   true);		//isUsableForOther
    	
    }
	
    public Element getElementPomme(String mealType, Date dateCreation){
    	
    	String basicName = "Pomme";
    	this.id++;
    	
        return new Element(basicName,
        				   this.getIdName(basicName, mealType, dateCreation),
		        		   mealType,
		        		   dateCreation,
		        		   0, 				 //TODO : Toxicity : to be determined !!!
		        		   1,  				 //quantity
		        		   true,     		 //qtIsQuotient
		        		   this.isBio,
		        		   this.isFromOwnGarden,
		        		   true,			//isCompostable
		        		   true,			//isEdible
		        		   true,			//isFedable
		        		   true,			//isThrowable
		        		   true,			//isUsableForOther
		        		   false,			//isGeneratingBone
		        		   true,			//isGeneratingCore
		        		   false,			//isGeneratingCrust
		        		   false,			//isGeneratingFat
		        		   false,			//isGeneratingFilter
		        		   true,			//isGeneratingPeel
		        		   false,			//isGeneratingMeatSkin
		        		   false);			//isGeneratingTail
		        		   
    }
    
    public Element getElementPommeDechets(String mealType, Date dateCreation, Element pomme){
    	String basicName = "PommeD�chets(Epluchures, Trogon)";
    	
    	return new Element(pomme,
    					   basicName,
    					   this.getIdName(basicName, mealType, dateCreation),
    					   mealType,
    					   0, 			//TODO : Toxicity : to be determined
    					   1,			//quantity
    					   true,		//qtIsQuotient
    					   true,		//isCompostable
    					   false,		//isEdible
    					   true,		//isFedable
    					   true,		//isThrowable
    					   true);		//isUsableForOther
    	
    }
    
    public Element getElementTomate(String mealType, Date dateCreation){
    	
    	String basicName = "Tomate";
    	this.id++;
    	
        return new Element(basicName,
        				   this.getIdName(basicName, mealType, dateCreation),
		        		   mealType,
		        		   dateCreation,
		        		   0, 				 //TODO : Toxicity : to be determined !!!
		        		   1,  				 //quantity
		        		   true,     		 //qtIsQuotient
		        		   this.isBio,
		        		   this.isFromOwnGarden,
		        		   true,			//isCompostable
		        		   true,			//isEdible
		        		   true,			//isFedable
		        		   true,			//isThrowable
		        		   true,			//isUsableForOther
		        		   false,			//isGeneratingBone
		        		   false,			//isGeneratingCore
		        		   false,			//isGeneratingCrust
		        		   false,			//isGeneratingFat
		        		   false,			//isGeneratingFilter
		        		   true,			//isGeneratingPeel
		        		   false,			//isGeneratingMeatSkin
		        		   true);			//isGeneratingTail
    }
    
    public Element getElementTomateDechets(String mealType, Date dateCreation, Element tomate){
    	String basicName = "TomateD�chets(Epluchures, Noyau)";
    	
    	return new Element(tomate,
    					   basicName,
    					   this.getIdName(basicName, mealType, dateCreation),
    					   mealType,
    					   0, 			//TODO : Toxicity : to be determined
    					   1,			//quantity
    					   true,		//qtIsQuotient    					   
    					   true,		//isCompostable
    					   false,		//isEdible
    					   true,		//isFedable
    					   true,		//isThrowable
    					   true);		//isUsableForOther
    	
    }
    
    private String getIdName(String basicName, String mealType, Date dateCreation){
    	return new String(dateCreation.toString() +
    					  mealType +
    					  " " +
    					  basicName +
    					  this.id);
    }

}
