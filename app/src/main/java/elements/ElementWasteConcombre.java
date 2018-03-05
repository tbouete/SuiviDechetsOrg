package elements;

public class ElementWasteConcombre extends ElementWaste {

	protected ElementWasteConcombre(Element elem) {
		super(elem);
		this.setBasicName("ConcombreDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
