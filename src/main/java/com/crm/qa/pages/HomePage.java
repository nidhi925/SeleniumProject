package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[contains (text(),'Nidhi Joshi')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains (text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//span[contains (text(),'Deals')]")
	WebElement DealsLink;
	
	
	
	
	HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String HomePageTitle()
	
	{
		
		return driver.getTitle();
		
	}

	
public boolean CorrectUserName()
	
	{
	return userNameLabel.isDisplayed();
		
		
	}

public ContactsPage clickContact()
	
	{
		
	ContactsLink.click();
	
	return new ContactsPage();
		
	}

	public DealsPage clickDeals()

	{
		DealsLink.click();
		return new DealsPage();
	}
	
public boolean verifyUsername()
    {
	return userNameLabel.isDisplayed();
	}
}
