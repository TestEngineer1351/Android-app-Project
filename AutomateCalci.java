package appiumtesting;

import io.appium.java_client.android.AndroidDriver;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AutomateCalci {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AutomateCalci obj = new AutomateCalci();
		obj.launchCalci();
		

	}
	
	@Test
	public void launchCalci() throws InterruptedException, MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
    	caps.setCapability("automationName", "UiAutomator2");
    	caps.setCapability("deviceName", "Galaxy S21 FE 5G");
    	caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
    	caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
    	caps.setCapability("uiautomator2ServerLaunchTimeout", 60000);
    	
    	AndroidDriver driver = new AndroidDriver(
                new URL("http://localhost:4723"),
                caps    
        );

        System.out.println("✅ App launched successfully!");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
        
        System.out.println("🔗 Session ID: " + driver.getSessionId());


    
     Thread.sleep(10000);
     
     String pageSource = driver.getPageSource();
     System.out.println("📄 Page Source:");
     System.out.println(pageSource);
     
     Thread.sleep(5000);
     
     WebElement firstElement = driver.findElement(By.id("calc_keypad_btn_08"));
     firstElement.click();

}

}