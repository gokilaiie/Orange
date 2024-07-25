package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.JavaScriptUtil;

public class ClaimPage extends TestBase 
{
	@FindBy(xpath="//h6[text()='Claim']")
	WebElement Header;
	
	@FindBy(xpath="//a[text()='Submit Claim']")
	WebElement Submit;
	
	@FindBy(xpath="//span[text()='Buzz']")
	WebElement Buzzlink;
	
	public ClaimPage()
	{
		PageFactory.initElements(driver, this);
	}

	public boolean Validatetitle() throws InterruptedException
	{
		JavaScriptUtil.flash(Header, driver);
		Thread.sleep(2000);
		boolean b = Header.isDisplayed();
		return b;
	}
	
	public void Submit() throws InterruptedException
	{
		Submit.click();
		Thread.sleep(2000);
	}
	
	public BuzzPage Buzzclick()
	{
		Buzzlink.click();
		return new BuzzPage();
	}
}
