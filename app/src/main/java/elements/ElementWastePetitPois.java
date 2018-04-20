package elements;

public class ElementWastePetitPois extends ElementWaste {

	protected ElementWastePetitPois(Element elem) {
		super(elem);
		this.setBasicName("PetitPoisDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
