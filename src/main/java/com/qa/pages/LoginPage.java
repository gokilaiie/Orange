package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.JavaScriptUtil;

public class LoginPage  extends TestBase 
{

	//Page Factory
	
	@FindBy(xpath = "//input[@name = 'username']")
	WebElement Username;
	
	@FindBy(xpath = "//input[@name = 'password']")
	WebElement Password;
	
	@FindBy(xpath = "//button[@type= 'submit']")
	WebElement Loginbtn;
	
	@FindBy(xpath = "//div[@class='orangehrm-login-logo-mobile']//img[@alt='orangehrm-logo']")
	WebElement logoimg;
	//div[@class='orangehrm-login-logo-mobile']//img[@alt='orangehrm-logo']
	//div[@class='orangehrm-login-branding']//img[@alt='company-branding']
	//p[text()= 'Forgot your password? ']
	//Initialization
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String Gettitle()
	{
		return driver.getTitle();
	}
	
	
	  public boolean Validatelogo() {
	  
	  boolean Logobln = logoimg.isDisplayed(); return Logobln; }
	 
	
	public DashboardPage Login(String un, String pwd)
	{
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		JavaScriptUtil.drawBorder(Loginbtn, driver);
		Loginbtn.click();
		return new DashboardPage();
		
	}
}