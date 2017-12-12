package com.example.mediabs;

import com.example.mediabs.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
//import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import android.widget.EditText;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		/** initialize data */
		final Update u = (Update) this.getApplication();
		u.initData(this);

		Button loginButton = (Button) findViewById(R.id.loginButton);
		final EditText inputUserName = (EditText) findViewById(R.id.username);
		final EditText inputPassword = (EditText) findViewById(R.id.userpassword);

		// ButtonListener
		loginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent toHomeScreen = new Intent(getApplicationContext(),
						HomeActivity.class);
				// ask for authentication
				if (u.login(inputUserName.getText().toString(), inputPassword
						.getText().toString())) {
					// Login successful
					u.setCurrentUserName(inputUserName.getText().toString());
					u.setCurrentPassword(inputPassword.getText().toString());
					startActivity(toHomeScreen);
				} else {
					Toast failedLogin = Toast.makeText(getApplicationContext(),
							"Falsche Logindaten!", Toast.LENGTH_SHORT);
					failedLogin.show();
				}
			}
		});
	}

	 @Override
	 protected void onPause(){
	 super.onPause();
	 LoginActivity.this.finish();
	 }

	// public boolean validateLogin(String uname, String pass, Context context)
	// {
	// mydb = new DbHelper(context);
	// SQLiteDatabase db = mydb.getReadableDatabase();
	// //SELECT
	// String[] columns = {"_id"};
	// //WHERE clause
	// String selection = "username=? AND password=?";
	// //WHERE clause arguments
	// String[] selectionArgs = {uname,pass};
	// Cursor cursor = null;
	// try{
	// //SELECT _id FROM login WHERE username=uname AND password=pass
	// cursor = db.query(DbHelper.SAKET_TABLE_NAME, columns, selection,
	// selectionArgs, null, null, null);
	// startManagingCursor(cursor);
	// } catch(Exception e){
	// e.printStackTrace();
	// }
	// int numberOfRows = cursor.getCount();
	// if(numberOfRows <= 0){
	// Toast.makeText(getApplicationContext(), "Login Failed..\nTry Again",
	// Toast.LENGTH_SHORT).show();
	// return false;
	// }
	// return true;
	// }

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.login, menu);
	// return true;
	// }

}
