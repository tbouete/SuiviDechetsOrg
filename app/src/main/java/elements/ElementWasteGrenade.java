package elements;

public class ElementWasteGrenade extends ElementWaste {

	protected ElementWasteGrenade(Element elem) {
		super(elem);
		this.setBasicName("GrenadeDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
