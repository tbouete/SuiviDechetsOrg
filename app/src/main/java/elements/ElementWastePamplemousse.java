package elements;

public class ElementWastePamplemousse extends ElementWaste{

	protected ElementWastePamplemousse(Element elem) {
		super(elem);
		this.setBasicName("PamplemousseDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
