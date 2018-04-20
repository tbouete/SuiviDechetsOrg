package elements;

public class ElementWastePasteque extends ElementWaste {

	protected ElementWastePasteque(Element elem) {
		super(elem);
		this.setBasicName("PastèqueDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
