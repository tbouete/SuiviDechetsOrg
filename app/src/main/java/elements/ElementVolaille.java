package elements;

public class ElementVolaille extends Element {

	protected ElementVolaille(double quantity, boolean qtIsQuotient, boolean isBio, boolean isFromOwnGarden) {
		super(quantity, qtIsQuotient, isBio, isFromOwnGarden);
		this.setBasicName("Volaille");
		this.setDefaultToxicityValue(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
		
		this.setGeneratingBone(true);
		this.setGeneratingCore(false);
		this.setGeneratingCrust(false);
		this.setGeneratingFat(true);
		this.setGeneratingFilter(false);
		this.setGeneratingMeatSkin(true);
		this.setGeneratingPeel(false);
		this.setGeneratingTail(false);
	}

}
