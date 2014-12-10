package com.ivan.chat.runnable;

import com.ivan.chat.interfaces.IAction;
import com.ivan.chat.webservice.WebServiceHelper;
import android.os.Process;

public class LoginRunnable implements Runnable{
	private IAction action;
	private String userName;
	private String userPwd;
	private String userIp;
	
	public LoginRunnable(String userName, String userPwd, String userIp, IAction action){
		this.userName = userName;
		this.userPwd = userPwd;
		this.userIp = userIp;
		this.action = action;
	}

	@Override
	public void run() {
		Process.setThreadPriority(Process.THREAD_PRIORITY_DEFAULT);
		WebServiceHelper wsHelp = new WebServiceHelper();
		String result = wsHelp.login(userName, userPwd, userIp);
		action.doCallback(result);
	}

}
