package com.networksecurity;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Properties;

public class Localnetwork{

	public  boolean getLocalIp()
	{
		try{
			InputStream inputStream = this.getClass().getClassLoader()
					.getResourceAsStream("ApplicationResource.properties");

			Properties properties = new Properties();
			System.out.println("InputStream is: " + inputStream);
			properties.load(inputStream);
			String propValue = properties.getProperty("ip");
			return  propValue.equals(InetAddress.getLocalHost().getHostAddress());
		}
		catch(Exception e){
			
			System.out.println("Exception : "+e);
			return false;
		}
	}
	/*public static void main(String[] args) throws Exception
	{
		System.out.println(new Localnetwork().getLocalIp());
		System.out.println("Your Host addr: " + InetAddress.getLocalHost().getHostAddress());  // often returns "127.0.0.1"
		Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
		for (; n.hasMoreElements();)
		{
			NetworkInterface e = n.nextElement();

			Enumeration<InetAddress> a = e.getInetAddresses();
			for (; a.hasMoreElements();)
			{
				InetAddress addr = a.nextElement();
				System.out.println("  " + addr.getHostAddress());
			}
		}
	} */
}