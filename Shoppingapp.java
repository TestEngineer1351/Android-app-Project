package appiumtesting;

import io.appium.java_client.android.AndroidDriver;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;

public class Shoppingapp {
	
	
	
	
	public static void main(String args[]) throws Exception {
		
		ShoppingApp();
	}

    @Test
    public static void ShoppingApp() throws Exception {
//    	DesiredCapabilities caps = new DesiredCapabilities();
//    	caps.setCapability("platformName", "Android");
//    	caps.setCapability("deviceName", "emulator-5554");
//    	caps.setCapability("automationName", "UiAutomator2");
//    	caps.setCapability("app", "C:\\Users\\Sudeshna\\Desktop\\App\\General-Store.apk");
    	
    	
    	DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setCapability("platformName", "Android");
    	caps.setCapability("automationName", "UiAutomator2");
    	caps.setCapability("deviceName", "emulator-5554");
    	caps.setCapability("app", "C:\\Users\\Sudeshna\\Desktop\\App\\General-Store.apk");
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
     
     WebElement firstElement = driver.findElement(By.id("nameField"));
     firstElement.click();
     System.out.println("The search box got clicked");
     Thread.sleep(3000);
     firstElement.sendKeys("Rose");
     Thread.sleep(2000);
     driver.findElement(By.id("spinnerCountry")).click();
     Thread.sleep(3000);
     driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Antarctica\"]\r\n"
     		+ "")).click();
     Thread.sleep(3000);
     
     driver.findElement(By.id("radioFemale")).click(); 
     Thread.sleep(2000);
     driver.findElement(By.id("btnLetsShop")).click();
     System.out.println("User has clicked the let's shop button");
     Thread.sleep(3000);
     WebElement cartitem = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]\r\n"
     		+ ""));
     String rts = cartitem.getText();
     String firstName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\"Air Jordan 4 Retro\"]\r\n"
      		+ "")).getText();
     System.out.println("First Name: " + firstName);
     System.out.println("The text before item has been selected to cart : " +rts);
     cartitem.click();
     String str = cartitem.getText();
     System.out.println("The text after item has been selected to cart : " +str);
     Thread.sleep(2000);
     driver.findElement(By.id("appbar_btn_cart")).click();
     
     Thread.sleep(3000);
     
     
     String secondName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\"]\r\n"
     		+ "")).getText();
     System.out.println("Second Name: " + secondName);
     
     if (firstName.equals(secondName)) {
    	    System.out.println("✅ Both product names match!");
    	} else {
    	    System.out.println("❌ Product Names are different!");
    	}
     
     Thread.sleep(3000);
     driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_back\"]\r\n"
     		+ "")).click();
     
     
     
     
     
     
     Thread.sleep(60000);
     
     
        
        
    }
    
    
    
       
    
}
