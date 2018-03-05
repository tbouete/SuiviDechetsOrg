package elements;

public class ElementWastePasteque extends ElementWaste {

	protected ElementWastePasteque(Element elem) {
		super(elem);
		this.setBasicName("Past�queDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
