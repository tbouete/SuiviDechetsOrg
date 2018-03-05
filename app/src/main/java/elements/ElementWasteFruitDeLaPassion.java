package elements;

public class ElementWasteFruitDeLaPassion extends ElementWaste {

	protected ElementWasteFruitDeLaPassion(Element elem) {
		super(elem);
		this.setBasicName("FruitDeLaPassionDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
