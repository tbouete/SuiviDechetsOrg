package elements;

public class ElementWasteBanane extends ElementWaste {

	protected ElementWasteBanane(Element elem) {
		super(elem);
		this.setBasicName("BananeDechet(Enveloppe)");
		this.setMinWeightCompost(76);
		this.setMaxWeightCompost(76);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
