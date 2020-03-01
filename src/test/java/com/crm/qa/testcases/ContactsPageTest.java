package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginpage;
	ContactsPage contactPage;
	String sheetName="Contacts";
	ContactsPageTest()
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
		homePage.clickContact();
		
	}
	
	@DataProvider	
	
	public Object[][] getData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	/*
	 * @Test
	 * 
	 * public void VerifyContactsButton() {
	 * Assert.assertTrue(contactPage.verifyFilterButton()); }
	 */
	
	@Test(dataProvider="getData")
	
	public void NewContactTest(String firstname,String lastname)
	{
		contactPage.NewContacts(firstname,lastname);
	}
}
