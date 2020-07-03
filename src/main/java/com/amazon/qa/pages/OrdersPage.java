package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class OrdersPage extends TestBase{

	//Page Factory- OR
	
		@FindBy(xpath="//div[@id='yourOrdersBannersContainer']/following-sibling::div[1]/div[1]/h1")
		WebElement orderTitle;
		
		
		//Intializing the Page Objects:
		public OrdersPage() 
		{
			PageFactory.initElements(driver, this);
		}
	
		public String verifyOrderTitle() 
		{
			return orderTitle.getText();
		}
	
	
	
}
