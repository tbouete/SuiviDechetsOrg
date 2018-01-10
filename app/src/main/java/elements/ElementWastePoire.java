package elements;

public class ElementWastePoire extends ElementWaste {

	protected ElementWastePoire(Element elem) {
		super(elem);
		this.setBasicName("PoireDechet(Enveloppe, trognon)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
