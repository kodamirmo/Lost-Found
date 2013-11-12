package com.pawhub.lostandfound;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Bitmap.CompressFormat;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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
import android.widget.Toast;
import at.technikum.mti.fancycoverflow.FancyCoverFlow;
import at.technikum.mti.fancycoverflow.FancyCoverFlowAdapter;

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
	private Bitmap setphoto;
	private Bitmap bmpBowRotated;

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
			R.drawable.home_icon_blue, R.drawable.acci_icon_blue };
	// data for age range
	String[] ageRangeArray = { "0 - 3 meses", "3 - 6 meses", "6 - 9 meses",
			"9 meses - 1 año", "1 - 4 años", "4 - 8 años", "8 - 12 años",
			"12 en adelante" };
	// data for pet types
	String[] petTypeArray = { "Perro", "Gato", "Otro" };	
	int arr_petType_images[] = { R.drawable.doc_icon, R.drawable.cat_icon, R.drawable.doc_icon };
	
	//array list for images
	ArrayList<Bitmap> fancyPics = new ArrayList<Bitmap>();

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
		ArrayAdapter<String> ageRangesAdapter = new ArrayAdapter<String>(this, R.layout.spinner_report_age, ageRangeArray);
		petAge.setAdapter(ageRangesAdapter);

		// adapter for pet types
		petType.setAdapter(new PetTypesAdapter(ReportActivity.this,
				R.layout.spinner_report_types,petTypeArray));

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

		// Review if the image come from the camera or the gallery
		Toast toast2 = Toast.makeText(getApplicationContext(),
				"Ocurrió un error", Toast.LENGTH_SHORT);
		
		if(resultCode == RESULT_OK){ 
			
			// If comes from camera
			if (requestCode == TAKE_PICTURE) {
				if (data != null) {
					if (data.hasExtra("data")) {
						String pic = System.currentTimeMillis()+ ".jpg";
						Bitmap photo = (Bitmap) data.getExtras().get("data");
						
						try {
							File temp = new File (Environment.getExternalStorageDirectory (),
					                File.separator + "Pawhub");
							if (!temp.exists ())
					            temp.mkdirs ();
							OutputStream stream = new FileOutputStream(Environment.getExternalStorageDirectory()+ File.separator+"Pawhub"+ File.separator+pic);
							photo.compress(CompressFormat.JPEG, 100, stream);
							stream.flush();
							stream.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							toast2.show();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							toast2.show();
						}
		                
						photo = Bitmap.createBitmap(photo);
						fancyPics.add(photo);
						// Fancy Cover for Images

						this.fancyCoverFlow = (FancyCoverFlow) this
								.findViewById(R.id.fancyCoverFlow);

						this.fancyCoverFlow.setAdapter(new FancyCoverFlowSampleAdapter(fancyPics));
						this.fancyCoverFlow.setUnselectedAlpha(1.0f);
						this.fancyCoverFlow.setUnselectedSaturation(0.0f);
						this.fancyCoverFlow.setUnselectedScale(0.5f);
						this.fancyCoverFlow.setMaxRotation(0);
						this.fancyCoverFlow.setScaleDownGravity(0.2f);
						this.fancyCoverFlow
								.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
						

					} else {
						toast2.show();
					}
				}

				// If comes from gallery
			} else if (requestCode == SELECT_PICTURE) {

				try {
					this.imageFromGallery(resultCode, data, 200, 200);
					fancyPics.add(setphoto);
					// Fancy Cover for Images
					Log.i("array", ""+fancyPics.size());

					this.fancyCoverFlow = (FancyCoverFlow) this
							.findViewById(R.id.fancyCoverFlow);

					this.fancyCoverFlow.setAdapter(new FancyCoverFlowSampleAdapter(fancyPics));
					this.fancyCoverFlow.setUnselectedAlpha(1.0f);
					this.fancyCoverFlow.setUnselectedSaturation(0.0f);
					this.fancyCoverFlow.setUnselectedScale(0.5f);
					this.fancyCoverFlow.setMaxRotation(0);
					this.fancyCoverFlow.setScaleDownGravity(0.2f);
					this.fancyCoverFlow
							.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
					

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					toast2.show();
				}

			}
			
		}
	}
	
	// Takes the image chosen and resizes to show it in image view
		private void imageFromGallery(int resultCode, Intent data, int reqWidth,
				int reqHeight) throws IOException {
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);

			String profile_Path = cursor.getString(columnIndex);
			cursor.close();

			// First decode with inJustDecodeBounds=true to check dimensions

			final BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			setphoto = BitmapFactory.decodeFile(profile_Path, options);

			// Calculate inSampleSize
			options.inSampleSize = calculateInSampleSize(options, reqWidth,
					reqHeight);

			// Decode bitmap with inSampleSize set
			options.inJustDecodeBounds = false;

			ExifInterface ei = new ExifInterface(profile_Path);
			int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,
					ExifInterface.ORIENTATION_NORMAL);
			
			Toast toast1 = Toast.makeText(getApplicationContext(),
					"" + orientation, Toast.LENGTH_SHORT);
			//toast1.show();


			setphoto = BitmapFactory.decodeFile(profile_Path, options);

			switch (orientation) {
			case ExifInterface.ORIENTATION_ROTATE_90:
				rotateImage(setphoto, 90);
				break;
			case ExifInterface.ORIENTATION_ROTATE_180:
				rotateImage(setphoto, 180);
				break;
			case ExifInterface.ORIENTATION_ROTATE_270:
				rotateImage(setphoto, 270);
				break;
			}

		}

		private void rotateImage(Bitmap setphoto2, int i) {
			// TODO Auto-generated method stub
			Matrix matrix = new Matrix();
			matrix.setRotate(i);
			bmpBowRotated = Bitmap.createBitmap(setphoto2, 0, 0,
					setphoto2.getWidth(), setphoto2.getHeight(), matrix, false);
			setphoto = bmpBowRotated;
		}

		public static int calculateInSampleSize(BitmapFactory.Options options,
				int reqWidth, int reqHeight) {
			// Raw height and width of image
			final int height = options.outHeight;
			final int width = options.outWidth;
			int inSampleSize = 1;

			if (height > reqHeight || width > reqWidth) {

				final int halfHeight = height / 2;
				final int halfWidth = width / 2;

				// Calculate the largest inSampleSize value that is a power of 2 and
				// keeps both
				// height and width larger than the requested height and width.
				while ((halfHeight / inSampleSize) > reqHeight
						&& (halfWidth / inSampleSize) > reqWidth) {
					inSampleSize *= 2;
				}
			}

			return inSampleSize;
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
		
		Intent detailsIntent =new Intent(this,Detail_1.class);
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
	
	public class PetTypesAdapter extends ArrayAdapter<String> {

		public PetTypesAdapter(Context context, int textViewResourceId,
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
			View row = inflater.inflate(R.layout.spinner_report_pet_types, parent,
					false);
			TextView label = (TextView) row.findViewById(R.id.textPetTypeSpinnerAdptr);
			label.setText(petTypeArray[position]);

			ImageView icon = (ImageView) row.findViewById(R.id.imgPetTypeSpinnerAdptr);
			icon.setImageResource(arr_petType_images[position]);

			return row;
		}
	}

}
