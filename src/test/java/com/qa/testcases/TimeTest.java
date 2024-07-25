package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.pages.MyInfoPage;
import com.qa.pages.TimePage;

public class TimeTest extends TestBase 
{
	LoginPage LoginPage;
	DashboardPage DashboardPage;
	TimePage TimePage;
	MyInfoPage MyInfoPage;
	
	public TimeTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		LoginPage = new LoginPage();
		DashboardPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		DashboardPage.TimeClick();
		TimePage = new TimePage();
		MyInfoPage = new MyInfoPage();
	}
	@Test(priority=1)
	public void ValidateTitle()
	{
		String Title = TimePage.Validatetitle();
		Assert.assertEquals(Title,"OrangeHRM");
		System.out.println("Title of Page : " +Title);
	}
	
	@Test(priority=2)
	public void validateMyTimeSheet()
	{
		boolean Timesheet = TimePage.ValidateMyTimeSheet();
		System.out.println("My TimeSheet Assert.");
		Assert.assertEquals(Timesheet, true);
		
	}
	@Test(priority=3)
	public void ValidateMyRecords() throws InterruptedException
	{
		TimePage.AttendanceMyRecords();
	}
	
	@Test(priority=4)
	
	  public void MyInfoClick() 
	{
	  
	  MyInfoPage = TimePage.InfoClick();
	}
	 
	
	 @AfterMethod 
	 public void teardown() 
	 { driver.quit(); }
	 

}
