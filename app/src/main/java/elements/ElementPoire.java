package elements;

public class ElementPoire extends Element {

	protected ElementPoire(double quantity, boolean qtIsQuotient, boolean isBio, boolean isFromOwnGarden) {
		super(quantity, qtIsQuotient, isBio, isFromOwnGarden);
		this.setBasicName("Poire");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
		
		this.setGeneratingBone(false);
		this.setGeneratingCore(true);
		this.setGeneratingCrust(false);
		this.setGeneratingFat(false);
		this.setGeneratingFilter(false);
		this.setGeneratingMeatSkin(false);
		this.setGeneratingPeel(true);
		this.setGeneratingTail(false);
	}

}
