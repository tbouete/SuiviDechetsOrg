package elements;

public class ElementWastePoisson extends ElementWaste{

	protected ElementWastePoisson(Element elem) {
		super(elem);
		this.setBasicName("PoissonDechet(Peau, os)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
