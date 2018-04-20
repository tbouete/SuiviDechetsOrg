package elements;

public class ElementWastePoisAEcosser extends ElementWaste {

	protected ElementWastePoisAEcosser(Element elem) {
		super(elem);
		this.setBasicName("PoidAEcosserDechet(Enveloppe)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
