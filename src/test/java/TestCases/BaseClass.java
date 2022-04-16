package TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class BaseClass {
public static WebDriver driver;
public static ExtentReports reports;
public static ExtentTest test;
XSSFWorkbook workbook;
XSSFSheet sheet;
@BeforeTest
public void DataSetup() throws IOException
{
	reports=new ExtentReports("ExtentReport.html");
	FileInputStream file1=new FileInputStream("ExcelData.xlsx");
	workbook=new XSSFWorkbook(file1);
	sheet=workbook.getSheet("Sheet1");
	
	
	
	
}
@BeforeMethod
public void Setup(Method method)
{
	test=reports.startTest(method.toString());
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");//Register the driver - step 1 - Chrome browser

	 driver=new ChromeDriver();
	driver.get("https://www.saucedemo.com/");// Open the website with the link - step 3
	
	driver.manage().window().maximize();
	
}
@AfterMethod
public void TearDown()
{
	
	reports.endTest(test);
	driver.quit();
	
}
@AfterTest
public void DataTeardown() throws IOException
{
	workbook.close();
	reports.flush();
	reports.close();
}
}
