package elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.naming.InvalidNameException;

public class StockMeals implements Serializable, Observer{

	private ArrayList<StockElementMeal> ListSEM = new ArrayList<>();
	private String PATH_SERIALIZATION_FILE = "StockMeals.srz";
	private ElementFactory elementFactory = new ElementFactory();
	
	public void mailCSV(File file, String emailTo, String emailFrom, String username, String pwd) throws InvalidNameException {
		this.exportToCSV(file);
		EmailUsingGMailSMTP mailbox = new EmailUsingGMailSMTP(emailFrom, username, pwd);
		
		String subject = "Excel Decheto";
		String text = "Bonjour, veuillez trouver ci-joint un fichier Excel fournis par les utilisateurs de Decheto";
		mailbox.sendEmailWithAttachment(emailTo, subject, text, file.getAbsolutePath());
	}

	public void exportToCSV(File file) throws InvalidNameException{

		if(!file.isFile() && !file.getAbsolutePath().endsWith(".csv")) throw new InvalidNameException("File is not of CSV format");
		FileWriter myFileWriter = null;
		BufferedWriter myBufferedWriter = null;
		try{
			myFileWriter = new FileWriter(file.getAbsolutePath());
			myBufferedWriter = new BufferedWriter(myFileWriter);

			myBufferedWriter.append(this.getCSVHeader());
			myBufferedWriter.newLine();
			
			int compostMin = 0;
			int compostMax = 0;
			
			for(StockElementMeal SEM : this.ListSEM) {
				myBufferedWriter.append(this.getCSVLine(SEM));
				myBufferedWriter.newLine();
				
				for (Element elem : SEM.getListElementComposted()) {
					compostMin += elem.getMinWeightCompost();
					compostMax += elem.getMaxWeightCompost();
				}
			}
			
			myBufferedWriter.append("TotalCompost;-;-;-;-;-;-;" + compostMin + ";" + compostMax + ";");
		}
		catch(IOException exception){
			exception.printStackTrace();
		}
		finally {
			try {
				myBufferedWriter.flush();
				myBufferedWriter.close();
				myFileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private String getCSVHeader(){
		String ret = "";
		
		ret += "Repas et date;";
		ret += "Aliment1;Aliment1Poubelle;Aliment1Frigo;Aliment1Consommer;Aliment1Animaux;Aliment1Compost;Aliment1PoidsCompostMin;Aliment1PoidsCompostMax;";
		ret += "Aliment2;Aliment2Poubelle;Aliment2Frigo;Aliment2Consommer;Aliment2Animaux;Aliment2Compost;Aliment2PoidsCompostMin;Aliment2PoidsCompostMax;";
		ret += "Aliment3;Aliment3Poubelle;Aliment3Frigo;Aliment3Consommer;Aliment3Animaux;Aliment3Compost;Aliment3PoidsCompostMin;Aliment3PoidsCompostMax;";
		ret += "Aliment4;Aliment4Poubelle;Aliment4Frigo;Aliment4Consommer;Aliment4Animaux;Aliment4Compost;Aliment4PoidsCompostMin;Aliment4PoidsCompostMax;";
		ret += "Aliment5;Aliment5Poubelle;Aliment5Frigo;Aliment5Consommer;Aliment5Animaux;Aliment5Compost;Aliment5PoidsCompostMin;Aliment5PoidsCompostMax;";
		ret += "Aliment6;Aliment6Poubelle;Aliment6Frigo;Aliment6Consommer;Aliment6Animaux;Aliment6Compost;Aliment6PoidsCompostMin;Aliment6PoidsCompostMax;";
		ret += "Aliment7;Aliment7Poubelle;Aliment7Frigo;Aliment7Consommer;Aliment7Animaux;Aliment7Compost;Aliment7PoidsCompostMin;Aliment7PoidsCompostMax;";
		ret += "Aliment8;Aliment8Poubelle;Aliment8Frigo;Aliment8Consommer;Aliment8Animaux;Aliment8Compost;Aliment8PoidsCompostMin;Aliment8PoidsCompostMax;";
		ret += "Aliment9;Aliment9Poubelle;Aliment9Frigo;Aliment9Consommer;Aliment9Animaux;Aliment9Compost;Aliment9PoidsCompostMin;Aliment9PoidsCompostMax;";
		ret += "Aliment10;Aliment10Poubelle;Aliment10Frigo;Aliment10Consommer;Aliment10Animaux;Aliment10Compost;Aliment10PoidsCompostMin;Aliment10PoidsCompostMax;";
		ret += "Aliment11;Aliment11Poubelle;Aliment11Frigo;Aliment11Consommer;Aliment11Animaux;Aliment11Compost;Aliment11PoidsCompostMin;Aliment11PoidsCompostMax;";
		ret += "Aliment12;Aliment12Poubelle;Aliment12Frigo;Aliment12Consommer;Aliment12Animaux;Aliment12Compost;Aliment12PoidsCompostMin;Aliment12PoidsCompostMax;";
		ret += "Aliment13;Aliment13Poubelle;Aliment13Frigo;Aliment13Consommer;Aliment13Animaux;Aliment13Compost;Aliment13PoidsCompostMin;Aliment13PoidsCompostMax;";
		ret += "Aliment14;Aliment14Poubelle;Aliment14Frigo;Aliment14Consommer;Aliment14Animaux;Aliment14Compost;Aliment14PoidsCompostMin;Aliment14PoidsCompostMax;";
		ret += "Aliment15;Aliment15Poubelle;Aliment15Frigo;Aliment15Consommer;Aliment15Animaux;Aliment15Compost;Aliment15PoidsCompostMin;Aliment15PoidsCompostMax;";
		ret += "Aliment16;Aliment16Poubelle;Aliment16Frigo;Aliment16Consommer;Aliment16Animaux;Aliment16Compost;Aliment16PoidsCompostMin;Aliment16PoidsCompostMax;";
		ret += "Aliment17;Aliment17Poubelle;Aliment17Frigo;Aliment17Consommer;Aliment17Animaux;Aliment17Compost;Aliment17PoidsCompostMin;Aliment17PoidsCompostMax;";
		ret += "Aliment18;Aliment18Poubelle;Aliment18Frigo;Aliment18Consommer;Aliment18Animaux;Aliment18Compost;Aliment18PoidsCompostMin;Aliment18PoidsCompostMax;";
		ret += "Aliment19;Aliment19Poubelle;Aliment19Frigo;Aliment19Consommer;Aliment19Animaux;Aliment19Compost;Aliment19PoidsCompostMin;Aliment19PoidsCompostMax;";
		ret += "Aliment20;Aliment20Poubelle;Aliment20Frigo;Aliment20Consommer;Aliment20Animaux;Aliment20Compost;Aliment20PoidsCompostMin;Aliment20PoidsCompostMax;";

		return ret;
	}
	
	private String getCSVLine(StockElementMeal SEM) {
		String ret = "";
		
		ret += SEM.getMealType() + "_du_" + SEM.getDayMealFormatedString() + ";";;
		
		for(Element elem : SEM.getListElementThrowed()) ret += SEM.getIdNameElement(elem) + ";" + elem.getBasicName() + elem.getId() + " (" + elem.getQuantity() + ");-;-;-;-;" + elem.getMinWeightCompost() + ";" + elem.getMaxWeightCompost() + ";";		
		for(Element elem : SEM.getListElementStocked()) ret += SEM.getIdNameElement(elem) + ";-;" + elem.getBasicName() + elem.getId() + " (" + elem.getQuantity() + ");-;-;-;"+ elem.getMinWeightCompost() + ";" + elem.getMaxWeightCompost() + ";";	
		for(Element elem : SEM.getListElementEaten()) ret += SEM.getIdNameElement(elem) + ";-;-;" + elem.getBasicName() + elem.getId() + " (" + elem.getQuantity() + ");-;-;"+ elem.getMinWeightCompost() + ";" + elem.getMaxWeightCompost() + ";";
		for(Element elem : SEM.getListElementFed()) ret += SEM.getIdNameElement(elem) + ";-;-;-;" + elem.getBasicName() + elem.getId() + " (" + elem.getQuantity() + ");-;"+ elem.getMinWeightCompost() + ";" + elem.getMaxWeightCompost() + ";";	
		for(Element elem : SEM.getListElementComposted()) ret += SEM.getIdNameElement(elem) + ";-;-;-;-;" + elem.getBasicName() + elem.getId() + " (" + elem.getQuantity() + ");"+ elem.getMinWeightCompost() + ";" + elem.getMaxWeightCompost() + ";";
		
		return ret;
	}

	@Override
	public void update(Observable o, Object arg) {
		//Serialization
		try ( ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.PATH_SERIALIZATION_FILE)) ) {
			os.writeObject(this);
			System.out.println("Serialisation de StockMeals reussie");


		} catch (IOException e) {
			System.err.println("Erreur pendant la serialisation : " + e);
			System.exit(2);
		}

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
	
	public static void main(String[] args){
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		
		StockMeals SM = new StockMeals();
		StockElementMeal SEM = new StockElementMeal(MealType.breakfast.toString(), new Date());
		SEM.addObserver(SM);
		
		SM.getListSEM().add(SEM);
		
		ElementPomme pommeBio = new ElementPomme(1, true, true, true);
		ElementPasteque pastequePasBio = new ElementPasteque(1, true, false, false);
		SEM.addToEaten(pommeBio);
		SEM.addToComposted(new ElementPoire(1, true, false, false));
		SEM.addToFed(pastequePasBio);
		
		StockElementMeal SEM1 = new StockElementMeal(MealType.lunch.toString(), new Date());
		SEM1.addObserver(SM);
		SM.getListSEM().add(SEM1);
		
		SEM1.addToComposted(new ElementAbricot(2, true, false, false));
		
		try {
			//SM.exportToCSV(new File("./Decheto_data.csv"));
			SM.mailCSV(new File("./Decheto_data.csv"), "titouan.bouete@gmail.com", "dechetotest@gmail.com", "dechetotest", "dechetotest31");
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
