package com.pawhub.lostandfound;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class LoginScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_screen);
	}

	public void onClickLogin(View v){
		Intent home=new Intent(this,Home.class);
		home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		startActivity(home);
		this.finish();
	}
}
