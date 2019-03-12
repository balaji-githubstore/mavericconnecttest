package com.maveric.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MavericPortalPage {
	By qmsLoc=By.linkText("QMS");
	public WebDriver driver;
	WebDriverWait wait;
	
	
	public MavericPortalPage(WebDriver driver,WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
	}


	public String waitForQMSDisplayAndGetTitle()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(qmsLoc));
		return this.driver.getTitle();
	}

}
