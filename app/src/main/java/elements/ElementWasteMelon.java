package elements;

public class ElementWasteMelon extends ElementWaste {

	protected ElementWasteMelon(Element elem) {
		super(elem);
		this.setBasicName("MelonDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
