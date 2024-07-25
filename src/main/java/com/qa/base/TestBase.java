package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("C:\\Users\\gokil\\eclipse-workspace\\OrangeProject\\src\\main\\java\\com\\qa\\config\\config.properties");
		
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@SuppressWarnings("deprecation")
	public static void initialization()
	{
		String browsernm = prop.getProperty("browser");
		if(browsernm.equals(browsernm))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions co = new ChromeOptions();
			co.addArguments("incognito");
			//co.addArguments("headless");
			driver = new ChromeDriver(co);
			
			driver.get(prop.getProperty("url"));
			
			driver.manage().window().maximize();
			//driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_WAIT,TimeUnit.SECONDS);
			
		}
	}

}
