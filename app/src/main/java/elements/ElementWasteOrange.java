package elements;

public class ElementWasteOrange extends ElementWaste {

	protected ElementWasteOrange(Element elem) {
		super(elem);
		this.setBasicName("OrangeDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
