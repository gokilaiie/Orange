package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.JavaScriptUtil;

public class MyInfoPage extends TestBase 
{
	//Page Factory
	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 --strong']")
	WebElement Username;
	
	@FindBy(xpath ="//a[text()='Personal Details']")
	WebElement PersonalDetails;
	
	@FindBy (xpath="//a[text()='Contact Details']")
	WebElement ContactDetails;
	
	@FindBy (xpath="//a[text()='Emergency Contacts']")
	WebElement EmergencyContacts;
	
	@FindBy(xpath="//a[text()='Dependents']")
	WebElement Dependents;
	
	@FindBy(xpath="//a[text()='Immigration']")
	WebElement Immigration;
	
	@FindBy(xpath="//h6[text()='Attachments']")
	WebElement Attachments;
	
	@FindBy(xpath="//span[text()='Performance']")
	WebElement Performancelink;
	
	//Initialization
	public MyInfoPage()
	{
		PageFactory.initElements(driver,this);
		
	}
	
	//Actions
	public String validateTitle()
	{
		return driver.getTitle();
	}
	public boolean Username()
	{
		Boolean UserNm=Username.isDisplayed();
		return UserNm;
	}
	public boolean PersonalDetails()
	{
		Boolean b = Username.isDisplayed();
		return b;
	}
	
	public void Details() throws InterruptedException
	{
		Thread.sleep(2000);
		JavaScriptUtil.scrollIntoView(Attachments, driver);
		Thread.sleep(2000);
		
	}
	public void AllDetails() throws InterruptedException
	{
		PersonalDetails.click();
		Thread.sleep(2000);
		ContactDetails.click();
		Thread.sleep(2000);
		EmergencyContacts.click();
		Thread.sleep(2000);
		Dependents.click();
		Thread.sleep(2000);
	}
	
	public PerformancePage PerformanceClick()
	{
		Performancelink.click();
		return new PerformancePage();
	}
	
}
