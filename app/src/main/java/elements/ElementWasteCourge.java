package elements;

public class ElementWasteCourge extends ElementWaste {

	protected ElementWasteCourge(Element elem) {
		super(elem);
		this.setBasicName("CourgeDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
