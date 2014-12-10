package com.ivan.chat.activity;

import com.ivan.chat.R;
import com.ivan.chat.R.layout;
import com.ivan.chat.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TabHostActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_host);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab_host, menu);
		return true;
	}

}
