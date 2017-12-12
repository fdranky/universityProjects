package com.example.mediabs;

import com.example.mediabs.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		// define Elems
		Button selecWardButton = (Button) findViewById(R.id.wardSelectionButton);
//		selecWardButton.setBackgroundColor(R.drawable.roundedbutton);
		Button synchButton = (Button) findViewById(R.id.synchonizeButton);
//		synchButton.setBackgroundColor(R.drawable.roundedbutton);
		Button logoutButton = (Button) findViewById(R.id.logoutButton);
//		logoutButton.setBackgroundColor(R.drawable.roundedbutton);

		// ButtonListener
		selecWardButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent toWardScreen = new Intent(getApplicationContext(),
						WardSelectionActivity.class);
				startActivity(toWardScreen);
			}
		});
		
		
		synchButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent toSynchScreen = new Intent(getApplicationContext(),
						SynchronizationActivity.class);
				startActivity(toSynchScreen);
				HomeActivity.this.finish();
			}
		});

		logoutButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent toLoginScreen = new Intent(getApplicationContext(),
						LoginActivity.class);
				startActivity(toLoginScreen);
				HomeActivity.this.finish();
			}
		});
		
	}

}
