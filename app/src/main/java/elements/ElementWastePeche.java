package elements;

public class ElementWastePeche extends ElementWaste {

	protected ElementWastePeche(Element elem) {
		super(elem);
		this.setBasicName("P�cheDechet(Enveloppe, noyau)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
