package elements;

public class ElementWasteAvocat extends ElementWaste {

	protected ElementWasteAvocat(Element elem) {
		super(elem);
		this.setBasicName("AvocatDechet(Enveloppe, noyau)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
