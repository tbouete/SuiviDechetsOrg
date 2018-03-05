package elements;

public class ElementWasteCreme extends ElementWaste{

	protected ElementWasteCreme(Element elem) {
		super(elem);
		this.setBasicName("CrèmeDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
