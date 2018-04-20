package elements;

public class ElementWasteConcombre extends ElementWaste {

	protected ElementWasteConcombre(Element elem) {
		super(elem);
		this.setBasicName("ConcombreDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
