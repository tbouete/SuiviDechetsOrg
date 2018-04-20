package elements;

public class ElementWasteThe extends ElementWaste{

	protected ElementWasteThe(Element elem) {
		super(elem);
		this.setBasicName("Th�Dechet(Filtre)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
