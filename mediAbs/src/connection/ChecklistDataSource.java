package connection;

import java.util.ArrayList;
import java.util.Arrays;

import logic.Checklist;
import android.content.ContentValues;
import android.content.Context;
import net.sqlcipher.Cursor;
import net.sqlcipher.SQLException;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
import net.sqlcipher.database.*;
import android.util.Log;

public class ChecklistDataSource {

  // Database fields
  private SQLiteDatabase database;
  private MySQLiteHelper dbHelper;
  private String[] allColumns = 
	  { 
		  MySQLiteHelper.CHECKLIST_PRETREATMENT,
		  MySQLiteHelper.CHECKLIST_OWNER,
		  MySQLiteHelper.CHECKLIST_MICROBIO,
		  MySQLiteHelper.CHECKLIST_AUTHOR,
		  MySQLiteHelper.CHECKLIST_ROTATION,
		  MySQLiteHelper.CHECKLIST_WARDROUNDDATE,
		  MySQLiteHelper.CHECKLIST_DIAGNOSIS
	  };

  public ChecklistDataSource(Context context) {
    dbHelper = new MySQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase("bubabilubap");
  }

  public void close() {
    dbHelper.close();
  }
  
  public void clearTable() {
	    database.delete(MySQLiteHelper.TABLE_CHECKLIST, null, null);
	  }

  public void insertChecklist(Checklist newChecklist) {
    
	Log.w("lel", "Speichere die folgende Checkliste: "+newChecklist.toString());
	
	ContentValues values = new ContentValues();

    values.put(MySQLiteHelper.CHECKLIST_PRETREATMENT, newChecklist.isPreviousTreatment());
    values.put(MySQLiteHelper.CHECKLIST_OWNER, newChecklist.getOwner());
    values.put(MySQLiteHelper.CHECKLIST_MICROBIO, newChecklist.getMicroBio());
    values.put(MySQLiteHelper.CHECKLIST_AUTHOR, newChecklist.getAuthor());
    values.put(MySQLiteHelper.CHECKLIST_ROTATION, newChecklist.getRotation());
    values.put(MySQLiteHelper.CHECKLIST_WARDROUNDDATE, newChecklist.getWardRoundDate());
    values.put(MySQLiteHelper.CHECKLIST_DIAGNOSIS, arrayListToCSV(newChecklist.getDiagnosisList()));
    
    database.insertOrThrow(MySQLiteHelper.TABLE_CHECKLIST, null, values);
  }

  public ArrayList<Checklist> getAllChecklists() {
    ArrayList<Checklist> checklists = new ArrayList<Checklist>();

    Cursor cursor = database.query(MySQLiteHelper.TABLE_CHECKLIST,
        allColumns, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
   	Checklist newChecklist = cursorToChecklist(cursor);
    	checklists.add(newChecklist);
    	cursor.moveToNext();
    }
    // Make sure to close the cursor
    cursor.close();
    return checklists;
  }


  private Checklist cursorToChecklist(Cursor cursor) {
	  
	Checklist newChecklist = new Checklist(
			cursor.getInt(0) != 0,
			cursor.getString(1),
			cursor.getString(2),
			cursor.getString(3),
			cursor.getInt(4),
			cursor.getInt(5),
			null,
			csvToArrayList(cursor.getString(6)));
	
	return newChecklist;
  }
  
  /** "1,2,3" -> ArrayList [1, 2, 3] */
  public ArrayList<String> csvToArrayList(String s) {
	  	Log.w("lel", "Eingabe: "+s);
		ArrayList<String> l = new ArrayList<String>(Arrays.asList(s.split(",")));
	  	Log.w("lel", "als Liste: "+l.toString());
	  	return l;
  }
  
  /** ArrayList [1, 2, 3]  -> "1,2,3" */
  public String arrayListToCSV(ArrayList<?> l) {
	  	if (l == null) {
	  		return "";
	  	}
		return l.toString().replace("[", "").replace("]", "").replace(", ", ",");
  }

} 