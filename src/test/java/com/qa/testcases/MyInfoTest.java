package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.pages.MyInfoPage;
import com.qa.pages.PerformancePage;
import com.qa.pages.TimePage;

public class MyInfoTest extends TestBase 
{
	LoginPage LoginPage;
	DashboardPage DashboardPage;
	TimePage TimePage;
	MyInfoPage MyInfoPage;
	PerformancePage PerformancePage;
	
	public MyInfoTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		LoginPage = new LoginPage();
		DashboardPage = LoginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		TimePage = new TimePage();
		MyInfoPage = TimePage.InfoClick();
		PerformancePage = new PerformancePage();
		
	}

	@Test(priority=1)
	public void Validatetiltile()
	{
		String Title = driver.getTitle();
		Assert.assertEquals(Title, "OrangeHRM");
				
	}
	
	@Test(priority=2)
	public void Username()
	{
		Boolean UserNm = MyInfoPage.Username();
		Assert.assertEquals(UserNm, true);
	}
	
	@Test(priority=3)
	public void DetailsPage() throws InterruptedException
	{
		MyInfoPage.Details();
	}
	@Test(priority=4)
	public void AllDetails() throws InterruptedException
	{
		MyInfoPage.AllDetails();
	}
	
	@Test(priority=5)
	public void Perfomanceclick()
	{
		MyInfoPage.PerformanceClick();
	}
	
	
	  @AfterMethod 
	  public void TearDown() 
	  { driver.quit(); }
	 
}
