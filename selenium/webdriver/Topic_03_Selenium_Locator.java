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
public class Topic_03_Selenium_Locator {
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

		// Open Firefox Driver
		// driver = new FirefoxDriver();
		// Set timeout find element
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Open Application (Application under testing/ sys under testing)
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");

	}

	// public void TC_01_FindElement() {

	// Single element : webElement
	// WebElement loginButton = driver.findElement(By.className(""));
	// loginButton.click();
	// driver.findElement(By.className("")).getText();

	// findElement
	// By.xxx: with locator?
	// Action gì lên element đó: ex: click/ sendKey/ getText...

	// Multi element : listElement
	// List<WebElement> buttons = driver.findElements(By.className(""));
	// buttons.get
	// }
	@Test
	public void TC_02_ID() {
		// Selenium Locator
		driver.findElement(By.id("send2")).click();
		// verify error mess
		Assert.assertTrue(driver.findElement(By.id("advice-required-entry-email")).isDisplayed());

	}

	@Test
	public void TC_03_Class() {
		driver.navigate().refresh();
		driver.findElement(By.className("button")).click();
		// verify error mess
		Assert.assertTrue(driver.findElement(By.className("button")).isDisplayed());

	}
	/**
	 * TC_04_name
	 * Test case cover error input
	 */

	@Test
	public void TC_04_Name() {
		driver.navigate().refresh();
		driver.findElement(By.name("send")).click();
		// verify error mess
		Assert.assertTrue(driver.findElement(By.id("advice-required-entry-email")).isDisplayed());

	}

	@Test
	public void TC_05_TagName() {
		driver.navigate().refresh();
		List<WebElement> loginPageLinks = driver.findElements(By.tagName("a"));

		for (WebElement webElement : loginPageLinks) {
			System.out.println(webElement.getText() + "Omachi");

		}

	}

	@Test
	public void TC_06_LinkText() {
		driver.navigate().refresh();
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		// verify error mess
		Assert.assertTrue(driver.findElement(By.id("email_address")).isDisplayed());

	}

	@Test
	public void TC_07_PartialLinkText() {
		driver.navigate().refresh();
		driver.findElement(By.partialLinkText("Back to")).click();
		// verify error mess
		Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());

	}

	@Test
	public void TC_08_CSS() {
		driver.findElement(By.cssSelector("#email")).sendKeys("nthloan102@gmail.com");
		driver.findElement(By.cssSelector("input[name='login[password]']")).sendKeys("123456");

	}

	@Test
	public void TC_09_Xpath() {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nthloan102@gmail.com");

		driver.findElement(By.xpath("//label[contains(text(),'Password')]/following-sibling::div/input"))
				.sendKeys("123456");
	}

	@Test
	public void TC_10_Class() {
		driver.navigate().refresh();

		// verify error mess
		driver.findElement(By.className("validate-password")).sendKeys("123456");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
