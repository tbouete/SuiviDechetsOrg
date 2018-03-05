package elements;

public class ElementWasteMayonnaise extends ElementWaste{

	protected ElementWasteMayonnaise(Element elem) {
		super(elem);
		this.setBasicName("MayonnaiseDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
