package com.automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}
	@FindBy(name="user_name") WebElement uname;
	
	@FindBy(name="user_password") WebElement pwd;
	
	@FindBy(name="Login") WebElement login;
	
	public void loginToVtiger(String username,String pass) {
		
		uname.sendKeys(username);
		pwd.sendKeys(pass);
		login.click();
	}
}
