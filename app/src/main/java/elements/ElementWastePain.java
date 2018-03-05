package elements;

public class ElementWastePain extends ElementWaste{

	protected ElementWastePain(Element elem) {
		super(elem);
		this.setBasicName("PainDechet()");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
