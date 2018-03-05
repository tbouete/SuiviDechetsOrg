package elements;

public class ElementWasteAubergine extends ElementWaste {

	protected ElementWasteAubergine(Element elem) {
		super(elem);
		this.setBasicName("AuberginetDechet(Enveloppe, queue)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
