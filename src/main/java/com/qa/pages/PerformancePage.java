package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class PerformancePage extends TestBase
{
	//Page Factory
	@FindBy(xpath="//h6[text()='Performance']")
	WebElement Performance;
	
	@FindBy (xpath="//h6[text()='Manage Reviews']")
	WebElement ManageReviews;
	
	@FindBy(xpath="//h6[text()='My Reviews']")
	WebElement Reviews;
	
	@FindBy(xpath="//a[text()='My Trackers']")
	WebElement MyTracker;
	
	@FindBy(xpath="//span[text()='Directory']")
	WebElement Directorylink;
	
	//Initialization
	public PerformancePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String Validatetitle()
	{
		return driver.getTitle();
	}
	
	public boolean Title()
	{
		boolean Perf = Performance.isDisplayed();
		return Perf;
	}
	
	public boolean MR()
	{
		boolean mngReview = ManageReviews.isDisplayed();
		return mngReview;
	}
	
	public void MyTracker()
	{
		MyTracker.click();
		
	}
	
	public DirectoryPage DirClick()
	{
		Directorylink.click();
		return new DirectoryPage();
	}

}
