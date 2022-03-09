package com.walletHub.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	@FindBy(xpath ="//*[@class='_5rpb']/div")
	@CacheLookup
	WebElement txtStatus;
	
	@FindBy(xpath = "//div[@aria-label='Post']")
	@CacheLookup
	WebElement btnPost;
	
	@FindBy(xpath = "//*[@href='/me/']")
	@CacheLookup
	WebElement linkme;
	
	@FindBy(xpath = "//*[contains(text(),'Hello World')]")
	@CacheLookup
	WebElement postedStatus;
	
	/**
	 * This method is use to click on the login button.
	 */
	public void clickLoginButton() 
	{
		btnloginbutton.click();
	}
	
	/**
	 * This method is use to enter the Username.
	 * @param user
	 */
	public void setUsername(String user)
	{
		txtusername.clear();
		txtusername.sendKeys(user);
	}
	
	/**
	 * This method is use to enter the Password.
	 * @param password
	 */
	public void setPassword(String password)
	{
		txtpassword.clear();
		txtpassword.sendKeys(password);
	}
	
	/**
	 * This method is use to click on the Post button.
	 */
	public void clickPost() 
	{
		btnPost.click();
	}
	
	/**
	 * This method is use to enter the Facebook Status.
	 * @param status : Facebook Status
	 */
	public void enterStatus(String status) 
	{
		txtStatus.sendKeys(status);		    
	}
	
	/**
	 * This method is use to click on the Post Status field.
	 */
	public void clickStatusbutton()
	{
		btnStatus.click();
	}
	
	/**
	 * This method is use to get the Status WebElement.
	 * @return
	 */
	public WebElement getStatus()
	{
		return txtStatus;
	}
	
	/**
	 * This method returns the post status field.
	 * @return
	 */
	public WebElement getStatusfield() 
	{
		return btnStatus;
	}
	
	/**
	 * This method click on the Self Profile link.
	 */
	public void clickOnSelfLink() 
	{
		linkme.click();
	}
	
	/**
	 * This method returns the Status posted webelement.
	 * @return
	 */
	public WebElement getPostedStatus()
	{
		return postedStatus;
	}
	
	
}
