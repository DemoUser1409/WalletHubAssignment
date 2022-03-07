package com.walletHub.testCases;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.walletHub.pageObjects.WalletHub;

public class TC_WalletHub_002 extends BaseClass {

	String review_description = randomestring();

	@Test

	public void login_test() {
		driver.get(wallethuburl);
		driver.manage().window().maximize();
		WalletHub wh = new WalletHub(driver);

		// click on sign in link
		wh.click_on_link_signin();

		// enter username
		wh.enter_username(walletHubUser);

		// enter password
		wh.enter_password(wallethubPassword);

		// click on login button
		wh.clickOnLoginButton();

	}

	@Test
	public void writeReview() {

		driver.get(wallethuburl);
		driver.manage().window().maximize();
		WalletHub wh = new WalletHub(driver);

		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		// Hover over all the stars
		wh.hover_stars();

		// Click on fourth star
		wh.clickOnFourStar();

		// wait for Review text for to be visible
		wh.waitForElementToBeVisible();

		// Select Health Insurance from policy Dropdown
		wh.selectValueFromPolicyDropdown();

		// enter review in Review textbox
		wh.enterTextinReview(review_description);

		// click on submit button
		wh.clickOnSubmit();

		// Verify review added is present on home page or not
		Assert.assertTrue(wh.isReviewPosted(), "Review is present on the screen.");

	}

	@Test
	public void verifyReview() {

		login_test();
		WalletHub wh = new WalletHub(driver);

		// Verify review added is present on home page or not
		Assert.assertTrue(wh.isReviewPosted(), "Review is present on the screen.");

		// Verify the entered review description.
		String actual_description = wh.get_review_description();

		// Assert added review equals to expected review.
		assertEquals(actual_description, review_description);

	}

}
