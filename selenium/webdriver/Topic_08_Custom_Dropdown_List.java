package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_08_Custom_Dropdown_List {

	WebDriver driver;
	WebDriverWait expliciWait;
	JavascriptExecutor jsExecutor;
	
	String projectPath = System.getProperty("user.dir");
	

	@BeforeClass
	public void beforeClass() {
		;
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserChrome/chromedriver");
		driver = new ChromeDriver();
		expliciWait = new WebDriverWait(driver, 5);
		jsExecutor= (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	
	public void TC_01_JQuery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		 By parent = By.id("number-button");
		 By child = By.cssSelector("ul#number-menu div");
		selectItemInDropdownList(parent, child, "7");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text() ='7']")));
		selectItemInDropdownList(parent, child, "16");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text() ='16']")));
		selectItemInDropdownList(parent, child, "8");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text() ='8']")));
		selectItemInDropdownList(parent, child, "9");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text() ='9']")));
  	}
	
	
	public void TC_02_ReactJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		 By parent = By.cssSelector("i.dropdown.icon");
		 By child = By.cssSelector("div[role ='option']>span");
		selectItemInDropdownList(parent, child, "Christian");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(By.xpath("//div[@role='alert' and text() = 'Christian']")));
		selectItemInDropdownList(parent, child, "Jenny Hess");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(By.xpath("//div[@role='alert' and text() = 'Jenny Hess']")));
		selectItemInDropdownList(parent, child, "Elliot Fu");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(By.xpath("//div[@role='alert' and text() = 'Elliot Fu']")));
	}
	@Test
	public void TC_03_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		 By parent = By.cssSelector("li.dropdown-toggle");
		 By child = By.cssSelector("ul.dropdown-menu a");
		selectItemInDropdownList(parent, child, "First Option");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(By.xpath("//li[@class ='dropdown-toggle' and contains(text(),'First Option')]")));
		selectItemInDropdownList(parent, child, "Second Option");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(By.xpath("//li[@class ='dropdown-toggle' and contains(text(),'econd Option')]")));
		selectItemInDropdownList(parent, child, "Third Option");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(By.xpath("//li[@class ='dropdown-toggle' and contains(text(),'Third Option')]")));
	}
	
	
	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void selectItemInDropdownList (By parentBy, By childBy, String ExpectedTextItem) {
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(parentBy));
		driver.findElement(parentBy).click();
		List<WebElement> allItems = driver.findElements(childBy);
		System.out.println("All items =" + allItems.size());
        for (WebElement item:  allItems) {
			if (item.getText().equals(ExpectedTextItem)) {
				if(item.isDisplayed()) {
					item.click();	
					}
				else {
					jsExecutor.executeScript("argument[0].scrollIntoView(true);", item);
					sleepInSecond(2);
					item.click();
				}
				
			}
		}
		
	}
	
	public boolean isElementDisplayed(By by) {
		WebElement element = driver.findElement(by);
		if (element.isDisplayed()) {
			System.out.println("Element + [by] is Displayed ");
			return true;
		}
		    System.out.println("Element + [by] is  not Displayed ");
		return false;
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
