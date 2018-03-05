package elements;

public class ElementWasteAsperge extends ElementWaste {

	protected ElementWasteAsperge(Element elem) {
		super(elem);
		this.setBasicName("AspergeDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
