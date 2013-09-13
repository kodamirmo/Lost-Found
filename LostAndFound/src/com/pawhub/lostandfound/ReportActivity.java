package com.pawhub.lostandfound;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

public class ReportActivity extends ActionBarActivity {
	
	private String currentTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_report);

		initSlidingMenu();
	}

	private void initSlidingMenu() {

		final ActionBar actionBar = getSupportActionBar();

		currentTitle = "";

		/*
		 * mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		 * mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
		 * GravityCompat.START);
		 */

		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setIcon(R.drawable.app_name2);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color
				.parseColor("#B71C4E")));
		actionBar.setTitle(currentTitle);

		/*
		 * mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
		 * R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {
		 * public void onDrawerClosed(View view) {
		 * actionBar.setTitle(currentTitle); supportInvalidateOptionsMenu(); }
		 * 
		 * public void onDrawerOpened(View drawerView) {
		 * actionBar.setTitle(currentTitle); supportInvalidateOptionsMenu(); }
		 * }; mDrawerLayout.setDrawerListener(mDrawerToggle);
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.report, menu);
		return true;
	}

}
