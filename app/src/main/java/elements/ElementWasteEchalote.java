package elements;

public class ElementWasteEchalote extends ElementWaste {

	protected ElementWasteEchalote(Element elem) {
		super(elem);
		this.setBasicName("EchaloteDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
