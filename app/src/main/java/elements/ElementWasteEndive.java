package elements;

public class ElementWasteEndive extends ElementWaste {

	protected ElementWasteEndive(Element elem) {
		super(elem);
		this.setBasicName("EndiveDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
