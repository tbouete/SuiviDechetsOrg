package elements;

public class ElementWasteThe extends ElementWaste{

	protected ElementWasteThe(Element elem) {
		super(elem);
		this.setBasicName("ThéDechet(Filtre)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
