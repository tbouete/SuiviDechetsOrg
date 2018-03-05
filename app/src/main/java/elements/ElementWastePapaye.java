package elements;

public class ElementWastePapaye extends ElementWaste {

	protected ElementWastePapaye(Element elem) {
		super(elem);
		this.setBasicName("PapayeDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
