package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	public static WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	WebDriverWait wDrWait;

	@BeforeTest
	public void getDriver() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--window-position=1920,0");

		WebDriverManager.chromedriver().setup();
//		WebDriverManager.chromedriver().clearDriverCache().setup();
//		driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		System.out.println("Browser launched Successfully");
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

	}

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

	public void scrollToTop(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
//		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public void scrollupLittle(int pixelvalue) {
		//to scroll up modify the pixel value of the second parameter to a negative value (-350) and to scroll down - positive(+ 350) .
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(o, " + pixelvalue + ")", "");
		
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
	
	public void waitForSeconds(int seconds) {
		long startTime = System.currentTimeMillis();
		long endTime = startTime + (seconds * 1000);

		while (startTime < endTime) {
			// Do nothing, just wait
			startTime = System.currentTimeMillis();
		}
	}

	public void hoverAndFetchToolTipText(String elementXpath, String tooltipTextXpath) {
		WebElement hoverButton = driver.findElement(By.xpath(elementXpath));
		scrollToElement(hoverButton);
		highlightElement(hoverButton);
		Actions actn = new Actions(driver);
		actn.moveToElement(hoverButton).perform();

		WebElement toolTipText = driver.findElement(By.xpath(tooltipTextXpath));
		elementToBevisible(toolTipText);
		String txt = toolTipText.getText();
		System.out.println("Text fetched from the ToolTip: " + txt);
	}

	/**
	 * @AfterTest public void tearDown() throws InterruptedException {
	 *            Thread.sleep(2000); driver.close(); }
	 **/
}
