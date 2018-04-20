package elements;

public class ElementWasteCoing extends ElementWaste {

	protected ElementWasteCoing(Element elem) {
		super(elem);
		this.setBasicName("CoingDechet(Enveloppe, trognon)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
