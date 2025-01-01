package Tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Test_Scenario_1 {
	
	WebDriver driver;

	 @BeforeMethod
	    @Parameters({"browser", "version", "os"})
	    public void setUp(String browser, String version, String os) throws MalformedURLException {

	        
	        ChromeOptions browserOptions = new ChromeOptions();

			
			browserOptions.setCapability("browserName", browser);
			browserOptions.setCapability("browserVersion", version);
			browserOptions.setCapability("platformName", os);
			
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "akasharma961");
			ltOptions.put("accessKey", "R2MGFfwmPvmp992tAjXRQP0AlOAPyi7jQMlzm0WHLS4G3Yip40");
			ltOptions.put("visual", true);
			ltOptions.put("video", true);
			ltOptions.put("network", true);
			ltOptions.put("build", "Selenium_testing");
			ltOptions.put("project", "Selenium_testing");
			ltOptions.put("name", "Selenium_testing");
			ltOptions.put("networkThrottling", "Regular 4G");
			ltOptions.put("selenium_version", "4.0.0");
			ltOptions.put("w3c", true);
			browserOptions.setCapability("LT:Options", ltOptions);
					
			
			 driver=new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
	        
	         
	    }
	
	
	
	 @Test(priority = 1)
	public void validateMessage() throws InterruptedException, MalformedURLException { 
       
        
      //implicit wait of 15 seconds
      		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
      		driver.manage().window().maximize();
      		
      		 // Step 1: Open LambdaTest Playground 

            driver.get("https://www.lambdatest.com/selenium-playground"); 

      

            // Step 2: Click "Simple Form Demo" under Input Forms 

            driver.findElement(By.linkText("Simple Form Demo")).click(); 

      

            // Step 3: Validate URL contains "simple-form-demo" 

            String currentUrl = driver.getCurrentUrl(); 

            Assert.assertTrue(currentUrl.contains("simple-form-demo"), "URL does not contain 'simple-form-demo'"); 

      

            // Step 4-5: Enter message in the text box 

            driver.findElement(By.id("user-message")).sendKeys("Welcome to Lambda Test"); 

      

            // Step 6: Click "Get Checked Value" 

            driver.findElement(By.id("showInput")).click(); 

      

            // Step 7: Validate the displayed message 

            String displayedMessage = driver.findElement(By.id("message")).getText(); 

            Assert.assertEquals(displayedMessage, "Welcome to Lambda Test", "Displayed message does not match the input message");
      		
            Thread.sleep(2000);
	
            driver.quit(); 
            
	}	
}
