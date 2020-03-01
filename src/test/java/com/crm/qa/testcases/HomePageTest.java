package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginpage;
	ContactsPage contactPage;
	
	HomePageTest()
	{
		super();
	}
	
	@BeforeMethod	
	public void setUp()
	{
		InitializeMethod();
		
		loginpage = new LoginPage();
		contactPage = new ContactsPage();
		homePage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	
	
	@Test 
	
	public void validateTitleTest()
	{
				
		Assert.assertEquals(homePage.HomePageTitle(), "Cogmento CRM", "Home Page title not correct");
		
	}
	
	@Test
	
	public void VerifyUserLabel()
	
	{
		Assert.assertTrue(homePage.CorrectUserName());
	}
	
	@Test(priority =1)
	
	public void clickContacts()
	{
	contactPage=homePage.clickContact();
	


	}		
	
	
@Test
	
	public void VerifyUserNameTest()
	{
	Assert.assertTrue(homePage.CorrectUserName());	
	
		
	}		
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	

}
