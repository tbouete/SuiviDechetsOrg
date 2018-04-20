package elements;

public class ElementWasteCarotte extends ElementWaste {

	protected ElementWasteCarotte(Element elem) {
		super(elem);
		this.setBasicName("CarotteDechet(Enveloppe, queue)");
		this.setMinWeightCompost(46);
		this.setMaxWeightCompost(48);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
