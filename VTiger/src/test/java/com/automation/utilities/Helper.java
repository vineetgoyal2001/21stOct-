package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//screenshot,alert,frames,window,sync issue,javascript executor
	
	public static String captureScreenshot(WebDriver driver) {
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenShotpath=System.getProperty("user.dir")+"./Screenshots/Vtiger_"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File(screenShotpath));
			System.out.println("Screenshot is captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenshot"+e.getMessage());
			Helper.captureScreenshot(driver);
			
		}
		return screenShotpath;
		
		 
		
	}
	
	
	public static String getCurrentDateTime() {
		
		DateFormat customformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
	    return customformat.format(currentDate); 
		
		
	}

}
