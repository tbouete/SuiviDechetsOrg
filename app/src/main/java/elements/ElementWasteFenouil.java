package elements;

public class ElementWasteFenouil extends ElementWaste {

	protected ElementWasteFenouil(Element elem) {
		super(elem);
		this.setBasicName("FenouilDechet(Enveloppe, queue)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
