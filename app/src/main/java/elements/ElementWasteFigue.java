package elements;

public class ElementWasteFigue extends ElementWaste {

	protected ElementWasteFigue(Element elem) {
		super(elem);
		this.setBasicName("FigueDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
