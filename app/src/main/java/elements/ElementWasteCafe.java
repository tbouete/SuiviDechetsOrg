package elements;

public class ElementWasteCafe extends ElementWaste{

	protected ElementWasteCafe(Element elem) {
		super(elem);
		this.setBasicName("Caf�Dechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
