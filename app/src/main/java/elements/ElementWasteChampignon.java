package elements;

public class ElementWasteChampignon extends ElementWaste {

	protected ElementWasteChampignon(Element elem) {
		super(elem);
		this.setBasicName("ChampignonDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
