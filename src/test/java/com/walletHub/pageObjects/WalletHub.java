package com.walletHub.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WalletHub {	

	WebDriver ldriver;
	
	public WalletHub(WebDriver rdriver){
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	String test = "23";
	
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
	
	@FindBy(xpath="(//h4[normalize-space()='Your review has been posted.']")
	@CacheLookup
	WebElement txt_success;
	
	

	public void hover_stars() {
		
		//Creating object of an Actions class
		Actions action = new Actions(ldriver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(one_star).perform();
		action.moveToElement(two_star).perform();
		action.moveToElement(three_star).perform();
		action.moveToElement(four_star).perform();
		action.moveToElement(five_star).perform();
	}
	
	public void clickOnFourStar() {
		four_star.click();
	}
	
	public void waitForElementToBeVisible() {
		// explicit wait condition
	      WebDriverWait w = new WebDriverWait(ldriver,3);
	      // presenceOfElementLocated condition
	      w.until(ExpectedConditions.visibilityOf(txtWriteReview));
	      // get text of element and print
	}
	
	public void enterTextinReview(String review) {
		txtWriteReview.sendKeys(review);
	}
	
	
	public void clickOnSubmit() {
		btnSubmit.click();
	}
	
	public void selectValueFromPolicyDropdown() {
		dropdownPolicy.click();
		dd_health_insurance.click();
		
	}
	
	public boolean isReviewPosted()
	{
	
		return txt_success.isDisplayed();
	}
	
	public String get_review_description() {
		return txt_review_description.getText();
	}
	
	public void click_on_link_signin() {
		link_signin.click();
	}
	
	public void enter_username(String username) {
		txt_email.sendKeys(username);
	}
	
	public void enter_password(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		btn_login.click();
	}
	
	
}
