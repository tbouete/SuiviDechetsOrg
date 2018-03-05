package elements;

public class ElementWasteCeleriRave extends ElementWaste {

	protected ElementWasteCeleriRave(Element elem) {
		super(elem);
		this.setBasicName("CéleriRaveDechet(Enveloppe, queue)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
