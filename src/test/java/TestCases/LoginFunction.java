package TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;



import Pages.LoginPage;

public class LoginFunction extends BaseClass {
    ExtentTest test=BaseClass.test;
	@Test(enabled=true)
	public void LoginFailureTest() throws InterruptedException
{
	
	LoginPage loginPage=new LoginPage();
	loginPage.LoginDetails("zyx@gmail.com","Abc@12345");
	WebDriverWait wait=new WebDriverWait(driver, 50);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@data-test='error']")));
	WebElement ErrorMsg=driver.findElement(By.xpath("//h3[@data-test='error']"));
	//test.log(LogStatus.PASS, "The error message displayed successfully","PASSED");
	String ActualMsg=ErrorMsg.getText(); //Error message text is fetched in a string variable
	//String ExpMsg="Epic Username and password do not match any user in this service"; //Wrong msg
	String ExpMsg="Epic sadface: Username and password do not match any user in this service";
	Assert.assertEquals(ActualMsg,ExpMsg);

}
	
	@Test
	public void LoginSuccessTest()
	{
		LoginPage loginPage=new LoginPage();
		loginPage.LoginDetails("standard_user","secret_sauce");
	
		WebDriverWait wait=new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='title']")));
		WebElement DispMsg = driver.findElement(By.xpath("//span[@class='title']"));
		//test.log(LogStatus.PASS, "The welcome message displayed successfully","PASSED");
	
		String ActualMsg=DispMsg.getText(); 
		String ExpMsg="PRODUCTS";
		Assert.assertEquals(ActualMsg,ExpMsg);
	
	}
	
	@Test
	@Parameters({"param1","param2"})
	public void ParameterizedTest(String UserNameValue,String PasswordValue)
	{
		LoginPage loginPage=new LoginPage();
		loginPage.LoginDetails(UserNameValue,PasswordValue);

		WebDriverWait wait=new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='title']")));
		WebElement DispMsg = driver.findElement(By.xpath("//span[@class='title']"));
		//test.log(LogStatus.PASS, "The welcome message displayed successfully","PASSED");
		String ActualMsg=DispMsg.getText(); 
		String ExpMsg="PRODUCTS";
		Assert.assertEquals(ActualMsg,ExpMsg);
		
	
	}
	
	@Test
	public void ExcelDataLoginTest()
	{
		int count=sheet.getLastRowNum();
		System.out.println(count);
		/*for(int i=1;i<=count;i++)
		{
			String unameValue=sheet.getRow(i).getCell(0).getStringCellValue();
			String pwordValue=sheet.getRow(i).getCell(1).getStringCellValue();
			LoginPage loginPage=new LoginPage();
			loginPage.LoginDetails(unameValue,pwordValue);
			WebDriverWait wait=new WebDriverWait(driver, 50);

			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='title']")));
			WebElement DispMsg = driver.findElement(By.xpath("//span[@class='title']"));
			//test.log(LogStatus.PASS, "The welcome message displayed successfully","PASSED");
			String ActualMsg=DispMsg.getText(); 
			String ExpMsg="PRODUCTS";
			Assert.assertEquals(ActualMsg,ExpMsg);
		}*/
		String unameValue=sheet.getRow(1).getCell(0).getStringCellValue();
		String pwordValue=sheet.getRow(1).getCell(1).getStringCellValue();
		LoginPage loginPage=new LoginPage();
		loginPage.LoginDetails(unameValue,pwordValue);
		WebDriverWait wait=new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='title']")));
		WebElement DispMsg = driver.findElement(By.xpath("//span[@class='title']"));
		//test.log(LogStatus.PASS, "The welcome message displayed successfully","PASSED");
		String ActualMsg=DispMsg.getText(); 
		String ExpMsg="PRODUCTS";
		Assert.assertEquals(ActualMsg,ExpMsg);
		
	}
	
	
	
	
	

	
}
