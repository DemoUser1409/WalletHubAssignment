package com.walletHub.testCases;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.walletHub.pageObjects.Facebook;

public class TC_FaceBook_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		
		try{
		
		// Opened Facebook URL.
		driver.get(facebookurl);		
		driver.manage().window().maximize();
		Facebook fb = new Facebook(driver);
		
		// Entered Username
		fb.setUsername(facebookUsername);  
		
		// entered password
		fb.setPassword(facebookPassword);
		
		// click on login button
		fb.clickLoginButton();
		
		Thread.sleep(120);
		
		if(fb.isStatusDisplayed()) {
			Assert.assertTrue(true, "Successfully Logged in into Facebook");
		}
		else
		{
			Assert.assertTrue(false, "Username or Password is incorrect.");
		}
		
		fb.clickStatusbutton();
		Thread.sleep(6000);
		fb.fbformclickmethod();
		fb.waitUntil();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement element = fb.getStatus();
		executor.executeScript("arguments[0].value='testuser'", element); 
		Thread.sleep(6000); 
		fb.enterStatus("Hello");
		Thread.sleep(240);
		//fb.clickPost();
		
		}
		catch(Exception e){
			
			System.out.println("Something went wrong!");
			
			captureScreen(driver, "Facebook");
		}
		
	}

	
	
	
	
}
