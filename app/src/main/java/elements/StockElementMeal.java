package elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Observable;
import java.util.Observer;

public class StockElementMeal extends Observable implements Serializable{


	private String mealType; 	//Type of meal, should use an item of MealType
	private Date dayMeal;		//Day the meal took place
	
	private boolean isOnHold;
	private Element elementOnHold = null;
	private ArrayList<Observer> listObserver = new ArrayList<>();
	
    private ArrayList<Element> listElementComposted   = new ArrayList<>();
    private ArrayList<Element> listElementEaten       = new ArrayList<>();
    private ArrayList<Element> listElementFed         = new ArrayList<>();
    private ArrayList<Element> listElementStocked     = new ArrayList<>();
    private ArrayList<Element> listElementThrowed     = new ArrayList<>();
    private ArrayList<Element> listElementOtherUsages = new ArrayList<>();
    
    public StockElementMeal(String mealType, Date dayMeal){
    	this.mealType = mealType;
    	this.dayMeal = dayMeal;
    	this.isOnHold = true;
    }
    
    @Override
	public synchronized void addObserver(Observer o) { this.listObserver.add(o); }

	@Override
	public synchronized int countObservers() { return this.listObserver.size(); }

	@Override
	public synchronized void deleteObserver(Observer o) { this.listObserver.remove(o); }
	
	@Override
	public synchronized void deleteObservers() { this.listObserver.clear(); }
	
	@Override
	public void notifyObservers() { for(Observer o : this.listObserver) o.update(this, 0);	}
	
	/* Used in the final Excel file.
	   Format : '(dateCreation.toString) (basicName)(id.toString)'
	   Ex : '01/01/2017 Apple2'
	*/
	public String getIdNameElement(Element elem){
		return this.dayMeal.toString() + this.mealType + " " + elem.getBasicName() + elem.getId();
	}

	public void addToComposted(Element e) { this.listElementComposted.add(e); 	notifyObservers(); }
	
	public void addToEaten    (Element e) { this.listElementEaten.add(e); 		notifyObservers(); }
	
	public void addToFed	  (Element e) { this.listElementFed.add(e); 		notifyObservers(); }
	
	public void addToStocked  (Element e) { this.listElementStocked.add(e); 	notifyObservers(); }
	
	public void addToThrowed  (Element e) { this.listElementThrowed.add(e); 	notifyObservers(); }
	
	public void addToOther    (Element e) { this.listElementOtherUsages.add(e); notifyObservers(); }
	
	/**
     * Take an Element from the stock and throw it to the compost
     * @param e the Element to be thrown to the compost
     * @throws NoSuchElementException if the Element is not in the stock
     */
    public void CompostFromStock(Element e) throws NoSuchElementException{
        if (this.listElementStocked.contains(e)){
            listElementStocked.remove(listElementStocked.indexOf(e));
            listElementComposted.add(e);
        }
        else throw new NoSuchElementException();
    }

    /**
     * Take an Element from the stock and eat it
     * @param e the Element to be eaten
     * @throws NoSuchElementException if the Element is not in the stock
     */
    public void EatFromStock(Element e) throws NoSuchElementException{
        if (this.listElementStocked.contains(e)){
            listElementStocked.remove(listElementStocked.indexOf(e));
            listElementEaten.add(e);
        }
        else throw new NoSuchElementException();
    }

    /**
     * Take an Element from the stock and feed it to animals
     * @param e the Element to be fed
     * @throws NoSuchElementException if the Element is not in the stock
     */
    public void FeedFromStock(Element e) throws NoSuchElementException{
        if (this.listElementStocked.contains(e)){
            listElementStocked.remove(listElementStocked.indexOf(e));
            listElementFed.add(e);
        }
        else throw new NoSuchElementException();
    }

    /**
     * Take an Element from the stock and throw it away
     * @param e the Element to be thrown away
     * @throws NoSuchElementException if the Element is not in the stock
     */
    public void ThrowFromStock(Element e) throws NoSuchElementException{
        if (this.listElementStocked.contains(e)){
            listElementStocked.remove(listElementStocked.indexOf(e));
            listElementThrowed.add(e);
        }
        else throw new NoSuchElementException();
    }

    /**
     * Take an Element from the stock and it to the external usage list
     * @param e the Element to be used
     * @throws NoSuchElementException if the Element is not in the stock
     */
    public void UseFromStock(Element e) throws NoSuchElementException{
        if (this.listElementStocked.contains(e)){
            listElementStocked.remove(listElementStocked.indexOf(e));
            listElementOtherUsages.add(e);
        }
        else throw new NoSuchElementException();
    }

    public ArrayList<Element> getListElementComposted() {
        return listElementComposted;
    }

    public ArrayList<Element> getListElementEaten() {
        return listElementEaten;
    }

    public ArrayList<Element> getListElementFed() {
        return listElementFed;
    }

    public ArrayList<Element> getListElementStocked() {
        return listElementStocked;
    }

    public ArrayList<Element> getListElementThrowed() {
        return listElementThrowed;
    }
    
    public String getMealType() { return this.mealType; }
    
    public Date getDayMeal() { return this.dayMeal; }
    
    public Element getElementOnHold(){ return this.elementOnHold; }
    
    public boolean isOnHold() { return this.isOnHold; }
    
    
}
