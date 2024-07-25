package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DashboardPage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.LoginPage;
import com.qa.pages.MyInfoPage;
import com.qa.pages.PerformancePage;

public class PerformanceTest  extends TestBase
{
	LoginPage LoginPage;
	DashboardPage DashboardPage;
	PerformancePage PerformancePage;
	MyInfoPage MyInfoPage;
	DirectoryPage DirectoryPage;
	
	public PerformanceTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		LoginPage=new LoginPage();
		DashboardPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		MyInfoPage = new MyInfoPage();
		PerformancePage = MyInfoPage.PerformanceClick();	
		DirectoryPage = new DirectoryPage();
	}
	
	@Test
	public void ValidateTitle()
	{
		driver.getTitle();
	}
	
	@Test(priority=1)
	public void Title()
	{
		String Title = PerformancePage.Validatetitle();
		Assert.assertEquals(Title, "OrangeHRM");
	}
	@Test(priority=2)
	public void ManageReview()
	{
		boolean Perf = PerformancePage.Title();
		Assert.assertEquals(Perf, true);
		Boolean Manage = PerformancePage.MR();
		Assert.assertEquals(Manage, true);
	}
	@Test(priority=3)
	public void Mytracker() throws InterruptedException
	{
		PerformancePage.MyTracker();
		Thread.sleep(2000);
	}
	
	@Test(priority=4)
	public void DirClick()
	{
		PerformancePage.DirClick();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
