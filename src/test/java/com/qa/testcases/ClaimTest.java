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
import com.qa.pages.BuzzPage;
import com.qa.pages.ClaimPage;
import com.qa.pages.DashboardPage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ClaimTest  extends TestBase 
{
	LoginPage LoginPage;
	DashboardPage Dashboard;
	DirectoryPage DirectoryPage;
	ClaimPage ClaimPage;
	BuzzPage BuzzPage;
	
	public ExtentReports extent;
	public ExtentTest extentTest;
	public ExtentTest logger;
	
	public ClaimTest()
	{
		super();
	}
	
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
	
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		LoginPage = new LoginPage();
		Dashboard = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		DirectoryPage = new DirectoryPage();
		ClaimPage = DirectoryPage.ClaimClick();
		BuzzPage = new BuzzPage();
				
	}
	
	@Test(priority=1)
	public void Header() throws InterruptedException
	{
		extentTest = extent.startTest("ClaimTest Header");
		boolean Hdr=ClaimPage.Validatetitle();
		System.out.println(Hdr);
		Assert.assertEquals(true, Hdr);
		
	}
	
	@Test(priority=2)
	public void Submit() throws InterruptedException
	{
		extentTest = extent.startTest("ClaimTest Submit");
		ClaimPage.Submit();
	}
	
	@Test(priority=3)
	public void Buzzclick()
	{
		extentTest = extent.startTest("ClaimTest BuzzClick");
		ClaimPage.Buzzclick();
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
		driver.quit(); 
	}

}
