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

public class Topic_06_Web_Element_Command {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		;
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserChrome/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.navigate().refresh();
	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@Test
	public void TC_01_Check_Element_isDispalyed() {
		WebElement emailTextBox = driver.findElement(By.id("mail"));
		if (emailTextBox.isDisplayed()) {
			emailTextBox.sendKeys("Omachi");
			System.out.println("Email Textbox is displayed");
		} else {
			System.out.println("Email TextBox is not displayed");

		}
		;

		WebElement ageRadioButton = driver.findElement(By.id("over_18"));
		if (ageRadioButton.isDisplayed()) {
			ageRadioButton.click();
			System.out.println("Age RadioButton is displayed");

		} else {
			System.out.println("Age RadioButton is not displayed");

		}
		WebElement eduTextArea = driver.findElement(By.id("edu"));
		if (eduTextArea.isDisplayed()) {
			eduTextArea.sendKeys("Omachi102");
			System.out.println("Education TextArea is displayed");

		} else {
			System.out.println("Education TextArea is not displayed");

		}

		WebElement user5 = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
		if (user5.isDisplayed()) {
			user5.sendKeys("Omachi102");
			System.out.println("User 5 is displayed");

		} else {
			System.out.println("User 5 is not displayed");

		}
	}

	@Test
	public void TC_02_Check_Element_isEnabled() {
		WebElement emailTextBox = driver.findElement(By.id("mail"));
		if (emailTextBox.isEnabled()) {
			emailTextBox.sendKeys("Omachi123");
			System.out.println("Email Textbox is enabled");
		} else {
			System.out.println("Email Textbox is disabled");

		}

		WebElement ageRadioButton = driver.findElement(By.id("over_18"));
		if (ageRadioButton.isEnabled()) {
			ageRadioButton.click();
			System.out.println("Age RadioButton is enable");

		} else {
			System.out.println("Age RadioButton is disabled");

		}
		WebElement eduTextArea = driver.findElement(By.id("edu"));
		if (eduTextArea.isEnabled()) {
			eduTextArea.sendKeys("Omachi");
			System.out.println("Education TextArea is enabled");
		} else {
			System.out.println("Education TextArea is disabled");
		}

		WebElement jobDropDownlist = driver.findElement(By.id("job1"));
		if (jobDropDownlist.isEnabled()) {
			jobDropDownlist.sendKeys("Manual Testing");
			System.out.println("Job Role 1 is enabled");
		} else {
			System.out.println("Job Role 1 is disabled");
		}

		WebElement interrextCheckbox = driver.findElement(By.id("design"));
		if (interrextCheckbox.isEnabled()) {
			interrextCheckbox.click();
			System.out.println("Interests is enabled");
		} else {
			System.out.println("Interests is disabled");
		}

		WebElement pwdTextbox = driver.findElement(By.id("password"));
		if (pwdTextbox.isEnabled()) {
			pwdTextbox.sendKeys("123456");
			System.out.println("Password Textbox is enabled");
		} else {
			System.out.println("Password Textbox is disabled");
		}

		WebElement ageRadiobuttondis = driver.findElement(By.id("radio-disabled"));
		if (ageRadiobuttondis.isEnabled()) {
			ageRadiobuttondis.click();
			System.out.println("Age Radiobutton is enaled");
		} else {
			System.out.println("Age Radiobutton is disabled");
		}
	}

	@Test
	public void TC_03_Check_Element_isSelected() {
		WebElement interrextCheckbox = driver.findElement(By.id("design"));
		if (interrextCheckbox.isSelected()) {
			interrextCheckbox.click();
			System.out.println("Interests is selected");
		} else {
			System.out.println("Interests is de-selected");
		}

		WebElement languageCheckbox = driver.findElement(By.id("java"));
		if (languageCheckbox.isSelected()) {
			languageCheckbox.click();
			System.out.println("Laguage Checkbox is selected");
		} else {
			System.out.println("Laguage Checkboxis de-selected");
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
