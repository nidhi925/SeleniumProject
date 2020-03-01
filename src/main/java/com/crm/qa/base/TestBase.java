package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebDriverListner;

public class TestBase {
	

	public static WebDriver driver; 
	public static Properties prop;
	public static WebDriverListner eListner;
	
	public static EventFiringWebDriver edriver;
	public TestBase(){
		
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Nidhi\\Automation\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);		
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
			  
		
		
	}

	public static void InitializeMethod()
	{
		
		String browserName = prop.getProperty("browser");
		
		System.out.println(browserName);
		if (browserName.equals("chrome"))
		 
		{
			System.out.println("  browserName  ");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\njoshee\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		else if (browserName.equals("firefox"))
			 
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\njoshee\\Downloads\\geckodriver-v0.26.0-win32\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get(browserName);
		}

		edriver = new EventFiringWebDriver(driver);
		eListner = new WebDriverListner ();
		edriver.register(eListner);
		driver = edriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
try 
{
	driver.get(prop.getProperty("url"));
}
catch (Exception e2)
{
	System.out.println(e2.getStackTrace());
}
		
	}
	
}
