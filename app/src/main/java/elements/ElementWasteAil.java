package elements;

public class ElementWasteAil extends ElementWaste {

	protected ElementWasteAil(Element elem) {
		super(elem);
		this.setBasicName("AilDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
