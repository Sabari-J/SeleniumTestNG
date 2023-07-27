package PageObjClasses;

import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.base;

public class BrowserWindows extends base {

	@Test(priority = 0)
	public void clickOnAlertFrameWindowsTab() {

		WebElement alertFrameWindowOption = driver
				.findElement(By.xpath("//*[contains(text(), 'Alerts, Frame & Windows')]"));
		scrollToElement(alertFrameWindowOption);
		alertFrameWindowOption.click();
		System.out.println("Clicked on Alerts, Frame & Windows");

	}

	@Test(priority = 1)
	public void clickOnBrowserWindows() {

		WebElement browserWindwOption = driver.findElement(By.xpath("//span[text()= 'Browser Windows']"));
		scrollToElement(browserWindwOption);
		browserWindwOption.click();
		System.out.println("Clicked-Browser Windows");

	}

	@Test(priority = 2)
	public void clickOnNewTab() {
		String motherWindow = driver.getWindowHandle();
		assert driver.getWindowHandles().size() == 1;

		WebElement newTabButton = driver.findElement(By.xpath("//button[@id='tabButton' and contains(.,'New Tab')]"));
		newTabButton.click();

		// WebDriverWait wait = new WebDriverWait(driver, 5);
		// wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		assert driver.getWindowHandles().size() == 2;

		// String newWindow = driver.getTitle();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String newWindow = jse.executeScript("return document.title").toString();
		System.out.println("We are in " + newWindow);

		Set<String> allWindows = driver.getWindowHandles();
		for (String currentWindow : allWindows) {
			if (!currentWindow.equals(motherWindow)) {
				driver.switchTo().window(currentWindow);
			}
		}

		String pageContent = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
		System.out.println("We have the below content in the current page \n\n" + pageContent + "\n");

		String titlebyJavascript = jse.executeScript("return document.title;").toString();
		System.out.println("Title of webpage by Javascript :" + titlebyJavascript);

		driver.close();
		driver.switchTo().window(motherWindow);

	}

	@Test(priority = 3)
	public void clickNewWindow() throws InterruptedException {

		WebElement newWindow = driver.findElement(By.xpath("//button[@id='windowButton']"));
		newWindow.click();

		String mainWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();
		for (String focalWindow : allWindows) {
			if (!focalWindow.equals(mainWindow)) {
				driver.switchTo().window(focalWindow);

			}

		}

		String pageContent = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
		System.out.println("We have the below content in the current page-2 \n\n" + pageContent + "\n");

		String pageTitle = driver.getTitle();
		System.out.println(" PT is " + pageTitle);

		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(mainWindow);

	}

	@Test(priority = 4)
	public static void clickNewWindowMsg() throws InterruptedException {

		WebElement newWindowsmsg = driver.findElement(By.id("messageWindowButton"));
		newWindowsmsg.click();

		String parentWindow = driver.getWindowHandle();

		Set<String> allWindws = driver.getWindowHandles();
		for (String focalWindow : allWindws) {
			if (!focalWindow.equals(parentWindow)) {
				driver.switchTo().window(focalWindow);
			}
		}

		// USED jsoup - jsoup is an open-source Java library designed to parse, extract
		// and manipulate data stored in HTML documents

		String htmlContent = "<html><head></head><body>Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.</body></html>";
		Document doc = Jsoup.parse(htmlContent);

		Element bodyElement = doc.body();
		String pageContent = bodyElement.text();

		System.out.println("The Webpage has the below content: \n" + pageContent);

		Thread.sleep(3000);
		driver.quit();
	}

}
