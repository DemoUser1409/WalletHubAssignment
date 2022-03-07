package com.walletHub.testCases;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.walletHub.utilities.ReadConfig;

public class BaseClass

{

	ReadConfig rc = new ReadConfig();

	public static WebDriver driver;
	public String facebookurl = rc.getFacebookUrl();
	public String facebookUsername = rc.getFacebookUser();
	public String facebookPassword = rc.getFacebookPass();
	public String wallethuburl = rc.getWallethubUrl();
	public String walletHubUser = rc.getWallethubUser();
	public String wallethubPassword = rc.getWallethubPass();

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		if (br.equals("chrome")) 
		{

			System.setProperty("webdriver.chrome.driver", rc.getChromeDriverPath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);

		} 
		
		else if (br.equals("safari")) 
		
		{
			// will update the code for safari here.
		} 
		
		else if (br.equals("ie")) {
			// will update the code for IE here.
		}

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileHandler.copy(source, target);
		System.out.println("Screenshot taken");

	}

	public String randomestring() {
		String generatedstring = UUID.randomUUID().toString();
		return (generatedstring);
	}

}
