package elements;

public class ElementWastePotiron extends ElementWaste {

	protected ElementWastePotiron(Element elem) {
		super(elem);
		this.setBasicName("PotironDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
