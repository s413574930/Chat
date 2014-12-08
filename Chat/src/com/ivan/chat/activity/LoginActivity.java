package com.ivan.chat.activity;

import com.ivan.chat.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
	private EditText txtLoginUserName;
	private EditText txtLoginUserPwd;
	
	private Button btnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		initUI();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	protected void initUI(){
		txtLoginUserName = (EditText) findViewById(R.id.txtLoginUserName);
		txtLoginUserPwd = (EditText) findViewById(R.id.txtLoginUserPwd);
		btnLogin = (Button) findViewById(R.id.btnLogin);
	}
	
	protected void initListener(){
		
	}

}
