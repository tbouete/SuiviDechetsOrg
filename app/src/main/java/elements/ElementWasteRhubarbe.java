package elements;

public class ElementWasteRhubarbe extends ElementWaste {

	protected ElementWasteRhubarbe(Element elem) {
		super(elem);
		this.setBasicName("RhubarbeDechet(Enveloppe, queue)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
