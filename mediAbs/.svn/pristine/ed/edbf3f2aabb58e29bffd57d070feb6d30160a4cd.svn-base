package connection;

import java.util.ArrayList;
import logic.Patient;
import android.content.ContentValues;
import android.content.Context;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
import net.sqlcipher.Cursor;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.*;

public class PatientDataSource {

  // Database fields
  private SQLiteDatabase database;
  private MySQLiteHelper dbHelper;
  private String[] allColumns = 
	  { MySQLiteHelper.PATIENT_DESCRIPTION, 
		  MySQLiteHelper.PATIENT_BIRTHDAY,
		  MySQLiteHelper.PATIENT_GENDER,
		  MySQLiteHelper.PATIENT_STATE,
		  MySQLiteHelper.PATIENT_WARD};

  public PatientDataSource(Context context) {
    dbHelper = new MySQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase("bubabilubap");
  }

  public void close() {
    dbHelper.close();
  }
  
  public void clearTable() {
	    database.delete(MySQLiteHelper.TABLE_PATIENT, null, null);
	  }

  public void insertPatient(Patient newPatient, int wardNumber) {
    
	ContentValues values = new ContentValues();
    values.put(MySQLiteHelper.PATIENT_DESCRIPTION, newPatient.getDescription());
    values.put(MySQLiteHelper.PATIENT_BIRTHDAY, newPatient.getBirthday());
    values.put(MySQLiteHelper.PATIENT_GENDER, newPatient.getGender());
    values.put(MySQLiteHelper.PATIENT_STATE, newPatient.isAbsCareGivingState());
    values.put(MySQLiteHelper.PATIENT_WARD, wardNumber);
    
    database.insert(MySQLiteHelper.TABLE_PATIENT, null, values);
  }

//  public void deletePatientColumns(PatientColumns name) {
//    long id = name.getId();
//    database.delete(MySQLiteHelper.TABLE_PATIENT, MySQLiteHelper.COLUMN_ID
//        + " = " + id, null);
//  }

  public ArrayList<Patient> getAllPatients(int WardNumber) {
    ArrayList<Patient> patients = new ArrayList<Patient>();

    Cursor cursor = database.query(MySQLiteHelper.TABLE_PATIENT,
        allColumns, MySQLiteHelper.PATIENT_WARD + "= ?", new String[] {String.valueOf(WardNumber)}, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
    	Patient newPatient = cursorToPatient(cursor);
    	patients.add(newPatient);
    	cursor.moveToNext();
    }
    // Make sure to close the cursor
    cursor.close();
    return patients;
  }

  private Patient cursorToPatient(Cursor cursor) {
	Patient newPatient = new Patient(
			cursor.getString(0),
			cursor.getInt(1),
			cursor.getString(2),
			cursor.getInt(3) != 0);
	
	return newPatient;
  }
} 