package com.automation.pages;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up report and Test is getting ready",true);
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Vtiger"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting done-Test can be started",true);
	}
	
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void setup(String browser,String url) {
		
		Reporter.log("Trying to start Browser and Getting application ready",true);
		//driver=BrowserFactory.startWebApplication(driver,config.getBrowser(),config.getStagingURL());
		driver=BrowserFactory.startWebApplication(driver,browser,url);
		
		Reporter.log("Browser and application is up and running",true);
	}
	
	@AfterClass
	public void teardown() {
		
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException {
		Reporter.log("Test is about to End",true);
		 if(result.getStatus()==ITestResult.FAILURE) {
			// Helper.captureScreenshot(driver);
			 logger.fail("test failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		 }	
		 else if(result.getStatus()==ITestResult.SUCCESS) {
			 
			 logger.pass("test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			 
		 }
		 else if(result.getStatus()==ITestResult.SKIP) {
			 logger.skip("test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			 
		 }
		 report.flush();
		 Reporter.log("Test Completed>>>Reports generated",true);
	}
}
