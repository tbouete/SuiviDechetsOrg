package elements;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by Titouan on 15/11/2017.
 */

public class StockElement {

    private ArrayList<Element> listElementComposted   = new ArrayList<>();
    private ArrayList<Element> listElementEaten       = new ArrayList<>();
    private ArrayList<Element> listElementFed         = new ArrayList<>();
    private ArrayList<Element> listElementStocked     = new ArrayList<>();
    private ArrayList<Element> listElementThrowed     = new ArrayList<>();
    private ArrayList<Element> listElementOtherUsages = new ArrayList<>();

    /**
     * Take an Element from the stock and throw it to the compost
     * @param e the Element to be thrown to the compost
     * @throws NoSuchElementException if the Element is not in the stock
     */
    public void CompostFromStock(Element e)throws NoSuchElementException{
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
    public void EatFromStock(Element e)throws NoSuchElementException{
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
    public void FeedFromStock(Element e)throws NoSuchElementException{
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
    public void ThrowFromStock(Element e)throws NoSuchElementException{
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
    public void UseFromStock(Element e)throws NoSuchElementException{
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
}
