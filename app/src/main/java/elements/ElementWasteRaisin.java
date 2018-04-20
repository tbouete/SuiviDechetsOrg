package elements;

public class ElementWasteRaisin extends ElementWaste {

	protected ElementWasteRaisin(Element elem) {
		super(elem);
		this.setBasicName("RaisinDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
