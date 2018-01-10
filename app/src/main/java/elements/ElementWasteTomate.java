package elements;

public class ElementWasteTomate extends ElementWaste {

	protected ElementWasteTomate(Element elem) {
		super(elem);
		this.setBasicName("TomateDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
