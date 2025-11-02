package appiumtesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
    	UiAutomator2Options options = new UiAutomator2Options();
    	options.setPlatformName("Android");
    	options.setAutomationName("UiAutomator2");
    	options.setDeviceName("emulator-5554");
    	options.setApp("C:\\Users\\Sudeshna\\Desktop\\App\\General-Store.apk");
    	options.setAppPackage("com.androidsample.generalstore");
    	options.setAppActivity("com.androidsample.generalstore.MainActivity");
    	options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(120));
    	options.setUiautomator2ServerInstallTimeout(Duration.ofSeconds(120));
    	options.setAdbExecTimeout(Duration.ofSeconds(60));

    	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

      
        
        AndroidDriver driver = new AndroidDriver(
                new URL("http://localhost:4723"),
                options
                
                );
                
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

