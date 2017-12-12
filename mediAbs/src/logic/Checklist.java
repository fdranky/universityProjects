package logic;


import java.sql.Date;
import java.util.ArrayList;

public class Checklist {

	private boolean previousTreatment;
	private String owner;
	//User placeholder
	private String microBio;
	private String author; 
	private int rotation;  //turnus
	private int wardRoundDate;
	private ArrayList<Antibiotic> antibioticList	= new ArrayList<Antibiotic>();
	private ArrayList<String> 	  diagnosisList 	= new ArrayList<String>();

	
	public Checklist(boolean previousTreatment, String owner, String microBio,
			String author, int rotation, int wardRoundDate,
			ArrayList<Antibiotic> antibioticList,
			ArrayList<String> diagnosisList) {
		super();
		this.previousTreatment = previousTreatment;
		this.owner = owner;
		this.microBio = microBio;
		this.setAuthor(author);
		this.setRotation(rotation);
		this.wardRoundDate = wardRoundDate;
		this.antibioticList = antibioticList;
		this.diagnosisList = diagnosisList;
	}
	
	
//	/*converts all antibiotica names to one arraylist of strings
//	 * needed for AutoCompleteTextViews*/
//	public void changeAntibioticsToString(){
//				
//		int i = 0;		
//		while(i < antibioticList.size()) {
//			antibioticStrings.add((antibioticList.get(i++).getName()));				
//		}
//		//antibioticStrings = antibioticStrings;
//	}
	public void addAntibiotic(Antibiotic ab){
		this.antibioticList.add(ab);
		//debug
		System.out.println(antibioticList);
	}
	
	public void editAntibiotic(Antibiotic ab, String na, String dos, int peri, String ivop, String comm, String pT){
//		int abIndex = this.antibioticList.indexOf(ab);
//		this.antibioticList.get(abIndex);
		ab.setName(na);
		ab.setDosage(dos);
		ab.setPeriode(peri);
		ab.setivPo(ivop);
		ab.setComment(comm);
		ab.setProphTher(pT);
		//debug
		System.out.println(antibioticList);
	
	}
	
	public void deleteAntibiotic(Antibiotic ab){
		int abIndex = this.antibioticList.indexOf(ab);
		this.antibioticList.remove(abIndex);
		//debug
		System.out.println(antibioticList);
	}
	
	
	
	
	public ArrayList<Antibiotic> getAntibioticList() {
		return antibioticList;
	}
	public void setAntibioticList(ArrayList<Antibiotic> antibioticList) {
		this.antibioticList = antibioticList;
	}
	public ArrayList<String> getDiagnosisList() {
		return diagnosisList;
	}
	public void setDiagnosisList(ArrayList<String> diagnosisList) {
		this.diagnosisList = diagnosisList;
	}

	public boolean isPreviousTreatment() {
		return previousTreatment;
	}
	public void setPreviousTreatment(boolean previousTreatment) {
		this.previousTreatment = previousTreatment;
	}
	public String getMicroBio() {
		return microBio;
	}
	public void setMicroBio(String microBio) {
		this.microBio = microBio;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getWardRoundDate() {
		return wardRoundDate;
	}
	public void setWardRoundDate(int wardRoundDate) {
		this.wardRoundDate = wardRoundDate;
	}


	@Override
	public String toString() {
		return "Checklist [owner="
				+ owner +"]" ;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getRotation() {
		return rotation;
	}


	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	
	/** extracts relevant information from Checklist-object
	 * 
	 * @param wardList - list of all wards
	 * @return StatisticData-object with that information
	 */
	public StatisticData Checklist2StatisticData(ArrayList<Ward> wardList) {
		
		// Find wardNumber of patient
		int wardNumber = 1;
		for (Ward w: wardList) {
			if (w.getPatientList().contains(owner)) {
				wardNumber = w.getWardNumber();
			}
		}
		
		// Collect intervention types of all used antibiotics
		ArrayList<String> interventionTypes = new ArrayList<String>();
		for (Antibiotic a : antibioticList) {
			for (String i : a.getInterventionPossibilities()) {
				interventionTypes.add(i);
			}
		}
		//manual cast from object array to string array
		String[] interventionTypesArray = new String[interventionTypes.size()];
		for (int i=0; i<interventionTypesArray.length; i++) {
			interventionTypesArray[i] = interventionTypes.get(i);
		}
		
		return new StatisticData(wardRoundDate, interventionTypesArray, rotation, wardNumber, author);
	}
}
