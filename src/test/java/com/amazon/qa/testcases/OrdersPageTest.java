package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.OrdersPage;

public class OrdersPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	OrdersPage orders;
	
	
	@BeforeMethod
	public void setUp() 
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("pwd"));
		orders=homepage.clickOnOrdersLink();
	}
	
	@Test(priority=1)
	public void verifyOrdersPage() 
	{
		Assert.assertEquals(orders.verifyOrderTitle(), "Your Orders 2");
	}

	
	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}
}
