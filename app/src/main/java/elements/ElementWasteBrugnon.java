package elements;

public class ElementWasteBrugnon extends ElementWaste {

	protected ElementWasteBrugnon(Element elem) {
		super(elem);
		this.setBasicName("BrugnonDechet(Enveloppe, noyau)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
