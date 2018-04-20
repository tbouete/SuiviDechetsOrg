package elements;

public class ElementWastePomme extends ElementWaste {

	protected ElementWastePomme(Element elem) {
		super(elem);
		this.setBasicName("PommeDechet(Enveloppe, trognon)");
		this.setMinWeightCompost(23);
		this.setMaxWeightCompost(25);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
