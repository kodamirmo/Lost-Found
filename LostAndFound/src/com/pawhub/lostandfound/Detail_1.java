package com.pawhub.lostandfound;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;

public class Detail_1 extends ActionBarActivity {

	/*private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;

	//Change the numbers to the actions name like btn_alerts
	private TableRow btn_1;
	private TableRow btn_2;
	private TableRow btn_3;
	private TableRow btn_4;
	private TableRow btn_5;
	private TableRow btn_6; 
	private TableRow btn_7;

	private final int SCREEN_1 = 0;
	private final int SCREEN_2 = 1;
	private final int SCREEN_3 = 2;
	private final int SCREEN_4 = 3;
	private final int SCREEN_5 = 4;
	private final int SCREEN_6 = 5;
	private final int SCREEN_7 = 6;

	private int CURRENT_SCREEN = 0;*/
	private String currentTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_1);

		initSlidingMenu();
		
	}

	private void initSlidingMenu() {

		final ActionBar actionBar = getSupportActionBar();

		currentTitle = "";

		/*mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);*/

		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setIcon(R.drawable.app_name2);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color
				.parseColor("#B71C4E")));
		actionBar.setTitle(currentTitle);

		/*mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				actionBar.setTitle(currentTitle);
				supportInvalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				actionBar.setTitle(currentTitle);
				supportInvalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);*/
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
