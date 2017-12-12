package com.example.mediabs;

import java.util.ArrayList;

import logic.Patient;
import logic.Ward;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;

public class EditPatientActivity extends Activity {

	private Patient patient;
	// define TextFields and Button
	EditText inputDescription;
	EditText inputBirthday;
	CheckBox maskulinCheckBox;
	CheckBox femininCheckBox;
	String gender;
	String wardStr;
	String patStr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_patient);

		Update u = (Update) this.getApplication();
		final ArrayList<Ward> wardList = u.getWardList();

		Button okButton = (Button) findViewById(R.id.okButton);

		Intent intent = getIntent();
		wardStr = intent.getStringExtra("ward");
		patStr = intent.getStringExtra("patientExist");

		// define TextFields and Button
		inputDescription = (EditText) findViewById(R.id.desciptionEditText);
		inputBirthday = (EditText) findViewById(R.id.birthdayEditText);
		maskulinCheckBox = (CheckBox) findViewById(R.id.maskulinCheckBox);
		femininCheckBox = (CheckBox) findViewById(R.id.femininCheckBox);

		if (patStr != null) {
			patient = u.findPatByName(patStr);
			inputDescription.setText(patient.getDescription());
			inputBirthday.setText(String.valueOf(patient.getBirthday()));
			if (patient.getGender().equals("f")) {
				femininCheckBox.setChecked(true);
				gender = "f";
			} else
				maskulinCheckBox.setChecked(true);
				gender = "m";
		}

		// Listener
		maskulinCheckBox.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (maskulinCheckBox.isChecked()) {
					femininCheckBox.setChecked(false);
					gender = "m";
				}
			}
		});

		femininCheckBox.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (femininCheckBox.isChecked()) {
					maskulinCheckBox.setChecked(false);
					gender = "f";
				}
			}
		});

		// ClickListener implementieren f�r den Button zum Wechsel der
		// Activity
		okButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				if (patStr != null) {
					patient.setDescription(inputDescription.getText()
							.toString());
					patient.setBirthday(Integer.parseInt(inputBirthday
							.getText().toString()));
					patient.setGender(gender);
				} else {
					patient = new Patient(
							inputDescription.getText().toString(), Integer
									.parseInt(inputBirthday.getText()
											.toString()), gender, false);
				}

				// get the PatientList from wardName
				if (patStr == null) {
					for (Ward ward : wardList) {
						if (wardStr.equals(ward.getWardNumber() + " "
								+ ward.getWardName())) {
							ward.addPatient(patient);
						}
					}
				}

				// Neues Intent anlegen
				Intent nextScreen = new Intent(getApplicationContext(),
						PatientSelectionActivity.class);
				nextScreen.putExtra("selected", wardStr);

				startActivity(nextScreen);

				EditPatientActivity.this.finish();

			}
		});
	}

	/** write patient list back to database */
	@Override
	protected void onPause() {
		super.onPause();

		Log.w("lel", "onPause() aufgerufen...");
		final Update u = (Update) this.getApplication();
		u.storePatients(this);
	}

}

// @Override
// public boolean onCreateOptionsMenu(Menu menu) {
// // Inflate the menu; this adds items to the action bar if it is present.
// getMenuInflater().inflate(R.menu.edit_patient_activity, menu);
// return true;
// }