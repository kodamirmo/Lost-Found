package com.pawhub.lostandfound;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Spinner;
import at.technikum.mti.fancycoverflow.FancyCoverFlow;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.pawhub.lostandfound.adapters.FancyCoverFlowSampleAdapter;

public class ReportActivity extends FragmentActivity {
	
	//creating necessary elements
	
	private GoogleMap map; 
	
	private FancyCoverFlow fancyCoverFlow;
	
	private Spinner reportType;
	private Spinner petAge;
	private Spinner petType;
	private EditText petName;
	private EditText reportTel;
	private EditText petFeatures;
	private EditText reportMsg;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_report);
		
		//calling layout elements
		
		reportType = (Spinner) findViewById(R.id.spinnerReportType);
		petAge = (Spinner) findViewById(R.id.spinnerReportPetAge);
		petType = (Spinner) findViewById(R.id.spinnerReportPetType);
		
		petName = (EditText) findViewById(R.id.editTextpetName);
		reportTel = (EditText) findViewById(R.id.editTextpetReportTel);;
		petFeatures = (EditText) findViewById(R.id.editTextpetFeatures);;
		reportMsg = (EditText) findViewById(R.id.editTextReportMsg);;		
		
		
		//Fancy Cover for Images
		
		this.fancyCoverFlow = (FancyCoverFlow) this.findViewById(R.id.fancyCoverFlow);

        this.fancyCoverFlow.setAdapter(new FancyCoverFlowSampleAdapter());
        this.fancyCoverFlow.setUnselectedAlpha(1.0f);
        this.fancyCoverFlow.setUnselectedSaturation(0.0f);
        this.fancyCoverFlow.setUnselectedScale(0.5f);
        this.fancyCoverFlow.setMaxRotation(0);
        this.fancyCoverFlow.setScaleDownGravity(0.2f);
        this.fancyCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
		
		setTitleColor(Color.RED);

		map = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.reportMap)).getMap();
		
		LatLng coordenada = new LatLng(19.4326018, -99.1332049);
		CameraPosition camPos = new CameraPosition.Builder().target(coordenada)
				.zoom(12).build();

		CameraUpdate cameraUpdate = CameraUpdateFactory
				.newCameraPosition(camPos);

		map.moveCamera(cameraUpdate);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.report, menu);	
		return true;
	}

}
