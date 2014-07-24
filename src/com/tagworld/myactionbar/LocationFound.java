package com.tagworld.myactionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class LocationFound extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.locationfound);
		 ActionBar actionBar = getActionBar();
		 
	        // Enabling Up / Back navigation
	     actionBar.setDisplayHomeAsUpEnabled(true);
	     actionBar.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
	    // actionBar.setIcon(R.drawable.ico_actionbar);

	}

}
