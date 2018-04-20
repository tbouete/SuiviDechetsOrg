package elements;

public class ElementWastePoivron extends ElementWaste {

	protected ElementWastePoivron(Element elem) {
		super(elem);
		this.setBasicName("PoivronDechet(Queue)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
