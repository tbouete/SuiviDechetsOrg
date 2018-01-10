package elements;

public class ElementWasteAbricot extends ElementWaste {

	protected ElementWasteAbricot(Element elem) {
		super(elem);
		this.setBasicName("AbricotDechet(Enveloppe, noyau)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
