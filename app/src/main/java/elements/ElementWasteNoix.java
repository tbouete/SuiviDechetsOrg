package elements;

public class ElementWasteNoix extends ElementWaste {

	protected ElementWasteNoix(Element elem) {
		super(elem);
		this.setBasicName("NoixDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
