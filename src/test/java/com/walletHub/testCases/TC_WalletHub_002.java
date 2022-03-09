package com.walletHub.testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.walletHub.pageObjects.WalletHub;

public class TC_WalletHub_002 extends BaseClass {

	String review_description = randomestring(200);

	@Test
	public void writeReview() {
		
		logger.info("Starting WalletHub Test Case.");
		WalletHub wh = new WalletHub(driver);
		driver.get(wallethuburl);
		driver.manage().window().maximize();
		
		logger.info("Clicking on the Signin Link.");
		wh.click_on_link_signin();					// click on sign in link

		logger.info("Entering Username.");
		wh.enter_username(walletHubUser);			// enter username

		logger.info("Entering Password");
		wh.enter_password(wallethubPassword);		// enter password

		logger.info("Clicking on Login Button.");
		wh.clickOnLoginButton(); 					// click on login button
		
		explicitWaitUntilVisibilityofElement(wh.getFiveStar());
		
		logger.info("Scrolling Down ....!");
		wh.scrollDown();							// Scroll down

		logger.info("Horring over all the five stars.");
		wh.hover_stars();							// Hover over all the stars

		logger.info("Clicking on forth star.");
		wh.clickOnFourStar();						// Click on fourth star

		logger.info("Waiting for the Write review textbox to be visible.");
		explicitWaitUntilVisibilityofElement(wh.gettxtWriteReview()); 	// wait for Review text for to be visible

		logger.info("Select Health Insurance from Policy dropdown.");
		wh.selectValueFromPolicyDropdown();			// Select Health Insurance from policy Dropdown

		logger.info("Entering Review.");
		wh.enterTextinReview(review_description);	// enter review in Review textbox

		logger.info("Clicking on Submit button.");
		wh.clickOnSubmit();							// click on submit button
		
		explicitWaitUntilVisibilityofElement(wh.getSuccessText());
		
		logger.info("Asserting review get added successfully.");
		Assert.assertEquals(wh.getSuccessText().getText(), "Your review has been posted.");	// Verify review added is present on home page or not

		logger.info("Opening user profile.");
		driver.get(wallethubProfilUrl);				// Open Wallethub profile URL
		
		logger.info("Waiting for visibility of Updated review field.");
		explicitWaitUntilVisibilityofElement(wh.getUpdatedReviewFeed());
		
		logger.info("Asserting Updated review present in profile.");
		Assert.assertTrue(wh.getUpdatedReviewFeed().isDisplayed(), "Updated review feed(s) present on the profile.");

	}

}
