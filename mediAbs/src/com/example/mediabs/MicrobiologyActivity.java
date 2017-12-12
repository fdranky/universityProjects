package com.example.mediabs;

import logic.Checklist;
import logic.Patient;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class MicrobiologyActivity extends Activity {

	Checklist checklist;
	String pat;
	Patient owner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_microbiology);

		Intent lastScreen = getIntent();
		pat = lastScreen.getStringExtra("patName");

		Update u = (Update) this.getApplication();

		for (Checklist checkl : u.getChecklistList()) {
			if (checkl.getOwner().equals(pat)) {
				System.out.println(pat);
				checklist = checkl;
			}
		}

		/* micro checkbox */
		final CheckBox requiredCheckBox = (CheckBox) findViewById(R.id.mbRequiredCheckBox);
		final CheckBox isThereCheckBox = (CheckBox) findViewById(R.id.mbIsThereCheckBox);
		final CheckBox notCheckBox = (CheckBox) findViewById(R.id.mbNotCheckBox);
		final CheckBox unknownCheckBox = (CheckBox) findViewById(R.id.mbUnknownInMbCheckBox);

		if (checklist.getMicroBio() != null) {
			String activ = checklist.getMicroBio();
			if (activ.equals("angefordert")) {
				requiredCheckBox.setChecked(true);
			} else if (activ.equals("Befund vorhanden")) {
				isThereCheckBox.setChecked(true);
			} else if (activ.equals("nicht durchgeführt")) {
				notCheckBox.setChecked(true);
			} else
				unknownCheckBox.setChecked(true);
		}

		Button okButton = (Button) findViewById(R.id.okButtonint);

		// Listener
		requiredCheckBox.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (requiredCheckBox.isChecked()) {
					isThereCheckBox.setChecked(false);
					notCheckBox.setChecked(false);
					unknownCheckBox.setChecked(false);
					checklist.setMicroBio("angefordert");
				}
			}
		});

		isThereCheckBox.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isThereCheckBox.isChecked()) {
					requiredCheckBox.setChecked(false);
					notCheckBox.setChecked(false);
					unknownCheckBox.setChecked(false);
					checklist.setMicroBio("Befund vorhanden");
				}
			}
		});

		notCheckBox.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (notCheckBox.isChecked()) {
					requiredCheckBox.setChecked(false);
					isThereCheckBox.setChecked(false);
					unknownCheckBox.setChecked(false);
					checklist.setMicroBio("nicht durchgeführt");
				}
			}
		});

		unknownCheckBox.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (unknownCheckBox.isChecked()) {
					requiredCheckBox.setChecked(false);
					isThereCheckBox.setChecked(false);
					notCheckBox.setChecked(false);
					checklist.setMicroBio("unklar");
				}
			}
		});

		okButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent toChecklistScreen = new Intent(getApplicationContext(),
						ChecklistActivity.class);
				toChecklistScreen.putExtra("patient", pat);
				startActivity(toChecklistScreen);
				MicrobiologyActivity.this.finish();
			}
		});
	}
}
