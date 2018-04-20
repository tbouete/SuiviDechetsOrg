package elements;

public class ElementWasteMangue extends ElementWaste {

	protected ElementWasteMangue(Element elem) {
		super(elem);
		this.setBasicName("MangueDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
