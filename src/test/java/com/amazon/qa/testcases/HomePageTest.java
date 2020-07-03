package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.OrdersPage;
import com.amazon.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	OrdersPage orders;
	
	String sheetName = "Products";
	
	public HomePageTest() 
	{
		super();
	} 
	
	//Test cases should be independent with each other
	//before each test case launch the browser and login
	//@test- execute the test case
	//after each test case-- close the browser
	
	@BeforeMethod
	public void setUp() 
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("pwd"));
	}
	
	@Test(priority=1)
	public void verifyhomePageTitleTest() 
	{
		String homeTitle=homepage.verifyHomepageTitle();
		Assert.assertEquals(homeTitle, "Your Amazon.in","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyCorrectUsername()
	{
		String username=homepage.verifyUsername();
		Assert.assertEquals(username, "Hello, Abhishek","Username not matched");
	}
	
	@Test(priority=3)
	public void verifyOrdersLink()
	{
		orders=homepage.clickOnOrdersLink();
	}
	
	@DataProvider
	public Object[][] amazonTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4,dataProvider="amazonTestData")
	public void productSearch(String Product)
	{
		homepage.searchProduct(Product);
	}
	
	
	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}
}
