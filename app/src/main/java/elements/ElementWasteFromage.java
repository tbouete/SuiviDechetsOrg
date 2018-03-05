package elements;

public class ElementWasteFromage extends ElementWaste{

	protected ElementWasteFromage(Element elem) {
		super(elem);
		this.setBasicName("FromageDechet(Croûte)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
