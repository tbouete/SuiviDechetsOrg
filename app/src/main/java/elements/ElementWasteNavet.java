package elements;

public class ElementWasteNavet extends ElementWaste {

	protected ElementWasteNavet(Element elem) {
		super(elem);
		this.setBasicName("NavetDechet(Enveloppe, queue)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
