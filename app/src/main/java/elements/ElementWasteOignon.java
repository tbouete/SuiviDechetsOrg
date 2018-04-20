package elements;

public class ElementWasteOignon extends ElementWaste {

	protected ElementWasteOignon(Element elem) {
		super(elem);
		this.setBasicName("OignonDechet(Enveloppe)");
		this.setMinWeightCompost(11);
		this.setMinWeightCompost(12);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
