package elements;

public class ElementWasteAmande extends ElementWaste {

	protected ElementWasteAmande(Element elem) {
		super(elem);
		this.setBasicName("AmandeDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
