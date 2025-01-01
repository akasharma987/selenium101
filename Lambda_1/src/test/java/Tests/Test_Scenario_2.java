package Tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Test_Scenario_2  {
	
	
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
	public void DragandDrop() throws InterruptedException, MalformedURLException { 

   
        
      //implicit wait of 15 seconds
      		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
      		driver.manage().window().maximize();
      		
      	// Open the LambdaTest Drag & Drop Sliders page
            driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
            
            // Locate the slider with "Default value 15"
            WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
            WebElement sliderValue = driver.findElement(By.xpath("//output[@id='rangeSuccess']"));
            
         // 3. Drag the bar to make it 95

            Actions actions = new Actions(driver);
            actions.dragAndDropBy(slider, 212, 0).perform();
            Thread.sleep(2000);
            
            // 4. Validate whether the range value shows 95
            WebElement rangeValue = driver.findElement(By.xpath("//output[@id='rangeSuccess']"));
            String actualValue = rangeValue.getText();

            if (actualValue.equals("95")) {
                System.out.println("Test Passed: Slider value is set to 95");
            } else {
                System.out.println("Test Failed: Slider value is not set to 95. Actual value: " + actualValue);
            }
            
            driver.quit(); 
    } 
	
	
}
