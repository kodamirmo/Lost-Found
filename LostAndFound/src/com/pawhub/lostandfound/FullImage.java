package com.pawhub.lostandfound;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;

public class FullImage extends Activity { 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_full_image); 
		
		ImageView icon = (ImageView) findViewById(R.id.myImage);
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inTempStorage = new byte[3*1024];
		
		String path="android.resource://com.pawhub.lostandfound/drawable/finding_home";

		Bitmap ops = BitmapFactory.decodeFile(path, options);
		icon.setImageBitmap(ops);  // where icon is the imageView in your xml file
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.full_image, menu);
		return true;
	}

}
