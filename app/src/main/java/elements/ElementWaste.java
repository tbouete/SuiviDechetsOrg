package elements;

public abstract class ElementWaste extends Element {

	protected ElementWaste(double quantity, boolean qtIsQuotient, boolean isBio, boolean isFromOwnGarden) {
		super(quantity, qtIsQuotient, isBio, isFromOwnGarden);
		this.setGeneratingBone(false);
		this.setGeneratingCore(false);
		this.setGeneratingCrust(false);
		this.setGeneratingFat(false);
		this.setGeneratingFilter(false);
		this.setGeneratingMeatSkin(false);
		this.setGeneratingPeel(false);
		this.setGeneratingTail(false);
	}
	
	protected ElementWaste(Element elem){
		this(elem.getQuantity(), elem.isQtIsQuotient(), elem.isBio(), elem.isFromOwnGarden());
	}

	
	
}
