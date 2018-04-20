package elements;

public class ElementWasteYaourt extends ElementWaste{

	protected ElementWasteYaourt(Element elem) {
		super(elem);
		this.setBasicName("YaourtDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
