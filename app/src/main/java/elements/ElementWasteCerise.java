package elements;

public class ElementWasteCerise extends ElementWaste {

	protected ElementWasteCerise(Element elem) {
		super(elem);
		this.setBasicName("CeriseDechet(Queue, noyau)");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
