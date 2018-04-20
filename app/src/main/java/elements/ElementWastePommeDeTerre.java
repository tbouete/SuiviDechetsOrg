package elements;

public class ElementWastePommeDeTerre extends ElementWaste {

	protected ElementWastePommeDeTerre(Element elem) {
		super(elem);
		this.setBasicName("PommeDeTerreDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
