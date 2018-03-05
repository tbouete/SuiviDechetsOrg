package elements;

public class ElementWasteMouton extends ElementWaste{

	protected ElementWasteMouton(Element elem) {
		super(elem);
		this.setBasicName("MoutonDechet(Peau, os)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
