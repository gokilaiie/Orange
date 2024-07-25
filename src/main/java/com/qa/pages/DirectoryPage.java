package com.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class DirectoryPage extends TestBase
{
	@FindBy(xpath="//h6[text()='Directory']")
	WebElement Directory;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement Input;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Submit;
	
	@FindBy (xpath="//button[@type='reset']")
	WebElement Reset;
	
	@FindBy(xpath="//span[text()='Claim']")
	WebElement Claimlink;
	
	/*
	 * @FindBy(xpath="//div[@role='listbox']") WebElement Searchlist;
	 */
	
	private String Name = "trainee 1";
	
	private String query ="t";
	
	public DirectoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Actions
	public boolean ValidateTitle()
	{
		boolean Title = Directory.isDisplayed();
		return Title;
	}
	
	public void Search() throws InterruptedException, IOException
	{
		Input.sendKeys(query);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@role='listbox']"));
		List<WebElement> SrchDropDown = driver.findElements(By.xpath("//div[@role='listbox']"));
		//WebElement elemnt = Searchlist.findElement(By.xpath("//div[contains(@class, 'oxd-autocomplete-option') and contains(text(), '" + Name + "')]"));
		SrchDropDown.get(0).click();
		//elemnt.click();
		Submit.click();
		Thread.sleep(3000);
		TestUtil.takeScreenshotAtEndOfTest();
		
	}
	
	public void Reset()
	{
		Reset.click();
	}
	
	public ClaimPage ClaimClick()
	{
		Claimlink.click();
		return new ClaimPage();
	}

}
