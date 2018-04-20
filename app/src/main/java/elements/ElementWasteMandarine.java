package elements;

public class ElementWasteMandarine extends ElementWaste{

	protected ElementWasteMandarine(Element elem) {
		super(elem);
		this.setBasicName("MandarineDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
