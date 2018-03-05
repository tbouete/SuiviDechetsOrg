package elements;

public class ElementWastePorc extends ElementWaste{

	protected ElementWastePorc(Element elem) {
		super(elem);
		this.setBasicName("PorcDechet(Gras, os)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
