package com.pawhub.lostandfound.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pawhub.lostandfound.R;

public class PetTypesAdapter extends ArrayAdapter<String> {

	private Context context;
	private Activity activity;
	// data for pet types
	String[] petTypeArray = { "Perro", "Gato", "Otro" };
	int arr_petType_images[] = { R.drawable.dog_icon, R.drawable.cat_icon,
			R.drawable.doc_icon };

	public PetTypesAdapter(Activity context, int textViewResourceId,
			String[] objects) {
		
		super(context, textViewResourceId, objects);
		this.activity = context;
		this.context=activity.getBaseContext();
	}

	
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}

	public View getCustomView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.spinner_report_pet_types, parent,
				false);
		TextView label = (TextView) row
				.findViewById(R.id.textPetTypeSpinnerAdptr);
		label.setText(petTypeArray[position]);

		ImageView icon = (ImageView) row
				.findViewById(R.id.imgPetTypeSpinnerAdptr);
		icon.setImageResource(arr_petType_images[position]);

		return row;
	}
}
