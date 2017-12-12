package logic;

import java.util.ArrayList;

public class Ward {

	private int wardNumber;
	private String wardName;
	private ArrayList<Patient> patientList = new ArrayList<Patient>();
	
	public Ward(int wardNumber, String wardName) {
		super();
		this.wardNumber = wardNumber;
		this.wardName = wardName;
	}


	public void addPatient(Patient p){
		this.patientList.add(p);
		//debug
		System.out.println(patientList);
	}
	
	
	public void editPatient(Patient p, String des, int dat, String gend){
		p.setDescription(des);
		p.setBirthday(dat);
		p.setGender(gend);
		//debug
		System.out.println(patientList);
	}
	
	public void removePatient(Patient p) {
		patientList.remove(p);
	}
	

	public ArrayList<Patient> getPatientList() {
		return patientList;
	}


	public void setPatientList(ArrayList<Patient> patientList) {
		this.patientList = patientList;
	}


	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public int getWardNumber() {
		return wardNumber;
	}

	public void setWardNumber(int wardNumber) {
		this.wardNumber = wardNumber;
	}


	@Override
	public String toString() {
		return "Ward [wardNumber=" + wardNumber + ", wardName=" + wardName
				+ ", patientList=" + patientList + "]";
	}
	
	
}
