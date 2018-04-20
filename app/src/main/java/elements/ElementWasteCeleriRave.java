package elements;

public class ElementWasteCeleriRave extends ElementWaste {

	protected ElementWasteCeleriRave(Element elem) {
		super(elem);
		this.setBasicName("C�leriRaveDechet(Enveloppe, queue)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
