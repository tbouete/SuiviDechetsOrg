package elements;

public class ElementWastePommeDeTerre extends ElementWaste {

	protected ElementWastePommeDeTerre(Element elem) {
		super(elem);
		this.setBasicName("PommeDeTerreDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
