package com.pawhub.lostandfound;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Detail_1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_1);
	
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail_1, menu);
		return true;
	}
	
	public void goToReportActivity(View v){
		Intent reportIntent = new Intent(this, ReportActivity.class);
		startActivity(reportIntent);
	}

}
