package elements;

public class ElementWasteBetteraveRouge extends ElementWaste {

	protected ElementWasteBetteraveRouge(Element elem) {
		super(elem);
		this.setBasicName("BetteraveRougeDechet(Enveloppe, queue)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
