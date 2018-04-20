package elements;

public class ElementWasteBoeuf extends ElementWaste{

	protected ElementWasteBoeuf(Element elem) {
		super(elem);
		this.setBasicName("BoeufDechet(Gras, os)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
