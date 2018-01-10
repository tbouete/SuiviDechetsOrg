package elements;

import java.util.NoSuchElementException;

/**
 * Created by Titouan on 15/11/2017.
 */

public class ElementFactory {
	
	private int id = 1;
	
	public Element getCustomElement(String basicNameElement,
									double quantity,
									boolean qtIsQuotient,
									boolean isBio,
									boolean isFromOwnGarden)
									throws NoSuchElementException{
		Element tmp;
		switch(basicNameElement){
			case("Abricot")	  : tmp = new ElementAbricot   (quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Avocat")	  : tmp = new ElementAvocat	   (quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Banane")	  : tmp = new ElementBanane	   (quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Citron")	  : tmp = new ElementCitron	   (quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Clementine"): tmp = new ElementClementine(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Fraise")	  : tmp = new ElementFraise	   (quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Orange")	  : tmp = new ElementOrange	   (quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Peche")	  : tmp = new ElementPeche	   (quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Poire")	  : tmp = new ElementPoire	   (quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Pomme")	  : tmp = new ElementPomme	   (quantity, qtIsQuotient, isBio, isFromOwnGarden); break; 
			case("Tomate")	  : tmp = new ElementTomate	   (quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			default: throw new NoSuchElementException();
		}
		tmp.setId(this.id);
		return tmp;
	}
}
