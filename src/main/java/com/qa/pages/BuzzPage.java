package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.base.TestBase;
import com.qa.util.JavaScriptUtil;

public class BuzzPage extends TestBase {
	@FindBy(xpath = "//h6[text()='Buzz']")
	WebElement Header;

	@FindBy(xpath = "//a[contains(text(),'Buzz Newsfeed')]")
	WebElement feed;
	
	@FindBy(xpath="//p[text()='1 Like']")
	WebElement Like;

	public BuzzPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean Header() {
		boolean b = Header.isDisplayed();
		return b;
	}

	/*
	 * public void Feed() {
	 * 
	 * Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
	 * xpath("//a[normalize-space()='Buzz Newsfeed']")));
	 * 
	 * //WebElement BuzzFeed =
	 * driver.findElement(By.xpath("//a[normalize-space()='Buzz Newsfeed']"));
	 * //boolean a = feed.isDisplayed();
	 * Assert.assertEquals(feed.getText(),"Buzz Newsfeed");
	 * 
	 * //return a; }
	 */
	public void scrolldown() throws InterruptedException {
		JavaScriptUtil.scrollPageDown(driver);
		Thread.sleep(2000);
		JavaScriptUtil.scrollIntoView(Like, driver); 
		Thread.sleep(2000);
		 
	}
}
