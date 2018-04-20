package elements;

public class ElementWasteChataigne extends ElementWaste {

	protected ElementWasteChataigne(Element elem) {
		super(elem);
		this.setBasicName("Ch�taigneDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
