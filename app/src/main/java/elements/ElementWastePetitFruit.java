package elements;

public class ElementWastePetitFruit extends ElementWaste {

	protected ElementWastePetitFruit(Element elem) {
		super(elem);
		this.setBasicName("PetitFruitDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
