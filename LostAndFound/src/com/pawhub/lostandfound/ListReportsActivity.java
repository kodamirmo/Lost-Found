package com.pawhub.lostandfound;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListReportsActivity extends Activity {
	
	private ListView lista;
	
	String[] reportTypesArray = { "Extraviado", "Encontrado", "Maltrato",
			"Busca Hogar", "Accidente" };
	
	int arr_images[] = { R.drawable.missing_ico,
			R.drawable.found_icon, R.drawable.abuse_icon,
			R.drawable.home_ico, R.drawable.found_icon };
	
	int arr_imagesType[] = { R.drawable.dog_icon,
			R.drawable.cat_icon, R.drawable.dog_icon,
			R.drawable.cat_icon, R.drawable.dog_icon };

	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_reports);
		
		lista = (ListView) findViewById(R.id.reportsList);
		
		lista.setAdapter(new ListReportsAdapter(ListReportsActivity.this,
				R.layout.spinner_report_list, reportTypesArray));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.register_activity_actions, menu);
		return true;
	}
	
	public class ListReportsAdapter extends ArrayAdapter<String> {

		public ListReportsAdapter(Context context, int textViewResourceId,
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
			View row = inflater.inflate(R.layout.spinner_report_list, parent,
					false);
			TextView label = (TextView) row.findViewById(R.id.listReportType);
			label.setText(reportTypesArray[position]);

			ImageView icon = (ImageView) row.findViewById(R.id.listReportImgsType);
			icon.setImageResource(arr_images[position]); 
			
			ImageView iconType = (ImageView) row.findViewById(R.id.listReportPetType);
			iconType.setImageResource(arr_imagesType[position]); 
			

			return row;
		}
	}
	
	

}
