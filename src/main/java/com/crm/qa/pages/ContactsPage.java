package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath ="//button[contains (text(),'Show Filters')]")
	WebElement ShowFiltersButton;
	
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement NewButton;
	
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement FirstName;
	
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement LastName;

	
	@FindBy(xpath="//button[contains(text(),'Save')] ")
	WebElement SaveButton;
			
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	public boolean verifyFilterButton()
	
	{
		return ShowFiltersButton.isDisplayed();
		
	}
	
	
public void NewContacts(String firstname, String lastname)
	
	{
	NewButton.click();
	FirstName.sendKeys(firstname);
	LastName.sendKeys(lastname);
	SaveButton.click();
		
	}
	
}
