package elements;

public class ElementWastePizza extends ElementWaste{

	protected ElementWastePizza(Element elem) {
		super(elem);
		this.setBasicName("PizzaDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
