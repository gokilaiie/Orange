package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.BuzzPage;
import com.qa.pages.ClaimPage;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;

public class BuzzTest extends TestBase {

	LoginPage LoginPage;
	DashboardPage Dashboard;
	ClaimPage ClaimPage;
	BuzzPage BuzzPage;

	public BuzzTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		LoginPage = new LoginPage();
		Dashboard = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		ClaimPage = new ClaimPage();
		BuzzPage = ClaimPage.Buzzclick();

	}

	@Test(priority = 1)
	public void Header() {
		boolean Hdr = BuzzPage.Header();
		System.out.println(Hdr);
		Assert.assertEquals(true, Hdr);

	}

	/*
	 * @Test(priority=2) public void Feed() {
	 * 
	 * boolean feed = BuzzPage.Feed(); System.out.println(feed);
	 * Assert.assertEquals(true, feed);
	 * 
	 * BuzzPage.Feed();
	 * 
	 * }
	 */

	@Test(priority = 2)
	public void Scrolldown() throws InterruptedException {
		BuzzPage.scrolldown();
		Thread.sleep(2000);
	}
	
	@AfterMethod 
	public void teardown() 
	{ driver.quit(); }

}
