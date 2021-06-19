package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Topic2_demo_connect {
  
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		//System.setProperty("webdriver.gecko.driver",projectPath + "/browserDrivers/geckodriver");
		//driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver",projectPath + "/browserChrome/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
	}
}
