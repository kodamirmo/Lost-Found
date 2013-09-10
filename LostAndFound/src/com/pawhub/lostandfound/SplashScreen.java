package com.pawhub.lostandfound;

import com.pawhub.lostandfound.constants.Constants;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;

public class SplashScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
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

		}	
		
	}

}
