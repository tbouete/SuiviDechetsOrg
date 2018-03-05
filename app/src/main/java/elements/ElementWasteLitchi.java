package elements;

public class ElementWasteLitchi extends ElementWaste {

	protected ElementWasteLitchi(Element elem) {
		super(elem);
		this.setBasicName("LitchiDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
