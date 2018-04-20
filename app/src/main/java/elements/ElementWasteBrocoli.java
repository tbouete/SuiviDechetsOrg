package elements;

public class ElementWasteBrocoli extends ElementWaste {

	protected ElementWasteBrocoli(Element elem) {
		super(elem);
		this.setBasicName("BrocoliDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
