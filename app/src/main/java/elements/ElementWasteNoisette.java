package elements;

public class ElementWasteNoisette extends ElementWaste {

	protected ElementWasteNoisette(Element elem) {
		super(elem);
		this.setBasicName("NoisetteDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
