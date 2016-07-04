package com.networksecurity;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PSOutput {

	public static void main(String[] args) {
		try {

			String command = "cmd /c ipconfig";
			Process child = Runtime.getRuntime().exec(command);

			InputStream in = child.getInputStream();
			int c;
			StringBuilder sb = new StringBuilder();
			while ((c = in.read()) != -1) {
				sb.append((char)c);
			}
			in.close();
			//System.out.println( printISP(sb.toString()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  boolean printISP(){
		boolean flagValue=false;
		try {
			String command = "cmd /c ipconfig";
			Process child = Runtime.getRuntime().exec(command);

			InputStream in = child.getInputStream();
			int c;
			StringBuilder sb = new StringBuilder();
			while ((c = in.read()) != -1) {
				sb.append((char)c);
			}
			in.close();
			//System.out.println( printISP(sb.toString()));

			String output=sb.toString();

			InputStream inputStream = this.getClass().getClassLoader()
					.getResourceAsStream("ApplicationResource.properties");

			Properties properties = new Properties();
			System.out.println("InputStream is: " + inputStream);
			properties.load(inputStream);
			String propValue = properties.getProperty("networkDnsName");
			
			String[] stringArray=output.split(":");
			for(int i=0;i<stringArray.length;i++){
				String mainArray[]= stringArray[i].split("\n");
				for(int j=0;j<mainArray.length;j++){
					//System.out.println(mainArray[j].replace("\n","").trim());  
					if(!mainArray[j].isEmpty()){
						if(mainArray[j].replace(" ","").trim().equals(propValue)){
							flagValue= true;
							break;
						}
					}
				}
				if(flagValue==true){
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flagValue;

	}
}
