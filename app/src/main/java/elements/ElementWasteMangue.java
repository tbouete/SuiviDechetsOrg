package elements;

public class ElementWasteMangue extends ElementWaste {

	protected ElementWasteMangue(Element elem) {
		super(elem);
		this.setBasicName("MangueDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
