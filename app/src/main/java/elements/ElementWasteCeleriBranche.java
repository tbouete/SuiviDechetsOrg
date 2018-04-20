package elements;

public class ElementWasteCeleriBranche extends ElementWaste {

	protected ElementWasteCeleriBranche(Element elem) {
		super(elem);
		this.setBasicName("CeleriBrancheDechet(Queue)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
