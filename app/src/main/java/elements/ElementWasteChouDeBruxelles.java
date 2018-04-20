package elements;

public class ElementWasteChouDeBruxelles extends ElementWaste {

	protected ElementWasteChouDeBruxelles(Element elem) {
		super(elem);
		this.setBasicName("ChouDeBruxellesDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
