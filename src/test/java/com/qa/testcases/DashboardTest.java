package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.pages.TimePage;

public class DashboardTest extends TestBase  
{
	LoginPage LoginPage;
	DashboardPage DashBoardPage;
	TimePage TimePage;
	
	public DashboardTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		LoginPage = new LoginPage();
		DashBoardPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		TimePage = new TimePage();
	}
	@Test(priority=1)
	public void Validatetitle()
	{
		String Title = DashBoardPage.DashboardGetetitle();
		Assert.assertEquals(Title,"OrangeHRM");
	}
	
	@Test(priority=2)
	public void Validateashboard()
	{
		Boolean b = DashBoardPage.Dashboard();
		Assert.assertEquals(b, true);
	}
	
	@Test(priority=3)
	public void ValidatePuchedOut()
	{
		Boolean a = DashBoardPage.PunchedOut();
		Assert.assertEquals(a, true);
	}
	
	@Test(priority=4)
	public void ScrollIntoView() throws InterruptedException
	{
		DashBoardPage.ScrollIntoView();
		//Thread.sleep(5000);
	}
	@Test(priority=5)
	public void TimeClick() 
	{
		TimePage = DashBoardPage.TimeClick();
		
	
	}
	@AfterMethod 
	public void teardown()
	{ driver.quit(); }
	
}
