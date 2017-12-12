package com.example.mediabs;

import java.util.ArrayList;
import java.util.List;

import logic.Patient;
import logic.Ward;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.view.*;

public class WardSelectionActivity extends Activity {
//	hallo Anna

	private List<String> valueList = new ArrayList<String>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ward_selection);
		
		final Update u = (Update) this.getApplication();
		final ArrayList<Ward> wardList = ((Update)this.getApplication()).getWardList();
		
		// wardnames in new list
		for (Ward ward : wardList) {
			valueList.add(ward.getWardNumber() + " " + ward.getWardName());
		}
		
		ListAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),
				R.layout.my_list_item, valueList);

		
		final ListView lv = (ListView) findViewById(R.id.wardListView);
		
		lv.setAdapter(adapter);

		// Listener
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(getApplicationContext(),PatientSelectionActivity.class);
//				intent.setClassName(getPackageName(), getPackageName()
//						+ ".PatientSelectionActivity");
				intent.putExtra("selected", lv.getAdapter().getItem(arg2)
						.toString());
				startActivity(intent);
			}
		});
		
		// ButtonListener
		Button exitButton = (Button) findViewById(R.id.exitRotationButton);
				exitButton.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Toast toast = Toast.makeText(getApplicationContext(),"Visitenturnus "+u.getActualRound()+" abgeschlossen!", Toast.LENGTH_SHORT);
						toast.show();
						
						//set abs states true on all patients
						for (Ward w : wardList) {
							for (Patient p : w.getPatientList()) {
								p.setAbsCareGivingState(true);
							}
						}
						// increment rotation counter
						u.incActualRound();
						//save state
						u.storePatients(getApplicationContext());
						u.initData(getApplicationContext());
						
					}

		});
	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.ward_selection, menu);
	// return true;
	// }

	}
}
