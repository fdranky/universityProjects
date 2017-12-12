package connection;

import java.util.ArrayList;

import logic.Ward;
import android.content.ContentValues;
import android.content.Context;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
import net.sqlcipher.Cursor;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.*;

public class WardDataSource {

  // Database fields
  private SQLiteDatabase database;
  private MySQLiteHelper dbHelper;
  private String[] allColumns = { MySQLiteHelper.WARD_NUMBER, MySQLiteHelper.WARD_NAME};

  public WardDataSource(Context context) {
    dbHelper = new MySQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase("bubabilubap");
  }

  public void close() {
    dbHelper.close();
  }

  public Ward insertWard(Ward newWard) {
    
	ContentValues values = new ContentValues();
    values.put(MySQLiteHelper.WARD_NUMBER, newWard.getWardNumber());
    values.put(MySQLiteHelper.WARD_NAME, newWard.getWardName());
    
    long insertId = database.insert(MySQLiteHelper.TABLE_WARD, null, values);
    Cursor cursor = database.query(MySQLiteHelper.TABLE_WARD, allColumns, 
    					MySQLiteHelper.WARD_NUMBER + " = " + insertId, null, null, null, null);
    cursor.moveToFirst();
    Ward insertedWard = cursorToWard(cursor);
    cursor.close();
    return insertedWard;
  }

//  public void deletePatientColumns(PatientColumns name) {
//    long id = name.getId();
//    database.delete(MySQLiteHelper.TABLE_PATIENT, MySQLiteHelper.COLUMN_ID
//        + " = " + id, null);
//  }

  public ArrayList<Ward> getAllWards() {
    ArrayList<Ward> wards = new ArrayList<Ward>();

    Cursor cursor = database.query(MySQLiteHelper.TABLE_WARD,
        allColumns, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
    	Ward newWard = cursorToWard(cursor);
    	wards.add(newWard);
    	cursor.moveToNext();
    }
    // Make sure to close the cursor
    cursor.close();
    return wards;
  }
  public void clearTable() {
	    database.delete(MySQLiteHelper.TABLE_WARD, null, null);
	  }

  private Ward cursorToWard(Cursor cursor) {
	Ward newWard= new Ward(cursor.getInt(0), cursor.getString(1));
	return newWard;
  }
} 