package com.walletHub.testCases;

import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.walletHub.utilities.ReadConfig;

public class BaseClass

{

	ReadConfig rc = new ReadConfig();

	public static WebDriver driver;
	public static Logger logger;
	public String facebookurl = rc.getFacebookUrl();
	public String facebookUsername = rc.getFacebookUser();
	public String facebookPassword = rc.getFacebookPass();
	public String wallethuburl = rc.getWallethubUrl();
	public String walletHubUser = rc.getWallethubUser();
	public String wallethubPassword = rc.getWallethubPass();
	public String wallethubProfilUrl = rc.getWallethubProfileUrl();

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) 
		{

			System.setProperty("webdriver.chrome.driver", rc.getChromeDriverPath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);

		} 
		
		else if (br.equals("firefox")) 
		
		{
			
			System.setProperty("webdriver.gecko.driver",rc.getFirefoxDriverPath());
			driver = new FirefoxDriver();
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

	public String randomestring(int n) {
		// chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
	}
	
	public void explicitWaitUntilVisibilityofElement(WebElement webelement) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(webelement));
	}
	
	public void explicitWaitUntilinvisibilityOfElement(WebElement webelement) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(webelement));
	}

}
