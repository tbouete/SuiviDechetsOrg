package elements;

public class ElementWasteBlette extends ElementWaste {

	protected ElementWasteBlette(Element elem) {
		super(elem);
		this.setBasicName("BletteDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
