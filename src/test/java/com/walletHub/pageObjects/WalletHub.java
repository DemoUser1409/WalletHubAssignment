package com.walletHub.pageObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WalletHub {	

	WebDriver ldriver;
	
	public WalletHub(WebDriver rdriver){
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath = "//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[name()='svg'][1]")
	@CacheLookup
	WebElement one_star;
	
	@FindBy(xpath = "//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[name()='svg'][2]")
	@CacheLookup
	WebElement two_star;
	
	@FindBy(xpath = "//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[name()='svg'][3]")
	@CacheLookup
	WebElement three_star;
	
	@FindBy(xpath = "//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[name()='svg'][4]")
	@CacheLookup
	WebElement four_star;
	
	@FindBy(xpath = "//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[name()='svg'][5]")
	@CacheLookup
	WebElement five_star;
	
	@FindBy(xpath="//span[normalize-space()='Select...']")
	@CacheLookup
	WebElement dropdownPolicy;
	
	@FindBy(xpath="//textarea[@placeholder='Write your review...']")
	@CacheLookup
	WebElement txtWriteReview;
	
	@FindBy(xpath="//div[normalize-space()='Submit']")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(xpath="//*[@class='dropdown-item' and text()='Health Insurance']")
	@CacheLookup
	WebElement dd_health_insurance;
	
	@FindBy(xpath="//span[@class='rvtab-ci-name' and text()=' Your Review']")
	@CacheLookup
	WebElement txt_self_review;
	
	@FindBy(xpath="//div[@itemprop='description']")
	@CacheLookup
	WebElement txt_review_description;
	
	@FindBy(xpath="//span[normalize-space()='Login']")
	@CacheLookup
	WebElement link_signin;
	
	@FindBy(xpath="//input[@id='email']")
	@CacheLookup
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='password']")
	@CacheLookup
	WebElement txt_password;
	
	@FindBy(xpath="(//button[@class='btn blue center reg-tabs-bt touch-element-cl'])")
	@CacheLookup
	WebElement btn_login;
	
	@FindBy(xpath="//*[@id='scroller']//div[@class='rvc-header']//h4")
	@CacheLookup
	WebElement txt_success;
	
	@FindBy(xpath="//*[@class='pr-rec-type' and text()='Insurance Company']")
	@CacheLookup
	WebElement UpdatedReviewFeed;
	
	/**
	 * This method hover over all the stars.
	 */
	public void hover_stars() {
		Actions action = new Actions(ldriver);		//Creating object of an Actions class
		action.moveToElement(one_star).perform();	//Performing the mouse hover action on the target element.
		action.moveToElement(two_star).perform();
		action.moveToElement(three_star).perform();
		action.moveToElement(four_star).perform();
		action.moveToElement(five_star).perform();
	}
	
	/**
	 * This method is click on the fourth star.
	 * @return : None
	 */
	public void clickOnFourStar() {
		four_star.click();
	}
	
	/**
	 * This method returns the Webelement for Write review textbox.
	 * @return : WebElement
	 */
	public WebElement gettxtWriteReview() {
		return txtWriteReview;
	}
	
	/**
	 * This method returns the Webelement for Fifth Star.
	 * @return : WebElement
	 */
	public WebElement getFiveStar() {
		return five_star;
	}
	
	/**
	 * This methos write the review on the Review textbox.
	 * @param review : Review that needs to be entered.
	 */
	public void enterTextinReview(String review) {
		txtWriteReview.sendKeys(review);
	}
	
	/**
	 * This method is use to click on the Submit button.
	 */
	public void clickOnSubmit() {
		btnSubmit.click();
	}
	
	/**
	 * This method is used to select Health Insurance from the Policy dropdown.
	 */
	public void selectValueFromPolicyDropdown() {
		dropdownPolicy.click();
		dd_health_insurance.click();
		
	}
	
	/**
	 * This method is use to get the text after successfully submitting the review.
	 * @return : Return the Webelement for Success text.
	 */
	public WebElement getSuccessText() {
		return txt_success;
	}
	
	/**
	 * This method is use to get the Review description.
	 * @return : Review text
	 */
	public String get_review_description() {
		return txt_review_description.getText();
	}
	
	/**
	 * This method is use to click on the sign-in link.
	 */
	public void click_on_link_signin() {
		link_signin.click();
	}
	
	/**
	 * This method is use to input the username in Username field.
	 * @param username : WalletHub Username
	 */
	public void enter_username(String username) {
		txt_email.sendKeys(username);
	}
	
	/**
	 * This method is use to input the Password.
	 * @param password : WalletHub Password
	 */
	public void enter_password(String password) {
		txt_password.sendKeys(password);
	}
	
	/**
	 * This method is use to click on the login button.
	 */
	public void clickOnLoginButton() {
		btn_login.click();
	}
	
	/**
	 * This method is use to get the Webelement for get updated review feed.
	 * @return : WebElement
	 */
	public WebElement getUpdatedReviewFeed() {
		return UpdatedReviewFeed;
	}
	
	/**
	 * This method is use for Scrolling down.
	 */
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,250)", "");
	}
	
}
