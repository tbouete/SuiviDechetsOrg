package elements;

import java.util.Date;
import java.util.List;

public class ComposedElementFactory {
	private int id = 1;
	
	public ComposedElement getComposedElement(String basicName, String mealType, Date dateCreation, List<Element> composition){
		
		this.id++;
		
		return new ComposedElement(basicName,
								   this.getIdName(basicName, mealType, dateCreation, composition),
								   mealType,
								   dateCreation,
								   composition);
	}
	
	private String getIdName(String basicName, String mealType, Date dateCreation, List<Element> composition){
		
		String compositionString = "( ";
		for(Element e : composition){
			compositionString += e.getBasicName() + ", ";
		}
		compositionString += " )";
		
		if(compositionString.equals("(,  )")) compositionString = "";
		
		return new String(dateCreation.toString() +
						  mealType +
						  " " +
				          basicName + 
				          this.id + 
				          compositionString);
	}
}
