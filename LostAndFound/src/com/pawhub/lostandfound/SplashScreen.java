package com.pawhub.lostandfound;

import com.pawhub.lostandfound.constants.Constants;
import com.pawhub.lostandfound.preferences.ConfigData;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;

public class SplashScreen extends Activity {

	private Activity activity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		TextView appTitle = (TextView) findViewById(R.id.splash_app_tittle);
		
		SpannableString text = new SpannableString("" + appTitle.getText());
		text.setSpan(new ForegroundColorSpan(Color.rgb(99, 194, 208)), 0, 4, 0);
		text.setSpan(new ForegroundColorSpan(Color.rgb(255, 255, 255)), 5, 7, 1);
		text.setSpan(new ForegroundColorSpan(Color.rgb(255, 212, 0)), 7,
				text.length(), 2);
		appTitle.setText(text, BufferType.SPANNABLE);

		TextView appsubTitle = (TextView) findViewById(R.id.splash_app_subtittle);
		appsubTitle.setTypeface(null, Typeface.BOLD);
		
		activity=this;
		
		AsyncTaskSplash splash=new AsyncTaskSplash();
		splash.execute();
	}

	private class AsyncTaskSplash extends AsyncTask<Void, Void, Void>{
		@Override
		protected Void doInBackground(Void... params) {
			try {
				if(Constants.isDebug())
					Thread.sleep(100);
				else
					Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		protected void onPostExecute(Void param){
			
			Intent loginScreen;
			
			//Change condition when login has been implemented
			if(!ConfigData.isLogged(activity))
				loginScreen=new Intent(getApplicationContext(),LoginScreen.class);
			else
				loginScreen=new Intent(getApplicationContext(),Home.class);
			
			loginScreen.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
			getBaseContext().startActivity(loginScreen);
			activity.finish();
		}	
		
	}

}
