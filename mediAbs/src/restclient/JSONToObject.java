package restclient;

import logic.*;

import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

/**
 * JSONtoObject Class provides Methods for parsing given JSON Strings into Java
 * Objects
 * 
 * @author smh,lel
 * 
 */
class JSONToObject {

	JSONParser parser = new JSONParser();
	private String parseInput;

	/**
	 * @param input
	 *            - JSON-String for parsing
	 */
	public JSONToObject(String input) {
		parseInput = input;
	}

	public String getParseInput() {
		return parseInput;
	}

	public void setParseInput(String parseInput) {
		this.parseInput = parseInput;
	}

	/**
	 * @return LinkedList of InterventionTypes contained in the JSON-String
	 */
	public ArrayList<String> getInterventionTypeList() {

		ArrayList<String> interventionTypes = new ArrayList<String>();

		try {
			Object obj = parser.parse(parseInput);
			JSONArray interventionTypeArray = (JSONArray) obj;

			for (Object interventionTypeObj : interventionTypeArray) {
				/**
				 * parse single JSON-Objects and convert them to
				 * InterventionType-object
				 */
				JSONObject interventionType = (JSONObject) interventionTypeObj;
				String newTitle = (String) interventionType.get("title");
				interventionTypes.add(newTitle);
			}
		} catch (ParseException pe) {
			System.out.println("ParseException at position: "
					+ pe.getPosition());
			System.out.println(pe);
		}

		return interventionTypes;
	}

	/**
	 * @return LinkedList of InfectionDiagnosis contained in the JSON-String
	 */
	public ArrayList<String> getInfectionDiagnosisList() {

		ArrayList<String> infectionDiagnosises = new ArrayList<String>();

		try {
			Object obj = parser.parse(parseInput);
			JSONArray infectionDiagnosisArray = (JSONArray) obj;

			for (Object infectionDiagnosisObj : infectionDiagnosisArray) {
				/**
				 * parse single JSON-Objects and convert them to
				 * InfectionDiagnosis-object
				 */
				JSONObject infectionDiagnosis = (JSONObject) infectionDiagnosisObj;
				String newTitle = (String) infectionDiagnosis.get("title");
				infectionDiagnosises.add(newTitle);
			}
		} catch (ParseException pe) {
			System.out.println("ParseException at position: "
					+ pe.getPosition());
			System.out.println(pe);
		}

		return infectionDiagnosises;
	}

	/**
	 * @return LinkedList of Antibiotics contained in the JSON-String
	 */
	public ArrayList<String> getAntibioticList() {

		ArrayList<String> antibiotics = new ArrayList<String>();

		try {
			Object obj = parser.parse(parseInput);
			JSONArray antibioticArray = (JSONArray) obj;

			for (Object antibioticObj : antibioticArray) {
				/**
				 * parse single JSON-Objects and convert them to
				 * Antibiotic-object
				 */
				JSONObject antibiotic = (JSONObject) antibioticObj;
				String newName = (String) antibiotic.get("title");
				antibiotics.add(newName);
			}
		} catch (ParseException pe) {
			System.out.println("ParseException at position: "
					+ pe.getPosition());
			System.out.println(pe);
		}

		return antibiotics;
	}

	/**
	 * @return LinkedList of Wards contained in the JSON-String
	 */
	public ArrayList<Ward> getWardList() {

		ArrayList<Ward> wards = new ArrayList<Ward>();

		try {
			Object obj = parser.parse(parseInput);
			JSONArray wardArray = (JSONArray) obj;

			for (Object wardObj : wardArray) {
				/** parse single JSON-Objects and convert them to Ward-object */
				JSONObject ward = (JSONObject) wardObj;
				long newNumber = (Long) ward.get("number");
				String newName = (String) ward.get("name");
				Ward newWard = new Ward((int) newNumber, newName);
				wards.add(newWard);
			}
		} catch (ParseException pe) {
			System.out.println("ParseException at position: "
					+ pe.getPosition());
			System.out.println(pe);
		}

		return wards;
	}

	/**
	 * @return LinkedList of Users contained in the JSON-String
	 */
	public ArrayList<User> getUserList() {

		ArrayList<User> users = new ArrayList<User>();

		try {
			Object obj = parser.parse(parseInput);
			JSONArray userArray = (JSONArray) obj;

			for (Object userObj : userArray) {
				/** parse single JSON-Objects and convert them to User-object */
				JSONObject user = (JSONObject) userObj;
				String newName = (String) user.get("username");
				String newPassword = (String) user.get("passwordHash");
				User newUser = new User(newName, newPassword);
				users.add(newUser);
			}
		} catch (ParseException pe) {
			System.out.println("ParseException at position: "
					+ pe.getPosition());
			System.out.println(pe);
		}

		return users;
	}

}