package elements;

public class ElementWastePommeDeTerre extends ElementWaste {

	protected ElementWastePommeDeTerre(Element elem) {
		super(elem);
		this.setBasicName("PommeDeTerreDechet(Enveloppe)");
		this.setMinWeightCompost(10);
		this.setMaxWeightCompost(33);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
