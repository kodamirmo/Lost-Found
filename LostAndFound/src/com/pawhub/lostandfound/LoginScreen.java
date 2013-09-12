package com.pawhub.lostandfound;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class LoginScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_screen);
		
		TextView appTitle = (TextView) findViewById(R.id.login_app_tittle);
		
		SpannableString text = new SpannableString("" + appTitle.getText());
		text.setSpan(new ForegroundColorSpan(Color.rgb(99, 194, 208)), 0, 4, 0);
		text.setSpan(new ForegroundColorSpan(Color.rgb(255, 255, 255)), 5, 7, 1);
		text.setSpan(new ForegroundColorSpan(Color.rgb(255, 212, 0)), 7,
				text.length(), 2);
		appTitle.setText(text, BufferType.SPANNABLE);

		TextView appsubTitle = (TextView) findViewById(R.id.login_app_subtittle);
		appsubTitle.setTypeface(null, Typeface.BOLD);
	}

	public void onClickLogin(View v){
		Intent home=new Intent(this,Home.class);
		home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		startActivity(home);
		this.finish();
	}
}
