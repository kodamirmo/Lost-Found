package com.pawhub.lostandfound;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import at.technikum.mti.fancycoverflow.FancyCoverFlow;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.pawhub.lostandfound.adapters.FancyCoverFlowSampleAdapter;

public class ReportActivity extends FragmentActivity {

	// creating necessary elements

	private GoogleMap map;

	private FancyCoverFlow fancyCoverFlow;

	private Spinner reportType;
	private Spinner petAge;
	private Spinner petType;
	private EditText petName;
	private EditText reportTel;
	private EditText petFeatures;
	private EditText reportMsg;
	// data for report types
	String[] reportTypesArray = { "Extraviado", "Encontrado", "Maltrato",
			"Busca Hogar" };
	//data for age range
	String[] ageRangeArray = { "0 - 3 meses", "3 - 6 meses", "6 - 9 meses",
	"9 meses - 1 año", "1 - 4 años", "4 - 8 años", "8 - 12 años", "12 en adelante" };
	//data for pet types
	String[] petTypeArray = { "Perro", "Gato", "Otros" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_report);

		// calling layout elements

		reportType = (Spinner) findViewById(R.id.spinnerReportType);
		petAge = (Spinner) findViewById(R.id.spinnerReportPetAge);
		petType = (Spinner) findViewById(R.id.spinnerReportPetType);

		petName = (EditText) findViewById(R.id.editTextpetName);
		reportTel = (EditText) findViewById(R.id.editTextpetReportTel);
		
		petFeatures = (EditText) findViewById(R.id.editTextpetFeatures);
		
		reportMsg = (EditText) findViewById(R.id.editTextReportMsg);
		

		// adding adapter for types
		reportType.setAdapter(new TypesAdapter(ReportActivity.this,R.layout.spinner_report_types, reportTypesArray));
		
		//adapter for age range	
		ArrayAdapter<String> ageRangesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ageRangeArray);
		petAge.setAdapter(ageRangesAdapter);
		
		//adapter for pet types		
		ArrayAdapter<String> petTypesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, petTypeArray);
		petType.setAdapter(petTypesAdapter);

		// Fancy Cover for Images

		this.fancyCoverFlow = (FancyCoverFlow) this
				.findViewById(R.id.fancyCoverFlow);

		this.fancyCoverFlow.setAdapter(new FancyCoverFlowSampleAdapter());
		this.fancyCoverFlow.setUnselectedAlpha(1.0f);
		this.fancyCoverFlow.setUnselectedSaturation(0.0f);
		this.fancyCoverFlow.setUnselectedScale(0.5f);
		this.fancyCoverFlow.setMaxRotation(0);
		this.fancyCoverFlow.setScaleDownGravity(0.2f);
		this.fancyCoverFlow
				.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);

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

	public class TypesAdapter extends ArrayAdapter<String> {

		public TypesAdapter(Context context, int textViewResourceId,
				String[] objects) {
			super(context, textViewResourceId, objects);
		}

		@Override
		public View getDropDownView(int position, View convertView,
				ViewGroup parent) {
			return getCustomView(position, convertView, parent);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			return getCustomView(position, convertView, parent);
		}

		public View getCustomView(int position, View convertView,
				ViewGroup parent) {

			LayoutInflater inflater = getLayoutInflater();
			View row = inflater.inflate(R.layout.spinner_report_types, parent,
					false);
			TextView label = (TextView) row.findViewById(R.id.textSpinnerAdptr);
			label.setText(reportTypesArray[position]);

			Drawable arr_images[] = {
					getContext().getResources().getDrawable(
							R.drawable.missing_icon_blue),
					getContext().getResources().getDrawable(
							R.drawable.found_icon_blue),
					getContext().getResources().getDrawable(
							R.drawable.found_icon_blue),
					getContext().getResources().getDrawable(
							R.drawable.found_icon_blue) };

			label.setCompoundDrawablesWithIntrinsicBounds(arr_images[position], null, null, null);

			return row;
		}
	}

}
