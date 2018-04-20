package elements;

public class ElementWasteCourgette extends ElementWaste {

	protected ElementWasteCourgette(Element elem) {
		super(elem);
		this.setBasicName("CourgetteDechet(Enveloppe, queue)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
