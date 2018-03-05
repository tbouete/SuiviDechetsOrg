package elements;

public class ElementWasteClementine extends ElementWaste{

	protected ElementWasteClementine(Element elem) {
		super(elem);
		this.setBasicName("ClementineDechet(Enveloppe)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
