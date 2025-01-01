package Tests;

import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Test_Scenario_3 {

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
    public void Test_Scenario3() throws InterruptedException, SocketException, MalformedURLException
    {
        
        
      //implicit wait of 15 seconds
      		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
      		driver.manage().window().maximize();
		
		
    	driver.manage().deleteAllCookies();
    	driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
    	
    	
        
        WebElement submit = driver.findElement(By.cssSelector("#seleniumform > div.text-right.mt-20 > button")); 
        submit.click();
        WebElement Name = driver.findElement(By.id("name"));

        String pleasefilloutthisform = Name.getAttribute("required");
        Assert.assertTrue(true, pleasefilloutthisform);
        String errormsg = "Please fill out this field.";
        Assert.assertTrue(true, errormsg);
        Thread.sleep(5000);
       WebElement country = driver.findElement(By.xpath("//*[@id=\'seleniumform\']/div[3]/div[1]/select"));
       country.click();
       driver.findElement(By.cssSelector("#seleniumform > div:nth-child(3) > div.form-group.w-6\\/12.smtablet\\:w-full.pr-20.smtablet\\:pr-0 > select > option:nth-child(238)")).click();
       
       
       WebElement name = driver.findElement(By.xpath("//*[@id=\'name\']"));
       name.sendKeys("Test Lambda");
       Thread.sleep(1000);
       WebElement Email = driver.findElement(By.cssSelector("#inputEmail4")); 
       Email.sendKeys("TestData@gmail.com"); 
       Thread.sleep(1000);
       WebElement password = driver.findElement(By.id("inputPassword4")); 
       password.sendKeys("Test_Lamda#@123");
       Thread.sleep(1000);
       WebElement Company = driver.findElement(By.xpath("//*[@id=\'company\']"));
       Company.sendKeys("Test_Lamda pvt ltd.");
       Thread.sleep(1000);
       WebElement Website  = driver.findElement(By.cssSelector("#websitename")); 
       Website.sendKeys("www.Test_Lamda.com");
       Thread.sleep(1000);		
       WebElement City = driver.findElement(By.id("inputCity")); 
       City.sendKeys("Earth");
       Thread.sleep(1000);
       WebElement Address1 = driver.findElement(By.xpath("//*[@id=\'inputAddress1\']"));
       Address1.sendKeys("Earth_Air");
       Thread.sleep(1000);
       WebElement Address2 = driver.findElement(By.cssSelector("#inputAddress2")); 
       Address2.sendKeys("Earth Water");
       Thread.sleep(1000);
       WebElement state = driver.findElement(By.id("inputState"));
       state.sendKeys("Test_Lamda State");
       Thread.sleep(1000);
       WebElement Zipcode =  driver.findElement(By.xpath("//*[@id=\'inputZip\']"));
       Zipcode.sendKeys("111111");
       Thread.sleep(1000);
       
       submit.click();
       
       Thread.sleep(3000);
       String submit_msg = "Thanks for contacting us, we will get back to you shortly.";
       String actual_submit = driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
       
       Thread.sleep(3000);
       Assert.assertEquals(actual_submit, submit_msg);
       
      
       Thread.sleep(5000);
       driver.close();
	
       
       
	
    }
	
}
