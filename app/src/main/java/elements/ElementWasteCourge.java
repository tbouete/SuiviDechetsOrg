package elements;

public class ElementWasteCourge extends ElementWaste {

	protected ElementWasteCourge(Element elem) {
		super(elem);
		this.setBasicName("CourgeDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
