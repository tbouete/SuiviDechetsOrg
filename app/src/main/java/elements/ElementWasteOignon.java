package elements;

public class ElementWasteOignon extends ElementWaste {

	protected ElementWasteOignon(Element elem) {
		super(elem);
		this.setBasicName("OignonDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
