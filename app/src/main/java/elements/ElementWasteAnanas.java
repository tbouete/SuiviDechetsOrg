package elements;

public class ElementWasteAnanas extends ElementWaste {

	protected ElementWasteAnanas(Element elem) {
		super(elem);
		this.setBasicName("AnanasDechet(Enveloppe, queue)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
