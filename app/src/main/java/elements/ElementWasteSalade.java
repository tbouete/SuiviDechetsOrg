package elements;

public class ElementWasteSalade extends ElementWaste {

	protected ElementWasteSalade(Element elem) {
		super(elem);
		this.setBasicName("SaladeDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
