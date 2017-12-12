package com.example.mediabs;

import java.util.ArrayList;
import android.widget.CheckBox;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import logic.Checklist;
import logic.Patient;
import logic.Antibiotic;

public class ChecklistActivity extends Activity {


	private String ward;
	private String patientDes;
	private String genderStr;
	private Update updateData;
	private Button medicine0Button;
	private Button medicine1Button;
	private Button medicine2Button;
	private Button editPatientButton;
	private Button diagnosisButton;
	private Button microbioButton;
	private Checklist checklist;
	private CheckBox absstateCheckBox;
	private CheckBox prevTrCheckYes;
	private CheckBox prevTrCheckNo;
	private TextView row2;
	private TextView row1; 
	private TextView row0;
	private Antibiotic ab0;
	private Antibiotic ab1;
	private Antibiotic ab2;


	/**
	 * initialisize views with ids
	 */
	private void init() {

		microbioButton		 = (Button) findViewById(R.id.microBiologyButton);
		editPatientButton 	 = (Button) findViewById(R.id.editPatientButton);
		diagnosisButton 	 = (Button) findViewById(R.id.diagnosisButton);
		medicine0Button 	 = (Button) findViewById(R.id.medicine0Button);
		medicine1Button 	 = (Button) findViewById(R.id.medicine1Button);
		medicine2Button 	 = (Button) findViewById(R.id.medicine2Button);
		absstateCheckBox	 = (CheckBox) (findViewById(R.id.absCaregivingCheckBoxYes));
		prevTrCheckYes 		 = (CheckBox) (findViewById(R.id.previousTreatmentCheckBoxYes));
		prevTrCheckNo 		 = (CheckBox) (findViewById(R.id.previousTreatmentCheckBoxNo));
		row0 				 = (TextView) findViewById(R.id.doctorsResumeSymbol0);
		row1 				 = (TextView) findViewById(R.id.doctorsResumeSymbol1);
		row2 				 = (TextView) findViewById(R.id.doctorsResumeSymbol2);
	}

	@Override
	protected void onCreate(final Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checklist);

		// get interface data from database

		// final Update u = (Update) this.getApplication();
		updateData = (Update) this.getApplication();
		init();

		// update_checklist = updateData.getChecklist();

		Intent lastScreen = getIntent();
		ward = lastScreen.getStringExtra("ward");
		patientDes = lastScreen.getStringExtra("patient");

		// set wardview
		TextView wtv = (TextView) (findViewById(R.id.inputWardTextField));
		wtv.setText(ward);

		// get owner
		final Patient pat = updateData.findPatByName(patientDes);

		// set views from owner data
		TextView iptv = (TextView) (findViewById(R.id.inputPatientTexField));
		iptv.setText(patientDes);

		TextView ibtv = (TextView) (findViewById(R.id.inputBirthdayTextField));
		ibtv.setText(String.valueOf(pat.getBirthday()));

		TextView igtv = (TextView) (findViewById(R.id.inputGenderTextField));
		if (pat.getGender().equals("f")) {
			genderStr = "weibl.";
		} else
			genderStr = "maennl.";

		igtv.setText(genderStr);
		System.out.println(updateData.getChecklistList().toString());

		if (pat.isAbsCareGivingState()) {
			absstateCheckBox.setChecked(pat.isAbsCareGivingState());
		}

		absstateCheckBox.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (absstateCheckBox.isChecked()) {
					pat.setAbsCareGivingState(true);
				} else {
					pat.setAbsCareGivingState(false);
				}
				// debug output
				System.out.println(pat.isAbsCareGivingState());
			}
		});

		// Checklist
		for (Checklist checkl : updateData.getChecklistList()) {
			if (checkl.getOwner().equals(patientDes)) {
				checklist = checkl;
			}
		}

		if (checklist == null) {
			checklist = new Checklist(false, patientDes, "unbekannt",

					updateData.getCurrentUserName(),
					updateData.getActualRound(), updateData.getCurrentDate(),
					new ArrayList<Antibiotic>(), null);
			updateData.addCheckList(checklist);
			System.out.println(updateData.getChecklistList().toString());


		}

		// debug output
		System.out.println(checklist.getMicroBio());


		final Toast toastNoAnti = Toast.makeText(getApplicationContext(),
				"Nicht möglich, da kein Antibiotikum vorhanden ist.",
				Toast.LENGTH_LONG);

		if (checklist.getAntibioticList().size() > 0) {
			ab0 = checklist.getAntibioticList().get(0);
			if (ab0.getDoctorsResume() != "unknown") {
				if (ab0.getDoctorsResume() == "yes")
					row0.setText("ja");
				else
					row0.setText("nein");
			}}

		// Set previous-treatment checkbox
		if (checklist.isPreviousTreatment()) {
			prevTrCheckYes.setChecked(true);
		} else {
			prevTrCheckNo.setChecked(true);
		}

		row0.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checklist.getAntibioticList().size() > 0) {
					ab0 = checklist.getAntibioticList().get(0);
					if (row0.getText().equals("unbek.")) {
						row0.setText("ja");
						ab0.setDoctorsResume("yes");
					} else if (row0.getText().equals("ja")) {
						row0.setText("nein");
						ab0.setDoctorsResume("no");
					} else if (row0.getText().equals("nein")) {
						row0.setText("unbek.");
						ab0.setDoctorsResume("unknown");
					}
					System.out.println("0" + ab0.getDoctorsResume());

				} else {
					toastNoAnti.show();
				}
			}
		});

	
		if (checklist.getAntibioticList().size() > 1) {
			ab1 = checklist.getAntibioticList().get(1);
			if (ab1.getDoctorsResume() != "unknown") {
				if (ab1.getDoctorsResume() == "yes")
					row1.setText("ja");
				else
					row1.setText("nein");
			}
		}

		row1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checklist.getAntibioticList().size() > 1) {
					ab1 = checklist.getAntibioticList().get(1);
					if (row1.getText().equals("unbek.")) {
						row1.setText("ja");
						ab1.setDoctorsResume("yes");
					} else if (row1.getText().equals("ja")) {
						row1.setText("nein");
						ab1.setDoctorsResume("no");
					} else if (row1.getText().equals("nein")) {
						row1.setText("unbek.");
						ab1.setDoctorsResume("unknown");
					}
					System.out.println("1" + ab1.getDoctorsResume());

				} else {
					toastNoAnti.show();
				}
			}
		});

	
		if (checklist.getAntibioticList().size() > 2) {
			ab2 = checklist.getAntibioticList().get(2);
			if (ab2.getDoctorsResume() != "unknown") {
				if (ab2.getDoctorsResume() == "yes")
					row2.setText("ja");
				else
					row2.setText("nein");
			}
		}

		row2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checklist.getAntibioticList().size() > 2) {
					ab2 = checklist.getAntibioticList().get(2);
					if (row2.getText().equals("unbek.")) {
						row2.setText("ja");
						ab2.setDoctorsResume("yes");
					} else if (row2.getText().equals("ja")) {
						row2.setText("nein");
						ab2.setDoctorsResume("no");
					} else if (row2.getText().equals("nein")) {
						row2.setText("unbek.");
						ab2.setDoctorsResume("unknown");
					}
					System.out.println("2" + ab2.getDoctorsResume());

				} else {
					toastNoAnti.show();
				}
			}
		});


		editPatientButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {

				// Neues Intent anlegen
				Intent toEditScreen = new Intent(getApplicationContext(),
						EditPatientActivity.class);
				toEditScreen.putExtra("ward", ward);
				toEditScreen.putExtra("patientExist", patientDes);
				startActivity(toEditScreen);
			}
		});



		diagnosisButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {

				// Neues Intent anlegen
				Intent toDiagnosisScreen = new Intent(getApplicationContext(),
						DiagnosticsActivity.class);
				toDiagnosisScreen.putExtra("patName", patientDes);
				startActivity(toDiagnosisScreen);
			}
		});


		microbioButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {

				// Neues Intent anlegen
				Intent toMicrobioScreen = new Intent(getApplicationContext(),
						MicrobiologyActivity.class);
				toMicrobioScreen.putExtra("patName", patientDes);
				startActivity(toMicrobioScreen);
			}
		});

		
		buttonListener(R.id.medicine0Button, "0", patientDes);
		buttonListener(R.id.medicine1Button, "1", patientDes);
		buttonListener(R.id.medicine2Button, "2", patientDes);

		checkBoxListener();
	}

	/**
	 * previous treatment chechbox listener - makes sure that only one checkbox
	 * is checked
	 */
	private void checkBoxListener() {

		final CheckBox checkBoxYes = (CheckBox) findViewById(R.id.previousTreatmentCheckBoxYes);
		final CheckBox checkBoxNo = (CheckBox) findViewById(R.id.previousTreatmentCheckBoxNo);


		checkBoxYes.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checkBoxYes.isChecked()) {
					checklist.setPreviousTreatment(true);
					checkBoxNo.setChecked(false);
				}
				System.out.println("in checklist YES");

			}
		});
		
		checkBoxNo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checkBoxNo.isChecked()) {
					checklist.setPreviousTreatment(false);
					checkBoxYes.setChecked(false);
				}
				System.out.println("in checklist NO");

			}
		});

	}
	/**
	 * listener of all 3 medicament buttons in this activity
	 * @param idButton    -id of the button
	 * @param buttonNo    -the number of the clicked medicament button (0, 1 or 2)
	 * @param patientDes  -patient that is selected
	 */
	private void buttonListener(int idButton, final String buttonNo,
			final String patientDes) {

		Button medicineButton = (Button) findViewById(idButton);
		medicineButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				System.out.println("in onclickbutton");
				Intent toAntibioticScreen = new Intent(getApplicationContext(),
						EditAntibioticActivity.class);

				toAntibioticScreen.putExtra("ButtonNo", buttonNo);
				toAntibioticScreen.putExtra("PatientDes", patientDes);
				startActivity(toAntibioticScreen);
			}
		});

	}

	@Override
	protected void onPause() {

		super.onPause();

		/** write checklist data back to database */
		Log.w("lel", "onPause() aufgerufen - speichere Checklisten.");
		final Update u = (Update) this.getApplication();
		u.storeChecklists(this);

	}
	/**
	 * this method write texts from database to the medicine buttons label
	 */

	public void createButtonTexts() {

		Log.v("in createButtonTexts ", "IN createButtonTexts");
		Log.v("checklist.getOwner()", checklist.getOwner());

		// first medicine Button
		if (checklist.getAntibioticList().size() > 0
				&& !checklist.getAntibioticList().get(0).getName().isEmpty()) {

			Log.v("medicine0Button ", checklist.getAntibioticList().get(0)
					.getName());
			medicine0Button.setText(checklist.getAntibioticList().get(0)
					.getName());
		}

		Log.v("getAntibioticList SIZE ", "getAntibioticList SIZE");
		System.out.println("getAntibioticList SIZE");
		System.out.println(checklist.getAntibioticList().size());

		// second medicine Button
		if (checklist.getAntibioticList().size() > 1
				&& !checklist.getAntibioticList().get(1).getName().isEmpty()) {

			Log.v("medicine1Button ", checklist.getAntibioticList().get(1)
					.getName());
			medicine1Button.setText(checklist.getAntibioticList().get(1)
					.getName());
		}
		// third medicine Button
		if (checklist.getAntibioticList().size() > 2
				&& !checklist.getAntibioticList().get(2).getName().isEmpty()) {
			Log.v("medicine2Button ", checklist.getAntibioticList().get(2)
					.getName());
			medicine2Button.setText(checklist.getAntibioticList().get(2)
					.getName());
		}
	}

	@Override
	public void onResume() {
		Log.v("Resuming", "Resuming in checkbox");
		super.onResume();
		createButtonTexts();
	}

}
