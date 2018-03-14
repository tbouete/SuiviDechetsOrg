package elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class StockMeals implements Serializable, Observer{

	private ArrayList<StockElementMeal> ListSEM = new ArrayList<>();
	private String PATH_SERIALIZATION_FILE = "test.srz";
	private ElementFactory elementFactory = new ElementFactory();
	
	@Override
	public void update(Observable o, Object arg) {
		//Serialization
//    	try ( ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.PATH_SERIALIZATION_FILE)) ) {
//    		os.writeObject(this);
//    		System.out.println("S�rialisation de StockMeals r�ussie");
//
//
//		} catch (IOException e) {
//			System.err.println("Erreur pendant la s�rialisation : " + e);
//			System.exit(2);
//		}
		
	}
	
	/**
	 * @return -1 if there is no Element on hold, or the index of the meal this Element comes from.
	 */
	private int getIndexSEMOnHold(){
		int indexSEMOnHold = -1; //Default value if no Element is on hold
		
		for(int i = 0; i < this.ListSEM.size(); i++){
			if(this.ListSEM.get(i).getElementOnHold() != null) indexSEMOnHold = i;
		}
		
		return indexSEMOnHold;
	}
	
	public StockElementMeal getSEMOnHold() throws IndexOutOfBoundsException{
		return this.ListSEM.get(getIndexSEMOnHold());
	}
	
	public ArrayList<StockElementMeal> getListSEM() { return this.ListSEM; }
	
	public ElementFactory getElementFactory(){ return this.elementFactory; }

	@Override
	public String toString() {
		String str = "";
		for(StockElementMeal s : this.ListSEM) {
			for(Element e : s.getListElementComposted()) {
				str += e.getBasicName();
			}
		}
		return str;
	}
}
