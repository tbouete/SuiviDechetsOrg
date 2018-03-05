package elements;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * Created by Titouan on 15/11/2017.
 */

public class ElementFactory implements Serializable{
	
	private int id = 0;
	
	public Element getCustomElement(String basicNameElement,
									double quantity,
									boolean qtIsQuotient,
									boolean isBio,
									boolean isFromOwnGarden)
									throws NoSuchElementException{
		Element tmp;
		switch(basicNameElement){
			case("Abricot")				: tmp = new ElementAbricot			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Ail")					: tmp = new ElementAil				(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Amande")				: tmp = new ElementAmande			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Ananas")				: tmp = new ElementAnanas			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Artichaut")			: tmp = new ElementArtichaut		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Asperge")				: tmp = new ElementAsperge			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Aubergine")			: tmp = new ElementAubergine		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Avocat")				: tmp = new ElementAvocat			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Banane")				: tmp = new ElementBanane			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Betterave rouge")		: tmp = new ElementBetteraveRouge	(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Blette")				: tmp = new ElementBlette			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Boeuf")				: tmp = new ElementBoeuf			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Brocoli")				: tmp = new ElementBrocoli			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Brugnon")				: tmp = new ElementBrugnon			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Café")				: tmp = new ElementCafe				(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Carotte")				: tmp = new ElementCarotte			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Celeri branche")		: tmp = new ElementCeleriBranche   	(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Celeri rave")			: tmp = new ElementCeleriRave		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Cerise")				: tmp = new ElementCerise			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Champignon")			: tmp = new ElementChampignon		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Châtaigne")			: tmp = new ElementChataigne		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Chou de Bruxelles")	: tmp = new ElementChouDeBruxelles 	(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Chou fleur")			: tmp = new ElementChouFleur		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Chou vert")			: tmp = new ElementChouVert			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Citron")				: tmp = new ElementCitron			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Citrouille")			: tmp = new ElementCitrouille		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Clémentine")			: tmp = new ElementClementine		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Coing")				: tmp = new ElementCoing			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Concombre")			: tmp = new ElementConcombre		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Cornichon")			: tmp = new ElementCornichon 		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Courge")				: tmp = new ElementCourge			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Courgette")			: tmp = new ElementCourgette		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Crème")				: tmp = new ElementCreme			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Datte")				: tmp = new ElementDatte			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Echalote")			: tmp = new ElementEchalote			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Endive")				: tmp = new ElementEndive			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Epinard")				: tmp = new ElementEpinard			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Fenouil")				: tmp = new ElementFenouil			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Figue")				: tmp = new ElementFigue			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Fraise")				: tmp = new ElementFraise			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Fromage")				: tmp = new ElementFromage			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Fruit de la passion") : tmp = new ElementFruitDeLaPassion	(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Gâteau")				: tmp = new ElementGateau			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Grenade")				: tmp = new ElementGrenade			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Haricot")				: tmp = new ElementHaricot			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Kaki")				: tmp = new ElementKaki				(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Ketchup")				: tmp = new ElementKetchup			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Kiwi")				: tmp = new ElementKiwi				(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Lait")				: tmp = new ElementLait				(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Lentilles")			: tmp = new ElementLentille			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Litchi")				: tmp = new ElementLitchi			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Mandarine")			: tmp = new ElementMandarine		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Mangue")				: tmp = new ElementMangue			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Mayonnaise")			: tmp = new ElementMayonnaise		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Melon")				: tmp = new ElementMelon			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Moutarde")			: tmp = new ElementMoutarde			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Mouton")				: tmp = new ElementMouton			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Navet")				: tmp = new ElementNavet			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Nectarine")			: tmp = new ElementNectarine		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Noisette")			: tmp = new ElementNoisette			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Noix")				: tmp = new ElementNoix				(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Noix de coco")		: tmp = new ElementNoixDeCoco		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Oeuf")				: tmp = new ElementOeuf				(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Oignon")				: tmp = new ElementOignon			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Oignon nouveau")		: tmp = new ElementOignonNouveau	(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Orange")				: tmp = new ElementOrange			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Pain")				: tmp = new ElementPain				(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Pamplemousse")		: tmp = new ElementPamplemousse		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Panais")				: tmp = new ElementPanais			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Papaye")				: tmp = new ElementPapaye			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Pastèque")			: tmp = new ElementPasteque			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Patate douce")		: tmp = new ElementPatateDouce		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Pâte")				: tmp = new ElementPate				(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Pêche")				: tmp = new ElementPeche			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Petits fruits (cassis, groseille, framboise, mure, myrtille...)")			: tmp = new ElementPetitFruit		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Petit pois")			: tmp = new ElementPetitPois		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Pizza")				: tmp = new ElementPizza			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Plat préparé")		: tmp = new ElementPlatPrepare		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Plat surgelé")		: tmp = new ElementPlatSurgele		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Poire")				: tmp = new ElementPoire			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Poireau")				: tmp = new ElementPoireau			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Pois à écosser")		: tmp = new ElementPoisAEcosser		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Poisson")				: tmp = new ElementPoisson			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Poivron")				: tmp = new ElementPoivron			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Pomme")				: tmp = new ElementPomme			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break; 
			case("Pomme de terre")		: tmp = new ElementPommeDeTerre		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Porc")				: tmp = new ElementPorc				(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Potiron")				: tmp = new ElementPotiron			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Prune")				: tmp = new ElementPrune			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Raisin")				: tmp = new ElementRaisin			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Rhubarbe")			: tmp = new ElementRhubarbe			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Riz")					: tmp = new ElementRiz				(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Salade entière")		: tmp = new ElementSalade			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Salade en sachet")	: tmp = new ElementSalade			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Salsifis")			: tmp = new ElementSalsifis			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Sauce tomate")		: tmp = new ElementSauceTomate		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Semoule")				: tmp = new ElementSemoule			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Thé")					: tmp = new ElementThe				(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Tomate")				: tmp = new ElementTomate			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Vinaigrette")			: tmp = new ElementVinaigrette		(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Volaille")			: tmp = new ElementVolaille			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			case("Yaourt")				: tmp = new ElementYaourt			(quantity, qtIsQuotient, isBio, isFromOwnGarden); break;
			default: throw new NoSuchElementException();
		}
		this.id++;
		tmp.setId(this.id);
		return tmp;
	}
}
