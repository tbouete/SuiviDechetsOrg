package elements;

public class ElementWastePoire extends ElementWaste {

	protected ElementWastePoire(Element elem) {
		super(elem);
		this.setBasicName("PoireDechet(Enveloppe, trognon)");
		this.setMinWeightCompost(28);
		this.setMaxWeightCompost(35);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
