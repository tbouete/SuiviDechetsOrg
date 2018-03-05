package elements;

public class ElementWasteVinaigrette extends ElementWaste{

	protected ElementWasteVinaigrette(Element elem) {
		super(elem);
		this.setBasicName("VinaigretteDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
