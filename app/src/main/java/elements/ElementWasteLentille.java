package elements;

public class ElementWasteLentille extends ElementWaste{

	protected ElementWasteLentille(Element elem) {
		super(elem);
		this.setBasicName("LentilleDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
