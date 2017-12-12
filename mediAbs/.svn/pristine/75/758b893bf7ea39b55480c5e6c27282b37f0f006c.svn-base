package com.example.mediabs;

import java.util.ArrayList;
import logic.Antibiotic;
import logic.Checklist;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class EditAntibioticActivity extends Activity {

	private Checklist checklist;
	private String patient; // contains the patients name to identify the checklist for
					// the patient
	private String buttonNo; // contains the medicine buttonNo (0,1 or 2), that show
						// which medicament button was pressed
	private Update updateData;// = (Update) this.getApplication();

	private Antibiotic antibiotic = new Antibiotic("", "", 0, "Po", "", "unknown", null);
	private AutoCompleteTextView editAntibioAutoCompleteTextView;
	private AutoCompleteTextView editDosageAutoCompleteTextView; 
	private EditText editCommentTextField;
	private CheckBox therCheckBox;
	private CheckBox proCheckBox;
	private CheckBox unknownCheckBox;
	private CheckBox poCheckBox;
	private CheckBox ivCheckBox;
	
	
	public void init(){
		
		editAntibioAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.editAntibioticAutoCompleteTextView);
		editDosageAutoCompleteTextView  = (AutoCompleteTextView) findViewById(R.id.editDosageAutoCompleteTextView);
		editCommentTextField 			= (EditText) findViewById(R.id.editCommentTextField);
		therCheckBox 					= (CheckBox) findViewById(R.id.therCheckBox);
		proCheckBox 					= (CheckBox) findViewById(R.id.proCheckBox);
		unknownCheckBox 				= (CheckBox) findViewById(R.id.unknownCheckBox);
		poCheckBox 						= (CheckBox) findViewById(R.id.poCheckBox);
		ivCheckBox 						= (CheckBox) findViewById(R.id.ivCheckBox);
		
		// get data from last activity
		Bundle lastscreen = getIntent().getExtras();

		if (lastscreen != null) {
			buttonNo = lastscreen.getString("ButtonNo");
			patient = lastscreen.getString("PatientDes");
			Log.v("buttonNo-zielkorb", buttonNo);
			Log.v("buttonNo-zielkorb", patient);
		}
		for(Checklist checkl : updateData.getChecklistList()){
			
			if(checkl.getOwner().equals(patient)){
				Log.v("in saveToDataface ", "in saveToDataface");
				checklist = checkl;
				if(checklist.getAntibioticList().size() > Integer.parseInt(buttonNo) ){
					antibiotic = checklist.getAntibioticList().get(Integer.parseInt(buttonNo));
				}
			}
		}

	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_antibiotic);
		System.out.println("VOR UPDATE");

		updateData = (Update) this.getApplication(); // get interface data from database
		init();
		checkBoxListener();
		editAntibioAutoCompleteTextView.requestFocus();

		createAutoCompleteTextView(updateData.getAllAntibiotics(),R.id.editAntibioticAutoCompleteTextView);
		createAutoCompleteTextView(updateData.getAllDosages(),R.id.editDosageAutoCompleteTextView);


		buttonListener();
		textViewListener();
		createTexts();

	}

	/**
	 * creates lists for autocompleteTextViews
	 * 
	 * @param outputArrayString
	 *            contains the ArrayList of the shown autoCompleteTextList
	 * @param idTextView
	 *            contains the id of the textview
	 * */

	public void createAutoCompleteTextView(ArrayList<String> outputArrayString,
			int idTextView) {

		ArrayAdapter<String> autoCompleteTextAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_dropdown_item_1line,
				outputArrayString);
		AutoCompleteTextView editAutoCompleteTextView = (AutoCompleteTextView) findViewById(idTextView);
		editAutoCompleteTextView.setThreshold(1);
		editAutoCompleteTextView.setAdapter(autoCompleteTextAdapter);
	}

	/**
	 * previous treatment checkbox listener - makes sure that only one checkbox
	 * is checked
	 */
	private void checkBoxListener() {

		therCheckBox.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (therCheckBox.isChecked()) {
					antibiotic.setProphTher("ther");  
					proCheckBox.setChecked(false);
					unknownCheckBox.setChecked(false);
				}
			}
		});
		proCheckBox.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (proCheckBox.isChecked()) {
					antibiotic.setProphTher("pro");
					therCheckBox.setChecked(false);
					unknownCheckBox.setChecked(false);
				}
			}
		});
		unknownCheckBox.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (unknownCheckBox.isChecked()) {
					antibiotic.setProphTher("unknown");
					proCheckBox.setChecked(false);
					therCheckBox.setChecked(false);
				}
			}
		});
		poCheckBox.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (poCheckBox.isChecked()) {
					antibiotic.setivPo("po");
					ivCheckBox.setChecked(false);
				}
			}
		});
		ivCheckBox.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (ivCheckBox.isChecked()) {
					antibiotic.setivPo("iv");
					poCheckBox.setChecked(false);
				}
			}
		});		
		
		
		
	}

	/**
	 * button listener of interventionPossibilitiesButton
	 */
	public void buttonListener() {

		Button interventionPossibilitiesButton = (Button) findViewById(R.id.interventionPossibilitiyButton);
		interventionPossibilitiesButton.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						Toast toast = Toast.makeText(getApplicationContext(), "Bitte geben Sie erst einen Medikamentennamen ein!", Toast.LENGTH_LONG);
						
						if(antibiotic.getName().isEmpty())
							toast.show();
						else{
							Intent toInterventionPossibilitiesScreen = new Intent(
									getApplicationContext(),
									InterventionPossibilitiesActivity.class);
							
							toInterventionPossibilitiesScreen.putExtra("MedicamentButtonNo", buttonNo);			
							toInterventionPossibilitiesScreen.putExtra("patient", patient);
							startActivity(toInterventionPossibilitiesScreen);
						}
					}
				});
	}

	/**
	 * this method saves antibiotic selected values to the database interface
	 * class that the user selected in the editAntibioticActivity -Values from
	 * activity listeners are ported the the database interface class
	 */
	
	public void textViewListener() {
	
		editAntibioAutoCompleteTextView.setOnItemClickListener(new OnItemClickListener() {

					public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
						
						antibiotic.setName(arg0.getItemAtPosition(arg2).toString().toString());
					}

				});
		editDosageAutoCompleteTextView.setOnItemClickListener(new OnItemClickListener() {

					public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3) {

						antibiotic.setDosage(arg0.getItemAtPosition(arg2).toString().toString());
						Log.v("setDosage", arg0.getItemAtPosition(arg2).toString().toString());
							
					}

				});
			
		editCommentTextField.setOnKeyListener(new View.OnKeyListener() {
				 
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_UP) {

					antibiotic.setComment(editCommentTextField.getText().toString());
				}
				return false;
			}
		
		});
	}
	
		public void createTexts(){
			
			for(Checklist checkl : updateData.getChecklistList()){
				if(checkl.getOwner().equals(patient)){
					checklist = checkl;		

					Log.v("in Checklist", "IN Checklist");

					if(checklist.getAntibioticList().size()-1 >= Integer.parseInt(buttonNo)){
							
						if(!checklist.getAntibioticList().get(Integer.parseInt(buttonNo)).getName().isEmpty())
							editAntibioAutoCompleteTextView.setText(
									checklist.getAntibioticList().get(Integer.parseInt(buttonNo)).getName());

						if(!checklist.getAntibioticList().get(Integer.parseInt(buttonNo)).getDosage().isEmpty())
							editDosageAutoCompleteTextView.setText(
									checklist.getAntibioticList().get(Integer.parseInt(buttonNo)).getDosage());
										
						String prophTher = checklist.getAntibioticList().get(Integer.parseInt(buttonNo)).isProphTher().toLowerCase();

						if(prophTher.equals("pro")){
							proCheckBox.setChecked(true);
						}else if(prophTher.equals("unknown")){
							unknownCheckBox.setChecked(true);
						}else if(prophTher.equals("ther")){
							therCheckBox.setChecked(true);	
						}
		
						String ivpo = checklist.getAntibioticList().get(Integer.parseInt(buttonNo)).getivPo().toLowerCase();
						if(ivpo.equals("po")){
							poCheckBox.setChecked(true);
						}else if(ivpo.equals("iv")){
							ivCheckBox.setChecked(true);
						}			

						editCommentTextField.setText(checklist.getAntibioticList().get(Integer.parseInt(buttonNo)).getComment());
			
					}
				}
			}
		}
					

	 @Override
	 public void onPause()
	 {	
			Log.v("in onpause ", "IN onpause in editAntibiotic");
			Toast toast = Toast.makeText(getApplicationContext(), "Zum Speichern ist min. ein Medikamentennamen notwendig! Fehler beim Speichern", Toast.LENGTH_LONG);
			if(antibiotic.getName().isEmpty())
				toast.show();
			else	
				saveToDataface();
			super.onPause();
	 }
	 /**
		 * this method saves antibiotic selected values to the database interface
		 * class that the user selected in the editAntibioticActivity -Values from
		 * activity listeners are ported the the database interface class
		 */
	 public void saveToDataface() {
		 
		
					if(!antibiotic.getName().isEmpty()  ){
		
						if( Integer.parseInt(buttonNo) < checklist.getAntibioticList().size()  ){																
							checklist.getAntibioticList().set(Integer.parseInt(buttonNo), antibiotic);
						}				
						else{
								checklist.addAntibiotic(antibiotic);					
						}

						Log.v("gespeicherte daten ", "gespeicherte daten");
					    if(!antibiotic.getName().isEmpty())
						   Log.v("antibiotic Name ", antibiotic.getName());
					    if(!antibiotic.getDosage().isEmpty())
					    	Log.v("antibiotic dosage ", antibiotic.getDosage());
					    if(!antibiotic.getivPo().isEmpty())
					    	Log.v("antibiotic ivpo ", antibiotic.getivPo());
					    if(!antibiotic.getComment().isEmpty())
					    	Log.v("antibiotic comment ", antibiotic.getComment());				

				}
			}
		

	 @Override
	 public void onResume()
	 {
	     Log.v("Resuming", "Resuming in EditAntibiotic");
	     createTexts();
	  
	     super.onResume();
	 }

}
