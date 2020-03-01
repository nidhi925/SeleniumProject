package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	public LoginPageTest()
	{
		
		super();
		
	}
	@BeforeMethod 
	public void Setup()
	{
		InitializeMethod();
		
		loginpage = new LoginPage();
		
	}
	
@Test
	
	public void Login()
	{
		loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));		
		//Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
		
		
	}
	
	@Test
	
	public void LoginPageTitle()
	{
		String title = loginpage.getTitle();
		
		Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
	
	

}
