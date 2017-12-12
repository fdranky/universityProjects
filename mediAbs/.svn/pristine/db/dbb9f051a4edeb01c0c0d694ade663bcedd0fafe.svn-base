package connection;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import net.sqlcipher.Cursor;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.*;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;


public class DosageTitleDataSource {

  // Database fields
  private SQLiteDatabase database;
  private MySQLiteHelper dbHelper;
  private String[] allColumns = 
	  { 
		  MySQLiteHelper.DOSAGE_TITLE,
	  };

  public DosageTitleDataSource(Context context) {
    dbHelper = new MySQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase("bubabilubap");
  }

  public void close() {
    dbHelper.close();
  }
  
  public void clearTable() {
	    database.delete(MySQLiteHelper.TABLE_DOSAGE, null, null);
	  }

  public void insertDosageTitle(String title) {
    
	ContentValues values = new ContentValues();

    values.put(MySQLiteHelper.DOSAGE_TITLE, title);
    
    database.insert(MySQLiteHelper.TABLE_DOSAGE, null, values);
  }

  public ArrayList<String> getTitleOfDosages() {
    ArrayList<String> dosageTitles = new ArrayList<String>();

    Cursor cursor = database.query(MySQLiteHelper.TABLE_DOSAGE,
        allColumns, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
   	String newDosageTitle = cursorToDosageTitle(cursor);
    	dosageTitles.add(newDosageTitle);
    	cursor.moveToNext();
    }
    // Make sure to close the cursor
    cursor.close();
    return dosageTitles;
  }


  private String cursorToDosageTitle(Cursor cursor) {
	  
	String newDosageTitle = new String(
			cursor.getString(0));
	
	return newDosageTitle;
  }
  
  /*
   
  // "1,2,3" -> ArrayList [1, 2, 3] 
  public ArrayList<String> csvToArrayList(String s) {
	  	Log.w("lel", "Eingabe: "+s);
		ArrayList<String> l = new ArrayList<String>(Arrays.asList(s.split(",")));
	  	Log.w("lel", "als Liste: "+l.toString());
	  	return l;
  }
  
  // ArrayList [1, 2, 3]  -> "1,2,3" 
  public String arrayListToCSV(ArrayList<?> l) {
		return l.toString().replace("[", "").replace("]", "").replace(", ", ",");
  }
  
  */
} 