package com.pawhub.lostandfound;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class ReportActivity extends FragmentActivity {

	private GoogleMap map; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_report);
		
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
