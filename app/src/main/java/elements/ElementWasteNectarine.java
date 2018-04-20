package elements;

public class ElementWasteNectarine extends ElementWaste {

	protected ElementWasteNectarine(Element elem) {
		super(elem);
		this.setBasicName("NectarineDechet(Enveloppe, noyau)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
