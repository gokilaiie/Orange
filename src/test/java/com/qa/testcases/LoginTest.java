package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends TestBase 
{
	LoginPage LoginPage;
	DashboardPage DashboardPage;
	public ExtentReports extent;
	public ExtentTest extentTest;
	public ExtentTest logger;
	
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Priya Windows");
		extent.addSystemInfo("User Name", "Priya");
		extent.addSystemInfo("Environment", "QA");
		
	}
	
	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		LoginPage = new LoginPage();
		DashboardPage = new DashboardPage();
	}
	
	@Test(priority =1)
	public void ValidateTitle()
	{
		extentTest = extent.startTest("LoginTest");
		String Title = LoginPage.Gettitle();
		System.out.println("Title of Page : " + Title);
		Assert.assertEquals(Title,"OrangeHRM");
		
	}
	
	
	  @Test(priority =2) public void ValidateLogo() 
	  {
		  extentTest = extent.startTest("LoginTest");
	  
		  boolean Logo = LoginPage.Validatelogo(); Assert.assertEquals(Logo, true); 
	  }
	 
	
	@Test(priority=2)
	public void Login()
	{
		extentTest = extent.startTest("LoginTest");
		String Usernm = prop.getProperty("username");
		String Pwd = prop.getProperty("password");
		DashboardPage =  LoginPage.Login(Usernm, Pwd);
	}
	
	
	  @AfterMethod 
	  public void teardown(ITestResult result) throws IOException
	  {
		  if(result.getStatus()==ITestResult.FAILURE){
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
				
				String screenshotPath = TestUtil.getScreenshot(driver, result.getName());
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
				
			}
			else if(result.getStatus()==ITestResult.SKIP){
				extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS){
				extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

			}
			
			
			extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
			driver.quit(); }
	 
}
