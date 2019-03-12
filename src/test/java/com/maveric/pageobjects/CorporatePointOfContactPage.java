package com.maveric.pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorporatePointOfContactPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(linkText="Corporate")
	WebElement corporateEle;
	
	@FindBy(xpath="//*[text()='Point of Contact']")
	WebElement pointOfContactEle;
	
	@FindBy(xpath="//span[text()='Administration Contact']")
	WebElement adminstrationContactTab;
	
//	@FindBy(xpath="//table[@id='yw0-body-table']/tbody/tr")
//	List<WebElement> rowsAdminsEle;
	
	public CorporatePointOfContactPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver, this);
	}
	public List<String> getAdminstrationContactEmailIds()
	{
		Actions actions=new Actions(driver);
		
		/*actions.moveToElement(corporateEle).pause(Duration.ofSeconds(2))
		.moveToElement(pointOfContactEle).click().build().perform();*/
	
		actions.moveToElement(corporateEle).pause(Duration.ofSeconds(2))
		.build().perform();
		pointOfContactEle.click();
		adminstrationContactTab.click();
		
	/*	JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pointOfContactEle);*/
		
		adminstrationContactTab.click();
		
		List<String> listOfEmailIds= new ArrayList<String>();
		
		
		List<WebElement> rowsEle=driver.findElements(By.xpath("//table[@id='yw0-body-table']/tbody/tr"));
	
		for(int i =1;i<=rowsEle.size();i++)
		{
			WebElement emailEle= driver.findElement(By.xpath("//table[@id='yw0-body-table']/tbody/tr["+i+"]/td[5]"));
			String text = emailEle.getText();
			listOfEmailIds.add(text);
		}
		
		return listOfEmailIds;
		
	}

}
