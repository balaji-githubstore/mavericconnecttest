package com.maveric.initialization;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.maveric.utilities.PropertiesHandler;

public class LaunchActivities {
	public WebDriver driver;
	public WebDriverWait wait;
	public Properties prop;
	
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser"})
	public void initialization(@Optional("ch") String browser) throws IOException
	{    	
		prop=PropertiesHandler.getPropertiesDetails("Utilities/data.properties");
		
//		driver = new ChromeDriver();
		System.out.println(browser);
		launchBrowser(browser);
		
		System.out.println(driver);
		wait =new WebDriverWait(driver, 50);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	
	
	public void launchBrowser(String browser)
	{
		switch (browser.toLowerCase()) {
		case "ch":
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver=new ChromeDriver();
			break;
		case "ff":
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
			driver=new FirefoxDriver();
			break;
		case "ie":
		case "internetexplorer":
			System.setProperty("webdriver.ie.driver", "Driver/IEdriverserver.exe");
			driver=new InternetExplorerDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver=new ChromeDriver();
			break;
		}
	}
	@AfterTest(alwaysRun=true)
	public void closeBrowser()
	{
		driver.quit();
	}


}
