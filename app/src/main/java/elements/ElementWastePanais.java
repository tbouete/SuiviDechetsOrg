package elements;

public class ElementWastePanais extends ElementWaste {

	protected ElementWastePanais(Element elem) {
		super(elem);
		this.setBasicName("PanaisDechet(Enveloppe, queue)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
