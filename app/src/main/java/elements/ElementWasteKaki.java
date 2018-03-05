package elements;

public class ElementWasteKaki extends ElementWaste {

	protected ElementWasteKaki(Element elem) {
		super(elem);
		this.setBasicName("KakiDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
