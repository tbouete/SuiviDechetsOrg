package elements;

public class ElementWasteChouVert extends ElementWaste {

	protected ElementWasteChouVert(Element elem) {
		super(elem);
		this.setBasicName("ChouVertDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
