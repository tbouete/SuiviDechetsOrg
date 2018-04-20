package elements;

public class ElementWasteKiwi extends ElementWaste {

	protected ElementWasteKiwi(Element elem) {
		super(elem);
		this.setBasicName("KiwiDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
