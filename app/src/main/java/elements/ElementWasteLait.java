package elements;

public class ElementWasteLait extends ElementWaste{

	protected ElementWasteLait(Element elem) {
		super(elem);
		this.setBasicName("LaitDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
