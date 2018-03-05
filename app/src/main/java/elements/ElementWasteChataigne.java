package elements;

public class ElementWasteChataigne extends ElementWaste {

	protected ElementWasteChataigne(Element elem) {
		super(elem);
		this.setBasicName("ChâtaigneDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
