package com.walletHub.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		}catch(Exception e){ 
			
			System.out.println("Exception is :" + e.getMessage());
			
		}
		
	}
	
	public String getFacebookUrl() {
		String fburl = pro.getProperty("facebookurl");
		return fburl;
	}
	
	public String getFacebookUser() {
		String fbUser = pro.getProperty("username");
		return fbUser;
	}
	
	public String getFacebookPass() {
		String fbPassword = pro.getProperty("facebookPassword");
		return fbPassword;
	}
	
	public String getWallethubUrl() {
		String whurl = pro.getProperty("wallethuburl");
		return whurl;
	}
	
	public String getWallethubProfileUrl() {
		String whurl = pro.getProperty("wallethubProfileurl");
		return whurl;
	}
	
	public String getWallethubUser() {
		String whUser = pro.getProperty("username");
		return whUser;
	}
	

	
	public String getWallethubPass() {
		String whPassword = pro.getProperty("walletHubPassword");
		return whPassword;
	}
	
	public String getChromeDriverPath() {
		String chromeDriver = pro.getProperty("chromdriver");
		return chromeDriver;
	}
	public String getFirefoxDriverPath() {
		String FirefoxDriver = pro.getProperty("firefoxdriver");
		return FirefoxDriver;
	}
}
