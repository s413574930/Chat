package com.ivan.chat.common;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import android.util.Log;

public class Common {
	public static String getIp(){
		String result = null;
		try{
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();)    
            {    
               NetworkInterface intf = en.nextElement();    
               for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();)    
               {    
                   InetAddress inetAddress = enumIpAddr.nextElement();    
                   if (!inetAddress.isLoopbackAddress())    
                   {    
                	   result = inetAddress.getHostAddress().toString(); 
//                       return inetAddress.getHostAddress().toString();    
                   }    
               }    
           } 
		}catch(Exception e){
			Log.e("~", e.getMessage());
		}
		return result;
	}
}
