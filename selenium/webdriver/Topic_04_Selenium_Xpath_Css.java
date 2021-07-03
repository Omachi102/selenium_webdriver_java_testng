package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@Test
public class Topic_04_Selenium_Xpath_Css {
	// Khai bao object for selenium Webdriver
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.gecko.driver",projectPath +
//				"/browserDrivers/geckodriver");
//				driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", projectPath + "/browserChrome/chromedriver");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");

	}

	@Test
	public void TC_01_Login_Empty_Email_Password() {
		
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.name("login[password]")).sendKeys("");
		driver.findElement(By.id("send2")).click();
		Assert.assertTrue(driver.findElement(By.id("advice-required-entry-email")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.className("validation-advice")).isDisplayed());

	}

	@Test
	public void TC_02_Logic_Invalid_Email() {
		driver.navigate().refresh();
		driver.findElement(By.id("email")).sendKeys("omachi@12");
		driver.findElement(By.id("pass")).sendKeys("12345678");
		driver.findElement(By.id("send2")).click();
		Assert.assertTrue(driver.findElement(By.id("advice-validate-email-email")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.className("validation-advice")).isDisplayed());
	}


	@Test
	public void TC_03_Password_invalid() {
		driver.navigate().refresh();
		driver.findElement(By.id("email")).sendKeys("Omachi@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
		driver.findElement(By.id("send2")).click();
		Assert.assertTrue(driver.findElement(By.id("advice-validate-password-pass")).isDisplayed());

}

	@Test
	public void TC_04_Login_Incorrect_Email_Password() {
		driver.navigate().refresh();
		driver.findElement(By.id("email")).sendKeys("Omachi@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(),"Invalid login or password.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
