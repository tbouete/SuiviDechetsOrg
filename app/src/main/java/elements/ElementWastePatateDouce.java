package elements;

public class ElementWastePatateDouce extends ElementWaste {

	protected ElementWastePatateDouce(Element elem) {
		super(elem);
		this.setBasicName("PatateDouceDechet(Enveloppe, queue)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
