package elements;

public class ElementWastePate extends ElementWaste{

	protected ElementWastePate(Element elem) {
		super(elem);
		this.setBasicName("PâteDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
