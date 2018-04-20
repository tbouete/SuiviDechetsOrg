package elements;

public class ElementWasteFraise extends ElementWaste {

	protected ElementWasteFraise(Element elem) {
		super(elem);
		this.setBasicName("FraiseDechet(Queue)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
