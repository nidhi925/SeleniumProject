package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	  @FindBy(name="email")
	  WebElement username;

	  @FindBy(name="password")
	  WebElement password;
	  @FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	  WebElement signIn;
	  
	  public LoginPage()
	  
	  {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public String getTitle() {
		 return driver.getTitle();
		
		  
	  }
	  
	  public HomePage Login(String userId, String Pwd)
	  
	  {
		  username.sendKeys(userId);
		  password.sendKeys(Pwd);
		  signIn.click();
		  
		  return new HomePage();
	  }
	  
	

}
