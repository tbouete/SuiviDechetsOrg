package elements;

public class ElementWasteNoixDeCoco extends ElementWaste {

	protected ElementWasteNoixDeCoco(Element elem) {
		super(elem);
		this.setBasicName("NoixDeCocoDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
