package com.ivan.chat.webservice;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class WebServiceHelper {
	private static final String TAG = "WebServiceHelper";
	private HttpClient httpClient;
	private LinkedList<BasicNameValuePair> params;
	private String baseUrl = "http://192.168.0.2:8080/backend1/login";

	public String login(String userName, String userPwd, String userIp){
		String result = null;
		baseUrl = "http://10.153.153.103:9000/backend1/login";
		httpClient = new DefaultHttpClient();
		params = new LinkedList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("userName", userName));  
		params.add(new BasicNameValuePair("userPwd", userPwd));
		params.add(new BasicNameValuePair("ip", userIp));
		
		try{
			HttpPost postMethod = new HttpPost(baseUrl);
			postMethod.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
			HttpResponse response = httpClient.execute(postMethod);
			HttpEntity httpEntity = response.getEntity();
			int responseCode = response.getStatusLine().getStatusCode();
			Log.i(TAG, "~~"+responseCode);
			if(responseCode != 200){
				return null;
			}
			result = EntityUtils.toString(httpEntity);

			
			
		}catch(UnsupportedEncodingException e) {  
		    e.printStackTrace();  
		} catch (ClientProtocolException e) {  
		    e.printStackTrace();  
		} catch (IOException e) {  
		    e.printStackTrace();  
		}  
		return result;
	}
}
