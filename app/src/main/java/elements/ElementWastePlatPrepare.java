package elements;

public class ElementWastePlatPrepare extends ElementWaste{

	protected ElementWastePlatPrepare(Element elem) {
		super(elem);
		this.setBasicName("PlatPr�par�Dechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
