package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() 
	{
		super(); //super class constructor
	}
	
	@BeforeMethod
	public void setUp() 
	{
		initialization();
		loginpage=new LoginPage();                                                                    
	}
	
	
	@Test(priority=2)
	public void loginPageTitle() 
	{
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Amazon Sign In");
	}
	
	@Test(priority=1)
	public void loginTest() 
	{
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("pwd"));
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
	
	
}
