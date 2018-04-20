package elements;

public class ElementWasteEpinard extends ElementWaste {

	protected ElementWasteEpinard(Element elem) {
		super(elem);
		this.setBasicName("EpinardDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
