package com.maveric.pageobjects;

import java.util.List;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MavericLoginPage {
	
	@FindBy(css="#LoginForm_username")
	private WebElement userNameEle;
	
	@FindBy(name="LoginForm[password]")
	WebElement passEle;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement loginEle;
	
	@FindBy(how=How.ID,using="LoginForm_password_em_")
	WebElement errorTextEle;
	
	@FindBy(tagName="a")
	List<WebElement> linksEle;
	
	/*@FindAll(@FindBy(tagName="a"))
	List<WebElement> linksEle1;*/
	
	By invalidUserMsgLoc = By.id("LoginForm_password_em_");
	
	WebDriver driver;
	WebDriverWait wait;
	public MavericLoginPage(WebDriver driver,WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver, this);
		
	}	
	
	public void sendUserName(String userName)
	{
		userNameEle.sendKeys(userName);
	}
	
	public void sendPassword(String password)
	{
		passEle.sendKeys(password);	
	}
	public void clickOnLogin()
	{
		loginEle.click();
	}
	
	public String getInvalidErrorMessage()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidUserMsgLoc));
		String actualText=errorTextEle.getText();
		
		return actualText;
	}

	public int getNoOfLinks()
	{
		//List<WebElement> linksEle= driver.findElements(By.tagName("a"));
		int noOfLinks = linksEle.size();
		
		return noOfLinks;
	}









}
