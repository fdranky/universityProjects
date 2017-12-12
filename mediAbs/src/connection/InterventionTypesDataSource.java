package connection;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
import net.sqlcipher.Cursor;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.*;

public class InterventionTypesDataSource {

  // Database fields
  private SQLiteDatabase database;
  private MySQLiteHelper dbHelper;
  private String[] allColumns = 
	  { 
		  MySQLiteHelper.INTERVENTIONTYPES_TITLE,
	  };

  public InterventionTypesDataSource(Context context) {
    dbHelper = new MySQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase("bubabilubap");
  }

  public void close() {
    dbHelper.close();
  }
  
  public void clearTable() {
	    database.delete(MySQLiteHelper.TABLE_INTERVENTIONTYPES, null, null);
	  }

  public void insertInterventionTypeTitle(String title) {
    
	ContentValues values = new ContentValues();

    values.put(MySQLiteHelper.INTERVENTIONTYPES_TITLE, title);
    
    database.insert(MySQLiteHelper.TABLE_INTERVENTIONTYPES, null, values);
  }

  public ArrayList<String> getTitleOfInterventionType() {
    ArrayList<String> interventionTypeTitles = new ArrayList<String>();

    Cursor cursor = database.query(MySQLiteHelper.TABLE_INTERVENTIONTYPES,
        allColumns, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
   	String newInterventionTypeTitle = cursorToInterventionTypeTitle(cursor);
    	interventionTypeTitles.add(newInterventionTypeTitle);
    	cursor.moveToNext();
    }
    // Make sure to close the cursor
    cursor.close();
    return interventionTypeTitles;
  }


  private String cursorToInterventionTypeTitle(Cursor cursor) {
	  
	String newInterventionTypeTitle = new String(
			cursor.getString(0));
	
	return newInterventionTypeTitle;
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