package elements;

public class ElementWasteOignonNouveau extends ElementWaste {

	protected ElementWasteOignonNouveau(Element elem) {
		super(elem);
		this.setBasicName("OignonNouveauDechet(Enveloppe, queue)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
