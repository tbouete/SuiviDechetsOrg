package elements;

public class ElementBanane extends Element {

	protected ElementBanane(double quantity, boolean qtIsQuotient, boolean isBio, boolean isFromOwnGarden) {
		super(quantity, qtIsQuotient, isBio, isFromOwnGarden);
		this.setBasicName("Banane");
		this.setMinWeightCompost(0);
		
		this.setCompostable(true);
		this.setEdible(true);
		this.setFedable(true);
		this.setThrowable(true);
		this.setUsableForOther(true);
		
		this.setGeneratingBone(false);
		this.setGeneratingCore(false);
		this.setGeneratingCrust(false);
		this.setGeneratingFat(false);
		this.setGeneratingFilter(false);
		this.setGeneratingMeatSkin(false);
		this.setGeneratingPeel(true);
		this.setGeneratingTail(false);
	}

}
