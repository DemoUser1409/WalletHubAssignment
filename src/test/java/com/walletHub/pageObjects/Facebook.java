package com.walletHub.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Facebook {

	
	WebDriver ldriver;
	
	public Facebook(WebDriver rdriver){
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(id = "email")
	@CacheLookup
	WebElement txtusername;
	
	@FindBy(xpath = "//*[@name='pass']")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath = "//*[@name='login']" )
	@CacheLookup
	WebElement btnloginbutton;
	
	@FindBy(xpath = "//div[@aria-label='Create a post']//*[contains(text(),'your mind')]")
	@CacheLookup
	WebElement btnStatus;
	
	@FindBy(xpath ="//span[contains(text(),'on your mind')]")
	@CacheLookup
	WebElement txtStatus;
	
	@FindBy(xpath = "//div[@aria-label='Post']")
	@CacheLookup
	WebElement btnPost;
	
	@FindBy(xpath = "//form[@method='POST']/div")
	@CacheLookup
	WebElement fbform;
	
	
	public void clickLoginButton() {
		
		btnloginbutton.click();
		
	}
	
	public void setUsername(String user)
	{
		txtusername.sendKeys(user);
	}
	
	public void setPassword(String password)
	{
		txtpassword.sendKeys(password);
	}
	
	public boolean isStatusDisplayed() {
		return btnStatus.isDisplayed();
	}
	
	public void clickPost() {
		btnPost.click();
	}
	
	public void enterStatus(String status)
	{
		txtStatus.sendKeys(status);
		
	}
	
	
	public void clickStatusbutton()
	{
		btnStatus.click();
	}
	
	public WebElement getStatus()
	{
		return txtStatus;
	}
	
	public void waitUntil()
	{
	
		WebDriverWait wait = new WebDriverWait(ldriver,30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'on your mind')]")));
	}
	

	
	public void fbformclickmethod() {
		fbform.click();
	}
	
	
}
