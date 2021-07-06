package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_05_Selenium_Xpath_Css {

	WebDriver driver;
	String name, emailAdd, pwd, phone;

	By nameTb = By.id("txtFirstname");
	By emailTb = By.id("txtEmail");
	By cEmailTb = By.id("txtCEmail");
	By pwdTb = By.id("txtPassword");
	By cPwdTb = By.id("txtCPassword");
	By phoneTb = By.id("txtPhone");
	By regButton = By.xpath("//form[@id='frmLogin']//button");

	By nameErrorMsg = By.id("txtFirstname-error");
	By emailErrorMsg = By.id("txtEmail-error");
	By cEmailErrorMsg = By.id("txtCEmail-error");
	By pwdErrorMsg = By.id("txtPassword-error");
	By cPwdErrorMsg = By.id("txtCPassword-error");
	By phoneErrorMsg = By.id("txtPhone-error");

	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.gecko.driver",projectPath +
//				"/browserDrivers/geckodriver");
//				driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserChrome/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		name = "Omachi";
		emailAdd = "Omachi@gmail.com";
		pwd = "123456";
		phone = "0987654321";

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");

	}

	@Test
	public void TC_01_Register_Empty_Data() {

		driver.findElement(regButton).click();
		Assert.assertEquals(driver.findElement(nameErrorMsg).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(emailErrorMsg).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(cEmailErrorMsg).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(pwdErrorMsg).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(cPwdErrorMsg).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(phoneErrorMsg).getText(), "Vui lòng nhập số điện thoại.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		driver.findElement(nameTb).sendKeys(name);
		driver.findElement(emailTb).sendKeys("123.123@1@23");
		driver.findElement(cEmailTb).sendKeys("123.123@1@23");
		driver.findElement(pwdTb).sendKeys(pwd);
		driver.findElement(cPwdTb).sendKeys(pwd);
		driver.findElement(phoneTb).sendKeys(phone);
		driver.findElement(regButton).click();
		Assert.assertTrue(driver.findElement(emailErrorMsg).isDisplayed());
		Assert.assertTrue(driver.findElement(cEmailErrorMsg).isDisplayed());
		
	}

	@Test
	public void TC_03_Regiter_Incorrect_Confirm_Email() {
		driver.findElement(nameTb).sendKeys(name);
		driver.findElement(emailTb).sendKeys(emailAdd);
		driver.findElement(cEmailTb).sendKeys("Omachi1111@gmail.com");
		driver.findElement(pwdTb).sendKeys(pwd);
		driver.findElement(cPwdTb).sendKeys(pwd);
		driver.findElement(phoneTb).sendKeys(phone);
		driver.findElement(regButton).click();
		Assert.assertTrue(driver.findElement(cEmailErrorMsg).isDisplayed());
	}

	@Test
	public void TC_04_Register_Pwd_Less_than6() {
		driver.findElement(nameTb).sendKeys(name);
		driver.findElement(emailTb).sendKeys(emailAdd);
		driver.findElement(cEmailTb).sendKeys(emailAdd);
		driver.findElement(pwdTb).sendKeys("123");
		driver.findElement(cPwdTb).sendKeys("123");
		driver.findElement(phoneTb).sendKeys(phone);
		driver.findElement(regButton).click();
		Assert.assertTrue(driver.findElement(pwdErrorMsg).isDisplayed());
		Assert.assertTrue(driver.findElement(cPwdErrorMsg).isDisplayed());
	
	}

	@Test
	public void TC_05_Register_Incorrect_Confirm_Pwd() {
		driver.findElement(nameTb).sendKeys(name);
		driver.findElement(emailTb).sendKeys(emailAdd);
		driver.findElement(cEmailTb).sendKeys(emailAdd);
		driver.findElement(pwdTb).sendKeys(pwd);
		driver.findElement(cPwdTb).sendKeys("123");
		driver.findElement(phoneTb).sendKeys(phone);
		driver.findElement(regButton).click();
		Assert.assertTrue(driver.findElement(cPwdErrorMsg).isDisplayed());
		
	}

	@Test
	public void TC_06_Register_Incorrect_Phone_Contain_Letter() {
		driver.findElement(nameTb).sendKeys(name);
		driver.findElement(emailTb).sendKeys(emailAdd);
		driver.findElement(cEmailTb).sendKeys(emailAdd);
		driver.findElement(pwdTb).sendKeys(pwd);
		driver.findElement(cPwdTb).sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(phoneTb).sendKeys("3e323");
		driver.findElement(regButton).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(phoneErrorMsg).isDisplayed());
	}

	@Test
	public void TC_07_Register_Phone_Over_11_letter() {
		driver.findElement(nameTb).sendKeys(name);
		driver.findElement(emailTb).sendKeys(emailAdd);
		driver.findElement(cEmailTb).sendKeys(emailAdd);
		driver.findElement(pwdTb).sendKeys(pwd);
		driver.findElement(cPwdTb).sendKeys(pwd);
		driver.findElement(phoneTb).sendKeys("0987655333333333");
		driver.findElement(regButton).click();
		Assert.assertTrue(driver.findElement(phoneErrorMsg).isDisplayed());
	}

	@Test
	public void TC_08_Register_Phone_Not_Head_Network() {
		driver.findElement(nameTb).sendKeys(name);
		driver.findElement(emailTb).sendKeys(emailAdd);
		driver.findElement(cEmailTb).sendKeys(emailAdd);
		driver.findElement(pwdTb).sendKeys(pwd);
		driver.findElement(cPwdTb).sendKeys(pwd);
		driver.findElement(phoneTb).sendKeys("1234567891");
		driver.findElement(regButton).click();
		Assert.assertTrue(driver.findElement(phoneErrorMsg).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
