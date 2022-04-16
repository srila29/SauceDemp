package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestCases.BaseClass;

public class LoginPage {
	
	WebDriver driver=TestCases.BaseClass.driver;
	ExtentTest test=BaseClass.test;
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement LoginButton;
	
	public LoginPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	//input[@id='user-name']
	
	public void LoginDetails(String usernamevalue,String passwordValue) {
		username.clear();
		password.clear();
		username.sendKeys(usernamevalue);
		test.log(LogStatus.PASS, "Username entered successfully","PASSED");
		password.sendKeys(passwordValue);
		test.log(LogStatus.PASS, "Password entered successfully","PASSED");
		LoginButton.click();
		test.log(LogStatus.PASS, "Login button clicked successfully","PASSED");
	}

}
