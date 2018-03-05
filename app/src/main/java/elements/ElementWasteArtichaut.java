package elements;

public class ElementWasteArtichaut extends ElementWaste {

	protected ElementWasteArtichaut(Element elem) {
		super(elem);
		this.setBasicName("ArticahutDechet(Queues)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
