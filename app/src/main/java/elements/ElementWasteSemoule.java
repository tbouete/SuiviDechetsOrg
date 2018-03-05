package elements;

public class ElementWasteSemoule extends ElementWaste{

	protected ElementWasteSemoule(Element elem) {
		super(elem);
		this.setBasicName("SemouleDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
