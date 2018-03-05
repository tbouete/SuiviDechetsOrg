package elements;

public class ElementWasteGateau extends ElementWaste{

	protected ElementWasteGateau(Element elem) {
		super(elem);
		this.setBasicName("G�teauDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
