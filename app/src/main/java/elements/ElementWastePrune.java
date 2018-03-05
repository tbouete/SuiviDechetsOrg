package elements;

public class ElementWastePrune extends ElementWaste {

	protected ElementWastePrune(Element elem) {
		super(elem);
		this.setBasicName("PruneDechet(Enveloppe, noyau)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
