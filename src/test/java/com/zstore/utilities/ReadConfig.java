package com.zstore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	String path="C:\\Users\\hsaji\\Eclipse_Selenium\\zstore\\Configuration\\config.properties";
	
	public ReadConfig() {
		
		
		try {
			prop=new Properties();
			FileInputStream file=new FileInputStream(path);
			prop.load(file);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	public String getBaseUrl() {
		String value=prop.getProperty("baseUrl");
		
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("url is not found..");
		}
	}
	public String getBrowser() {
		String value=prop.getProperty("browser");
		
		if(value !=null) {
			return value;
		}else {
			throw new RuntimeException("Broser is not found...");
		}
		
	}

}
