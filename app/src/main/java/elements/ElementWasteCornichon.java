package elements;

public class ElementWasteCornichon extends ElementWaste {

	protected ElementWasteCornichon(Element elem) {
		super(elem);
		this.setBasicName("CornichonDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
