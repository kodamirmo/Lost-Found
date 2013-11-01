package com.pawhub.lostandfound;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
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

	private static int TAKE_PICTURE = 1;
	private static int SELECT_PICTURE = 0;

	private Spinner reportType;
	private Spinner petAge;
	private Spinner petType;
	private EditText petName;
	private EditText reportTel;
	private EditText petFeatures;
	private EditText reportMsg;
	private ImageButton takePic;
	private ImageButton choosePic;
	// data for report types
	String[] reportTypesArray = { "Extraviado", "Encontrado", "Maltrato",
			"Busca Hogar", "Accidente" };
	int arr_images[] = { R.drawable.missing_icon_blue,
			R.drawable.found_icon_blue, R.drawable.abuse_icon_blue,
			R.drawable.home_icon_blue, R.drawable.abuse_icon_blue };
	// data for age range
	String[] ageRangeArray = { "0 - 3 meses", "3 - 6 meses", "6 - 9 meses",
			"9 meses - 1 año", "1 - 4 años", "4 - 8 años", "8 - 12 años",
			"12 en adelante" };
	// data for pet types
	String[] petTypeArray = { "Perro", "Gato", "Otro" };

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
		reportType.setAdapter(new TypesAdapter(ReportActivity.this,
				R.layout.spinner_report_types, reportTypesArray));

		// adapter for age range
		ArrayAdapter<String> ageRangesAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, ageRangeArray);
		petAge.setAdapter(ageRangesAdapter);

		// adapter for pet types
		ArrayAdapter<String> petTypesAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, petTypeArray);
		petType.setAdapter(petTypesAdapter);

		// take pic intent

		takePic = (ImageButton) findViewById(R.id.btnTakePhotoReport);
		takePic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent cameraIntent = new Intent(
						MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(cameraIntent, TAKE_PICTURE);
			}
		});

		// choose pic intent

		choosePic = (ImageButton) findViewById(R.id.btnSelectPhotoReport);
		choosePic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent galeryIntent = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
				startActivityForResult(galeryIntent, SELECT_PICTURE);
			}
		});

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
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		/**
		 * Se revisa si la imagen viene de la c‡mara (TAKE_PICTURE) o de la
		 * galer’a (SELECT_PICTURE)
		 */
		if (requestCode == TAKE_PICTURE) {
			if (data != null) {
				if (data.hasExtra("data")) {
					Log.i("prueba", "take");
				}
			}

		} else if (requestCode == SELECT_PICTURE) {
			Log.i("prueba", "select");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.edit_report_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_share:
			shareIntent();
			return true;
		case R.id.action_publish:
			openPublish();
			return true;
		case R.id.action_settings:
			openSettings();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	private void openSettings() {
		
		
	}

	private void openPublish() {
		
		Intent detailsIntent =new Intent(this,Detail_2.class);
        startActivity(detailsIntent);
		
	}

	private void shareIntent() {
		
		Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        sharingIntent.setType("text/html");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Texto a compartir");        
        startActivity(Intent.createChooser(sharingIntent,"Compartir con"));
		
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

			ImageView icon = (ImageView) row.findViewById(R.id.imgSpinnerAdptr);
			icon.setImageResource(arr_images[position]);

			return row;
		}
	}

}
