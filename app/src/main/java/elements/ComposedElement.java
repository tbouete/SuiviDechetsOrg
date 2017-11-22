package elements;

import java.util.Date;
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
	
	/**
	 * Create a ComposedElement. Will determine most of the settings based on those of the ones composing it.
	 * @param basicName basic name of this ComposedElement, should be specified by user
	 * @param idName name used in the final Excel, please use getIdName() from {@link}}ComposedElementFactory
	 * @param mealType type of the meal this ComposedElement came from
	 * @param dateCreation date of the meal this ComposedElement came from
	 * @param composition list of {@link}Element used to compose this one
	 */
	protected ComposedElement(String basicName,
						      String idName,
						      String mealType,
						      Date dateCreation,
						      List<Element> composition) {
		super(basicName,
			  idName,
			  mealType,
			  dateCreation,
			  setToxicity(composition),
			  setQuantity(),
			  setQtIsQuotient(true),
			  setIsBio(composition),
			  setIsFromOwnGarden(composition),
			  setIsCompostable(composition),
			  setIsEdible(composition),
			  setIsFedable(composition),
			  setIsThrowable(composition),
			  setIsUsableForOther(composition),
			  false,
			  false,
			  false,
			  false,
			  false,
			  false,
			  false,
			  false);
		
		this.composition = composition;
	}
	
	/**
	 * 
	 * @param composition of this ComposedElement
	 * @return the toxicity of this Composed Element
	 */
	private static int setToxicity(List<Element> composition){
		int toxicityRet = 0;
		
		for(Element e : composition) toxicityRet += e.getToxicity();
		
		return toxicityRet;
	}
	
	/**
	 * 
	 * @return the quantity of this Composed Element
	 */
	private static int setQuantity() { return 1; }
	
	private static boolean setQtIsQuotient(boolean isQtQuotient) { return isQtQuotient; }
	
	/**
	 * 
	 * @param composition of this ComposedElement
	 * @return true if this ComposedElement is bio, false otherwise
	 */
	private static boolean setIsBio(List<Element> composition){
		boolean isBioRet = true;
		
		for(Element e : composition){
			isBioRet = Boolean.logicalAnd(isBioRet, e.isBio());
		}
		
		return isBioRet;
	}
	
	/**
	 * 
	 * @param composition of this Composed Element
	 * @return true if this ComposedElement is from the user's garden, false otherwise
	 */
	private static boolean setIsFromOwnGarden(List<Element> composition){
		boolean isFromOwnGarden = true;
		
		for(Element e : composition){
			isFromOwnGarden = Boolean.logicalAnd(isFromOwnGarden, e.isFromOwnGarden());
		}
		
		return isFromOwnGarden;
	}
	
	/**
	 * 
	 * @param composition of this Composed Element
	 * @return true if this ComposedElement is compostable, false otherwise
	 */
	private static boolean setIsCompostable(List<Element> composition){
		boolean isCompostable = true;
		
		for(Element e : composition){
			isCompostable = Boolean.logicalAnd(isCompostable, e.isCompostable());
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
			isEdible = Boolean.logicalAnd(isEdible, e.isEdible());
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
			isFedable = Boolean.logicalAnd(isFedable, e.isFedable());
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
			isThrowable = Boolean.logicalAnd(isThrowable, e.isThrowable());
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
			isUsableForOther = Boolean.logicalAnd(isUsableForOther, e.isUsableForOther());
		}
		
		return isUsableForOther;
	}

	@Override
	public String toString() {
		String tmp = "Je suis composé de : \n";
		for(Element e : this.composition) tmp += e.getQuantity() + " " + e.getBasicName() + "(s) \n";
		
		return super.toString() + tmp;
	}
	
	
}
