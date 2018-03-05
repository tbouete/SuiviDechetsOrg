package elements;

public class ElementWasteRiz extends ElementWaste{

	protected ElementWasteRiz(Element elem) {
		super(elem);
		this.setBasicName("RizDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
