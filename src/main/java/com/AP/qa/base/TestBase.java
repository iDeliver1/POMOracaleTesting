 package com.AP.qa.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.AP.qa.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	private WebDriver driver;
	String browserName = "chrome",url;
	
	@BeforeSuite
    public void beforeSuite() throws Throwable {
		
		String BrowserVersion = TestUtil.getBrowserVersion();	
		System.out.println("Browser Version- "+BrowserVersion);
		
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().version(BrowserVersion).setup();
			driver = new ChromeDriver(); 
		
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/com/AP/qa/driver/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		
		}

		initateURL();
	}

	
	public void initateURL() throws Throwable{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		}
	
	
    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

}
