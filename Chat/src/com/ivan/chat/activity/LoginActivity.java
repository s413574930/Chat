package com.ivan.chat.activity;

import com.ivan.chat.R;
import com.ivan.chat.common.Common;
import com.ivan.chat.interfaces.IAction;
import com.ivan.chat.service.ChatService;
import com.ivan.chat.service.ChatService.MyBinder;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
	private static final String TAG = "LoginActivity";
	private EditText txtLoginUserName;
	private EditText txtLoginUserPwd;
	private Button btnLogin;
	private ChatService chatService;

	private ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			MyBinder myBinder = (MyBinder) service;
			chatService = myBinder.getService();

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		Intent intent = new Intent(this, ChatService.class);
		bindService(intent, conn, Context.BIND_AUTO_CREATE);

		initUI();
		initListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	protected void initUI() {
		txtLoginUserName = (EditText) findViewById(R.id.txtLoginUserName);
		txtLoginUserPwd = (EditText) findViewById(R.id.txtLoginUserPwd);
		btnLogin = (Button) findViewById(R.id.btnLogin);
	}

	protected void initListener() {
		btnLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String userName = txtLoginUserName.getText().toString();
				String userPwd = txtLoginUserPwd.getText().toString();
				String ip = Common.getIp();
				chatService.login(userName, userPwd, ip, new LoginAction());
			}
		});
	}
	
	class LoginAction implements IAction{

		@Override
		public void doCallback(String str) {
			Log.i(TAG, str);
		}
		
	}
	@Override
	protected void onDestroy(){
		super.onDestroy();
		unbindService(conn);
	}

}
