package elements;

public class ElementWasteMoutarde extends ElementWaste{

	protected ElementWasteMoutarde(Element elem) {
		super(elem);
		this.setBasicName("MoutardeDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
