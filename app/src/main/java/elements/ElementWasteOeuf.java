package elements;

public class ElementWasteOeuf extends ElementWaste{

	protected ElementWasteOeuf(Element elem) {
		super(elem);
		this.setBasicName("OeufDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
