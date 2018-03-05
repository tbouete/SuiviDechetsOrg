package elements;

public class ElementWasteCitrouille extends ElementWaste {

	protected ElementWasteCitrouille(Element elem) {
		super(elem);
		this.setBasicName("CitrouilleDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
