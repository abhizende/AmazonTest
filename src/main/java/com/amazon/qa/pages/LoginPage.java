package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory- OR
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement LoginBtn;
	
	//Intializing the Page Objects:
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		continueBtn.click();
		password.sendKeys(pwd);
		LoginBtn.click();
		
		return new HomePage();
	}
	

}
