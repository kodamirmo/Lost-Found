package com.pawhub.lostandfound;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Detail_3 extends FragmentActivity {
	
	private GoogleMap map; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_3);
		
		map = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.detailReportMap)).getMap();
		
		LatLng coordenada = new LatLng(19.4326018, -99.1332049);
		CameraPosition camPos = new CameraPosition.Builder().target(coordenada)
				.zoom(12).build();

		CameraUpdate cameraUpdate = CameraUpdateFactory
				.newCameraPosition(camPos);

		map.moveCamera(cameraUpdate);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.report_details_activity_actions, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_alert:
			makeAlert();
		return true;
		case R.id.action_share:
			shareIntent();
			return true;
		case R.id.action_resolve:
			makeResolve();
			return true;
		case R.id.action_settings:
			openSettings();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	private void shareIntent() {
		Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        sharingIntent.setType("text/html");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Texto a compartir");        
        startActivity(Intent.createChooser(sharingIntent,"Compartir con"));
	}

	private void openSettings() {
		// TODO Auto-generated method stub
		
	}

	private void makeResolve() {
		Intent detailsIntent =new Intent(this,ListReportsActivity.class);
        startActivity(detailsIntent);
	}

	private void makeAlert() {
		
	}

}
