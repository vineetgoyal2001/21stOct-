package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;

public class Login extends BaseClass{
	
	@Test(priority=1)
	public void LoginVtiger() {
		
		logger =report.createTest("Login to Vtiger");
		
		//ExcelDataProvider excel=new ExcelDataProvider();
		//excel.getStringData( "Login", 0,0);
		
		LoginPage loginpage =PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting application");

		//loginpage.loginToVtiger("admin","admin");		
		loginpage.loginToVtiger(excel.getStringData("Login",0,0),excel.getStringData("Login", 0, 1));
		
		logger.pass("Login sucessfully");
		
	}
	
	@Test(priority=2)
	public void Logout() {
		
		logger =report.createTest("Logout Vtiger");
		logger.fail("Logout failed");
		
	
	}

}
