package elements;

public class ElementWasteAubergine extends ElementWaste {

	protected ElementWasteAubergine(Element elem) {
		super(elem);
		this.setBasicName("AuberginetDechet(Enveloppe, queue)");
		this.setMinWeightCompost(44);
		this.setMaxWeightCompost(71);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
