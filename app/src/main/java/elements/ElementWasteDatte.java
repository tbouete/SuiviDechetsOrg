package elements;

public class ElementWasteDatte extends ElementWaste {

	protected ElementWasteDatte(Element elem) {
		super(elem);
		this.setBasicName("DatteDechet(Noyau)");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
