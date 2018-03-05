package elements;

public class ElementWasteSauceTomate extends ElementWaste{

	protected ElementWasteSauceTomate(Element elem) {
		super(elem);
		this.setBasicName("SauceTomateDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
