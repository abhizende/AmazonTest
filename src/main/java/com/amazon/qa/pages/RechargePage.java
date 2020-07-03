package com.amazon.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class RechargePage extends TestBase{

	@FindBy(id="mobileNumberTextInputId")
	WebElement MobNo;
	
	@FindBy(id="operatorAndCircleTextInputId")
	WebElement operatorField;
	
	@FindBy(xpath="//*[@id=\"operatorGroup\"]/div[4]/label/i")
	WebElement Network;
	
	@FindBy(xpath="//input[@type='radio' and @value='Maharashtra & Goa~MAHARASHTRA_GOA']")
	WebElement State;
	
	@FindBy(name="rechargePlan")
	WebElement RechargePlan;
	
	
	
	//Intializing the Page Objects:
	public RechargePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterRechargeDetails() throws InterruptedException 
	{
		
		MobNo.sendKeys("9869354337");
	/*	operatorField.click();
		driver.switchTo().frame("DAsis");
		Network.click();
		State.click();*/
		RechargePlan.sendKeys("100");
		
		
	}
		
	
	
}
