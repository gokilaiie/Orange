package com.qa.pages;

import java.lang.classfile.ClassFile.Option;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;
import com.qa.util.JavaScriptUtil;

public class TimePage extends TestBase
{
	//Page Factory
	@FindBy(xpath="//span[text()='Attendance ']")
	WebElement Attndance;
	
	@FindBy(xpath="//ul[@role='menu']//li[2]")
	WebElement Punchout;
		
	@FindBy(xpath="//h6[text()='My Timesheet']")
	WebElement MyTimesheet;
	
	
	@FindBy(xpath = "//h6[text()='Actions Performed on the Timesheet']")
	WebElement ActionsonTimeSheet;
	
	@FindBy(xpath = "//h5[text()='My Attendance Records']")
	WebElement AttendanceRecords;
	
	@FindBy(xpath="//h6[text() ='Punch In']")
	WebElement PunchIn;
	
	@FindBy(xpath="//span[text() ='My Info']")
	WebElement MyInfolink;
	
	//Initialization
	public TimePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String Validatetitle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidateMyTimeSheet()
	{
		boolean b = MyTimesheet.isDisplayed();
		return b;
	}
	
	public boolean ValidateActionsonTimesheet()
	{
		boolean a = ActionsonTimeSheet.isDisplayed();
		return a;
	}
	
	public void AttendanceMyRecords() throws InterruptedException
	{
		Attndance.click();
		List<WebElement> Attendancedropdown = driver.findElements(By.xpath("//ul[@role='menu']//li"));
		JavaScriptUtil.flash(Attendancedropdown.get(0), driver);
		Thread.sleep(2000);
		Attendancedropdown.get(0).click();
		
		
		
		Attndance.click();
		List<WebElement> Attendancedd = driver.findElements(By.xpath("//ul[@role='menu']//li"));
		JavaScriptUtil.flash(Attendancedd.get(1), driver);
		Thread.sleep(2000);
		Attendancedd.get(1).click();
	}
	/*
	 * public void PunchIn() { Attndance.click(); Attendancedropdown.get(1).click();
	 * 
	 * }
	 */
	
	public MyInfoPage InfoClick()
	{
		MyInfolink.click();
		return new MyInfoPage();
	}
			

}
