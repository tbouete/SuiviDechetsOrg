package elements;

public class ElementWasteSalsifis extends ElementWaste {

	protected ElementWasteSalsifis(Element elem) {
		super(elem);
		this.setBasicName("SalsifisDechet(Enveloppe, queue)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
