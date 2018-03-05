package elements;

public class ElementWasteHaricot extends ElementWaste {

	protected ElementWasteHaricot(Element elem) {
		super(elem);
		this.setBasicName("HaricotDechet(Queue)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
