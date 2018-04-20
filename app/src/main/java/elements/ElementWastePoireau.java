package elements;

public class ElementWastePoireau extends ElementWaste {

	protected ElementWastePoireau(Element elem) {
		super(elem);
		this.setBasicName("PoireauDechet()");
		this.setMinWeightCompost(59);
		this.setMaxWeightCompost(101);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
