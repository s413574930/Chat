package com.ivan.chat.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ivan.chat.interfaces.IAction;
import com.ivan.chat.runnable.LoginRunnable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ChatService extends Service {
	private static final String TAG = "ChatService";
	private MyBinder myBinder = new MyBinder();
	private ExecutorService pool;

	@Override
	public void onCreate() {
		super.onCreate();
		pool = Executors.newFixedThreadPool(10);
		Log.i(TAG, "~~thread pool created");
	}

	@Override
	public int onStartCommand(Intent intent, int flag, int startId) {
		super.onStartCommand(intent, flag, startId);
		
		return startId;
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return myBinder;
	}

	public class MyBinder extends Binder {
		public ChatService getService() {
			return ChatService.this;
		}
	}

	public void login(String userName, String userPwd, String userIp, IAction loginAction) {
		pool.execute(new LoginRunnable(userName, userPwd, userIp, loginAction));
	}

}
