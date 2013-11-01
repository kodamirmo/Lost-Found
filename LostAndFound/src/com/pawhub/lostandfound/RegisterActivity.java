package com.pawhub.lostandfound;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterActivity extends Activity {

	
	private Spinner spinnerUserSex;
	private TextView terms;
	
	// data for spinner for sex
	String[] userSex = { "Mujer", "Hombre" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		//set adapter for spinner sex
		spinnerUserSex = (Spinner) findViewById(R.id.spinnerUserSex);
		spinnerUserSex.setAdapter(new TypesAdapter(RegisterActivity.this,
				R.layout.spinner_register, userSex));
		
		//set onClick listener for terms of use
		terms = (TextView) findViewById(R.id.textViewTerms);
		terms.setMovementMethod(LinkMovementMethod.getInstance()); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.register_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
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
			View row = inflater.inflate(R.layout.spinner_register, parent,
					false);
			TextView label = (TextView) row
					.findViewById(R.id.textViewSpinnerRegisterAdptr);
			label.setText(userSex[position]);

			return row;
		}
	}

}
