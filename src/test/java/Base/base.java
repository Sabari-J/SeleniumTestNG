package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	public static WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;;
	WebDriverWait wDrWait;

	public void elementToBevisible(WebElement elemnt) {
		WebDriverWait wDrWait = new WebDriverWait(driver, 5);
		wDrWait.until(ExpectedConditions.visibilityOf(elemnt));

	}

	public void elementToBeEnable(WebElement elemnt) {
		wDrWait = new WebDriverWait(driver, 10);
		wDrWait.until(ExpectedConditions.elementToBeClickable(elemnt));

	}

	public void scrollToElement(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public void clickUsingJsExecutor(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void highlightElement(WebElement elemnt) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;')", elemnt);
		// 'background: magenta; border: 2px solid red;'
	}

	public void enterTextInTxtBox(String ele, String txtData) {

		WebElement name = driver.findElement(By.xpath(ele));
		name.sendKeys(txtData);
	}

	public void enterTextUsingJSexecutor(WebElement ele, String txtData) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]", ele, txtData);

	}

	/*
	 * // @AfterTest public void tearDown() throws InterruptedException {
	 * Thread.sleep(2000); driver.close();
	 * 
	 * }
	 */
	
	@BeforeTest
	public void getDriver() {

		WebDriverManager.chromedriver().setup();
//		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		System.out.println("Browser launched Successfully");
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

	}
}
