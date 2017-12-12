package logic;


import java.util.ArrayList;

public class Antibiotic {

	private String name;
	private String dosage;
	private int periode;
	private String ivPo;
	private String comment;
	private String prophTher;  				  // VALUES:  pro  | ther | unknown
	private ArrayList<String> interventionPossibilities;
	private String doctorsResume = "unknown";	// VALUES yes | no | unknown
	

/**
 * 
 * @param name
 * @param dosage
 * @param periode
 * @param ivPo
 * @param comment
 * @param prophTher
 * @param interventionPossibilities
 */

	public Antibiotic(String name, String dosage, int periode, String ivPo,
			String comment, String prophTher,
			ArrayList<String> interventionPossibilities) {
		super();
		this.name = name;
		this.dosage = dosage;
		this.periode = periode;
		this.ivPo = ivPo;
		this.comment = comment;
		this.prophTher = prophTher;
		this.interventionPossibilities = interventionPossibilities;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public int getPeriode() {
		return periode;
	}
	public void setPeriode(int periode) {
		this.periode = periode;
	}
	public String getivPo() {
		return ivPo;
	}
	public void setivPo(String ivPo) {
		this.ivPo = ivPo;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String isProphTher() {
		return prophTher;
	}
	public void setProphTher(String prophTher) {
		this.prophTher = prophTher;
	}
	public ArrayList<String> getInterventionPossibilities() {
		return interventionPossibilities;
	}
	public void setInterventionPossibilities(
			ArrayList<String> interventionPossibilities) {
		this.interventionPossibilities = interventionPossibilities;
	}
	@Override
	public String toString() {
		return "Antibiotic [name=" + name + ", dosage=" + dosage + ", periode="
				+ periode + ", ivPo=" + ivPo + ", comment=" + comment
				+ ", prophTher=" + prophTher + ", interventionPossibilities="
				+ interventionPossibilities + "]";
	}


	public String getDoctorsResume() {
		return doctorsResume;
	}


	public void setDoctorsResume(String doctorsResume) {
		this.doctorsResume = doctorsResume;
	}
	
}