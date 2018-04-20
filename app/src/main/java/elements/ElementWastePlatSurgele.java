package elements;

public class ElementWastePlatSurgele extends ElementWaste{

	protected ElementWastePlatSurgele(Element elem) {
		super(elem);
		this.setBasicName("PlatSurgeléDechet()");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
	}

}
