package com.amazon.qa.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.RechargePage;

public class RechargePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	RechargePage recharge;
	
	public RechargePageTest() 
	{
		super();
	} 
	
	@BeforeMethod
	public void setUp() 
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("pwd"));
	}

	
	@Test(priority=1)
	public void rechargeMobile() throws InterruptedException,NullPointerException
	{
		homepage.clickonMobileRechargeLink();
		Thread.sleep(5000l);
		Set<String> handle= driver.getWindowHandles();
		 
		 Iterator<String> it=handle.iterator();
		 
		 String parentid=it.next();
		 System.out.println("Parentid"+parentid);
		 String childId=it.next();
		 System.out.println("Parentid"+childId);
		 driver.switchTo().window(childId);
		 Thread.sleep(4000l);
		 driver.findElement(By.name("phoneNumber")).sendKeys("9969354337");
		 driver.findElement(By.name("rechargePlan")).sendKeys("100");
		 driver.findElement(By.xpath("//button[@id='buyButtonNative']")).click();
		 //recharge.enterRechargeDetails();
		
	}
	
	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}
}
