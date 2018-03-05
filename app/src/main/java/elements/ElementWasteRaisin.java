package elements;

public class ElementWasteRaisin extends ElementWaste {

	protected ElementWasteRaisin(Element elem) {
		super(elem);
		this.setBasicName("RaisinDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
