package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.JavaScriptUtil;

public class DashboardPage extends TestBase 
{

	@FindBy(xpath = "//h6[contains(@class, 'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module')]")
	WebElement Dashboard;
	
	@FindBy(xpath = "//p[contains(@class, 'oxd-text oxd-text--p orangehrm-attendance-card-state')]")
	WebElement PunchedOut;
	
	@FindBy(xpath="//i[contains(@class , 'oxd-icon bi-list-check orangehrm-dashboard-widget-icon')]//following-sibling::p[contains(@class,'oxd-text oxd-text--p')]")
	WebElement MyActions;
	
	@FindBy(xpath="//i[contains(@class, 'oxd-icon bi-lightning-charge-fill orangehrm-dashboard-widget-icon')]//following-sibling::p[contains(@class, 'oxd-text oxd-text--p')]")
	WebElement QuickLaunch;
	
	@FindBy(xpath="//p[(text()= 'Employees on Leave Today')]")
	WebElement Leave;
	
	@FindBy(xpath="//p[text()='trainee test2' and @class='oxd-userdropdown-name']")
	WebElement UserNme;
	
	@FindBy(xpath="//span[normalize-space()='Time']")
	WebElement Timelink;
	
	//Initializing all elements
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String DashboardGetetitle()
	{
		
		return driver.getTitle();
	
		
	}
	
	public boolean Dashboard()
	{
		JavaScriptUtil.flash(Dashboard, driver);
		boolean b = Dashboard.isDisplayed();
		return b;
	}
	
	public boolean PunchedOut()
	{
		boolean b = PunchedOut.isDisplayed();
		return b;
	}
	
	public void ScrollIntoView()
	{
		JavaScriptUtil.scrollIntoView(Leave, driver);
		JavaScriptUtil.scrollPageDown(driver);
	}
	
	public TimePage TimeClick()
	{
		Timelink.click();
		return new TimePage();
		
	}
}
