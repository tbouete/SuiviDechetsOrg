package elements;

import java.util.List;

/**
 * 
 * @author Titouan
 *
 * This class represent a complex meal using several other aliments.
 * While it does retain the same properties as regular {@link}Element, those will be determined
 * based on those of the ones composing it.
 */

public class ComposedElement extends Element {
	
	private List<Element> composition;
	
	public ComposedElement(String basicName,
							  double quantity,
							  boolean qtIsQuotient,
							  boolean isBio,
							  boolean isFromOwnGarden,
							  List<Element> composition) {
		super(quantity, qtIsQuotient, isBio, isFromOwnGarden);
		this.composition = composition;
		
		this.setBasicName(basicName);
		this.setDefaultToxicityValue(setDefaultToxicityValue(composition));
		
		this.setCompostable(setIsCompostable(composition));
		this.setEdible(setIsEdible(composition));
		this.setFedable(setIsFedable(composition));
		this.setThrowable(setIsThrowable(composition));
		this.setUsableForOther(setIsUsableForOther(composition));
		
		this.setGeneratingBone(false);
		this.setGeneratingCore(false);
		this.setGeneratingCrust(false);
		this.setGeneratingFat(false);
		this.setGeneratingFilter(false);
		this.setGeneratingMeatSkin(false);
		this.setGeneratingPeel(false);
		this.setGeneratingTail(false);
	}
	

	
	
	
	
	/**
	 * 
	 * @param composition of this ComposedElement
	 * @return the toxicity of this Composed Element
	 */
	private static int setDefaultToxicityValue(List<Element> composition){
		int toxicityRet = 0;
		
		for(Element e : composition) toxicityRet += e.getToxicityValue();
		
		return toxicityRet;
	}
	
	
	/**
	 * 
	 * @param composition of this Composed Element
	 * @return true if this ComposedElement is compostable, false otherwise
	 */
	private static boolean setIsCompostable(List<Element> composition){
		boolean isCompostable = true;
		
		for(Element e : composition){
			isCompostable = isCompostable && e.isCompostable();
		}
		
		return isCompostable;
	}
	
	/**
	 * 
	 * @param composition of this Composed Element
	 * @return true if this ComposedElement is edible, false otherwise
	 */
	private static boolean setIsEdible(List<Element> composition){
		boolean isEdible = true;
		
		for(Element e : composition){
			isEdible = isEdible && e.isEdible();
		}
		
		return isEdible;
	}
	
	/**
	 * 
	 * @param composition of this Composed Element
	 * @return true if this ComposedElement is fedable, false otherwise
	 */
	private static boolean setIsFedable(List<Element> composition){
		boolean isFedable = true;
		
		for(Element e : composition){
			isFedable = isFedable && e.isFedable();
		}
		
		return isFedable;
	}
	
	/**
	 * 
	 * @param composition of this Composed Element
	 * @return true if this ComposedElement is throwable, false otherwise
	 */
	private static boolean setIsThrowable(List<Element> composition){
		boolean isThrowable = true;
		
		for(Element e : composition){
			isThrowable = isThrowable && e.isThrowable();
		}
		
		return isThrowable;
	}
	
	/**
	 * 
	 * @param composition of this Composed Element
	 * @return true if this ComposedElement is usable for other usages, false otherwise
	 */
	private static boolean setIsUsableForOther(List<Element> composition){
		boolean isUsableForOther = true;
		
		for(Element e : composition){
			isUsableForOther = isUsableForOther && e.isUsableForOther();
		}
		
		return isUsableForOther;
	}

	@Override
	public String toString() {
		String tmp = "Je suis compos� de : \n";
		for(Element e : this.composition) tmp += e.getQuantity() + " " + e.getBasicName() + "(s) \n";
		
		return super.toString() + tmp;
	}

	public List<Element> getComposition() {
		return composition;
	}

	public void setComposition(List<Element> composition) {
		this.composition = composition;
	}
}
