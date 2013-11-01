package com.pawhub.lostandfound;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;

public class Detail_2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
				MenuInflater inflater = getMenuInflater();
				inflater.inflate(R.menu.report_details_activity_actions, menu);
				
		return true;
	}

}
