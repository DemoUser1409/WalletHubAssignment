package com.walletHub.testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.walletHub.pageObjects.Facebook;

public class TC_FaceBook_001 extends BaseClass {

	@Test
	public void loginTest() throws  IOException {
		
		try{
		
		logger.info("Starting Facebook Test Case.");
		logger.info("Opening facebook URL.");
		driver.get(facebookurl);				// Open URL.
		driver.manage().window().maximize();	// Maximize browser
		Facebook fb = new Facebook(driver);	
		logger.info("Entering Facebook Username.");
		fb.setUsername(facebookUsername);  		// Enter Username for facebook
		logger.info("Entering Facebook Password.");
		fb.setPassword(facebookPassword);		// Enter password for Facebook
		logger.info("Clicking on Login button.");
		fb.clickLoginButton();					// click on login button
		explicitWaitUntilVisibilityofElement(fb.getStatusfield());	// wait for Visibility of Status field on DOM
		
		if(fb.getStatusfield().isDisplayed()) { 	
			logger.info("Successfully logged in into Facebook.");
			Assert.assertTrue(true, "Successfully Logged in into Facebook");
		}
		else
		{
			logger.info("Login is not Successful.");
			Assert.assertTrue(false, "Username or Password is incorrect.");
			captureScreen(driver, "Facebook");
		}
		
		logger.info("Clicking on Enter Status field.");
		fb.clickStatusbutton(); 				// Click on enter status field
		explicitWaitUntilVisibilityofElement(fb.getStatus());	//wait for visibility of status textbox
		logger.info("Entering Hello World Status.");
		fb.enterStatus("Hello World");								// enter status Hello World
		logger.info("Clicking on Post Status button.");
		fb.clickPost();												// click on Post button
		explicitWaitUntilinvisibilityOfElement(fb.getStatus());	// Wait for Invisibility of Status Textbox
		logger.info("Clicking on Self Profile link.");
		fb.clickOnSelfLink();										// click on Profile link (Self)
		explicitWaitUntilVisibilityofElement(fb.getPostedStatus()); // wait for visibility of Posted Status
		
		if(fb.getPostedStatus().isDisplayed()) {
			logger.info("Status posted successfully on user profile.");
			Assert.assertTrue(true, "Status 'Hello World' posted Successfully.");
		}
		else
		{
			logger.info("Status not posted on user profile.");
			Assert.assertTrue(false, "Status not posted.");
			captureScreen(driver, "FacebookStatus");
		}
		
		
		}
		catch(Exception e){
			System.out.println("Something went wrong!"+e);
			captureScreen(driver, "Facebook");
		}
		
	}

	
	
	
	
}
