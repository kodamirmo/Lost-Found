package com.pawhub.lostandfound;

import java.util.Locale;

import com.google.android.gms.maps.SupportMapFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class DetailsActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;
	Fragment mapFragment;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		mapFragment = getSupportFragmentManager().findFragmentByTag(
				"detailReportMap");

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.report_details_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_alert:
			makeAlert();
			return true;
		case R.id.action_share:
			shareIntent();
			return true;
		case R.id.action_resolve:
			makeResolve();
			return true;
		case R.id.action_settings:
			openSettings();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	private void shareIntent() {
		Intent sharingIntent = new Intent(Intent.ACTION_SEND);
		sharingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		sharingIntent.setType("text/html");
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,
				"Texto a compartir");
		startActivity(Intent.createChooser(sharingIntent, "Compartir con"));
	}

	private void openSettings() {
		// TODO Auto-generated method stub

	}

	private void makeResolve() {
		Intent detailsIntent = new Intent(this, ListReportsActivity.class);
		startActivity(detailsIntent);
	}

	private void makeAlert() {

	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */

	public class SectionsPagerAdapter extends FragmentPagerAdapter {
		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			}
			return null;
		}

	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";
		public static int sec;
		public static View rootView;

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			sec = getArguments().getInt(ARG_SECTION_NUMBER);

			try {
				switch (sec) {
				case 1:
					rootView = inflater.inflate(R.layout.activity_detail_1,
							container, false);
					return rootView;
				case 2:
					rootView = inflater.inflate(R.layout.activity_detail_2,
							container, false);
					return rootView;
				case 3:
					rootView = inflater.inflate(R.layout.activity_detail_3,
							container, false);
					return rootView;
				}
			} catch (InflateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		}
		
		@Override
		public void onDestroyView() {
			super.onDestroyView();
			SupportMapFragment f = (SupportMapFragment) getFragmentManager().findFragmentById(
					R.id.detailReportMap);
			if (f != null)
				getFragmentManager().beginTransaction().remove(f).commit();
		}
		
	}
	
	

}
