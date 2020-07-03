package com.amazon.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//*[@id='nav-link-accountList']/div/span")
	@CacheLookup
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[@id='nav-orders']")
	WebElement ordersLink;
	
	@FindBy(xpath="//img[@alt='Mobile recharges']")
	WebElement mobilerecharge;
	
	@FindBy(xpath="//a[@class='nav-logo-link']")
	WebElement homeIcon;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(className="nav-input")
	WebElement searchBtn;
	
	
	//Intializing the Page Objects:
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomepageTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyUsername()
	{
		return usernameLabel.getText();
	}
	
	public OrdersPage clickOnOrdersLink() 
	{
		ordersLink.click();
		return new OrdersPage();
	}
	
	public RechargePage clickonMobileRechargeLink() throws InterruptedException 
	{
		homeIcon.click();
		Thread.sleep(3000);
		mobilerecharge.click();
		return new RechargePage();
	}
	
	public void searchProduct(String product)
	{
		searchBox.sendKeys(product);
		searchBtn.click();
		List<WebElement> list=driver.findElements(By.tagName("a"));
		int size=list.size();
		for(int i=0;i<size;i++) 
		{
			//if(list.get(i).getText().equalsIgnoreCase("Privacy Notice")) {
			System.out.println(list.get(i).getText());
			//list.get(i).click();
			//}
		}
	}
}
