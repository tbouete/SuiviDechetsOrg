package elements;

public class ElementWasteVolaille extends ElementWaste{

	protected ElementWasteVolaille(Element elem) {
		super(elem);
		this.setBasicName("VolailleDechet(Peau, gras, os)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
