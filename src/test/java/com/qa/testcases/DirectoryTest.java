package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ClaimPage;
import com.qa.pages.DashboardPage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PerformancePage;

public class DirectoryTest extends TestBase
{
	LoginPage LoginPage;
	DashboardPage DashboardPage;
	PerformancePage PerformancePage;
	DirectoryPage Directorypage;
	ClaimPage ClaimPage;
	
	public DirectoryTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		LoginPage =new LoginPage();
		DashboardPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		PerformancePage = new PerformancePage();
		Directorypage = PerformancePage.DirClick();
		ClaimPage = new ClaimPage();
		
	}
	
	@Test(priority=1)
	public void Title()
	{
		boolean Title = Directorypage.ValidateTitle();
		Assert.assertEquals(true,Title);
	}
	@Test(priority=2)
	public void Search() throws InterruptedException, IOException
	{
		Directorypage.Search();
		Thread.sleep(2000);
		
		Directorypage.Reset(); 
		Thread.sleep(2000);
		 
	}
	@Test(priority=3)
	public void ClaimClick()
	{
	  Directorypage.ClaimClick();
	}
	
	 @AfterMethod
	 public void teardown() 
	 { driver.quit(); }
	 
}
