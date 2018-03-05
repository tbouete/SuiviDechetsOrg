package elements;

public class ElementWasteChouFleur extends ElementWaste {

	protected ElementWasteChouFleur(Element elem) {
		super(elem);
		this.setBasicName("Chou-fleurDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
