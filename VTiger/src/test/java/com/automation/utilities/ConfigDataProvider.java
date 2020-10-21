package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	//3rd chnage
	
	Properties pro;
	//4th chnage
	public ConfigDataProvider() {
	
	File src=new File("./Config/Config.properties");
	try {
		FileInputStream	fis = new FileInputStream(src);
		pro =new Properties();
		pro.load(fis);
	} catch (Exception e) {

		System.out.println("Not able to print config fiie "+e.getMessage());
	}

}
  public String getDatafromConfig(String keytoSearch) {
	  return pro.getProperty(keytoSearch);
	  
  }
  
  public String getBrowser() {
	  return pro.getProperty("Browser");
	  
  }
   public String getStagingURL() {
	   return pro.getProperty("qaURL");
	   	
   }

}
