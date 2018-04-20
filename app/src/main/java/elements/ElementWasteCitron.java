package elements;

public class ElementWasteCitron extends ElementWaste{

	protected ElementWasteCitron(Element elem) {
		super(elem);
		this.setBasicName("CitronDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
