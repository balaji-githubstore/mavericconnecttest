package com.maveric.test;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.maveric.initialization.LaunchActivities;
import com.maveric.pageobjects.CorporatePointOfContactPage;
import com.maveric.pageobjects.MavericLoginPage;
import com.maveric.pageobjects.MavericPortalPage;
import com.maveric.utilities.ExcelUtils;
import com.maveric.utilities.PropertiesHandler;

public class MavericConnectTest extends LaunchActivities {
	
	
	
	
	@Test(priority=1,groups="high")
	public void positiveCredentialCheck() throws IOException {
		
		System.out.println("test 123");
		/*String url=prop.getProperty("url");
		String userName=prop.getProperty("username");
		String password=prop.getProperty("password");
		String expectedTitle=prop.getProperty("expectedtitle");
		
		driver.get(url);
		*/
	/*	MavericLoginPage login=new MavericLoginPage(driver,wait);
		System.out.println(login);
		int noOfLinks = login.getNoOfLinks();
		System.out.println(noOfLinks);
		
		
		login.sendUserName(userName);
		login.sendPassword(password);
		login.clickOnLogin();
	
		MavericPortalPage portal=new MavericPortalPage(driver,wait);
		System.out.println(portal.driver);
		String actualTitle=portal.waitForQMSDisplayAndGetTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle,"Validation on positiveCredentialCheck");*/
	}
	
	
	

}









