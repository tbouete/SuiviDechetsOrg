package elements;

public class ElementWasteKetchup extends ElementWaste{

	protected ElementWasteKetchup(Element elem) {
		super(elem);
		this.setBasicName("KetchupDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
