package PageObjClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.base;

public class Alerts extends base {

	BrowserWindows BrwsrWindws = new BrowserWindows();
	Alert alert;

	@Test(priority = 0)
	public void clickOnAlerts() {

		BrwsrWindws.clickOnAlertFrameWindowsTab();
		WebElement alertOption = driver.findElement(By.xpath("//span[.='Alerts']"));
		alertOption.click();

	}

	@Test(priority = 1)
	public void clickOnFirstAlertButton() throws InterruptedException {
		WebElement alertButton1 = driver.findElement(By.xpath("//span[contains(text(),'alert')]/../..//div//button[@id='alertButton']"));
		alertButton1.click();

		Thread.sleep(3000);
		alert = driver.switchTo().alert();
		String alertMSG1 = alert.getText();
		alert.accept();
//		driver.switchTo().defaultContent();
		System.out.println("MSG: " + alertMSG1);
	}

	@Test(priority = 2)
	public void clickOnTimerAlertButton() throws InterruptedException {
		WebElement timerAlertButton = driver.findElement(By.xpath("//span[contains(.,' 5 seconds ')]/../..//div//button[@id='timerAlertButton']"));
		timerAlertButton.click();

		Thread.sleep(7000);
		alert = driver.switchTo().alert();
		String alertMSG2 = alert.getText();
		System.out.println("MSG: " + alertMSG2);
		alert.accept();

	}

	@Test(priority = 3)
	public void clickOnConfirmButton() {
		String option = "accept";

		WebElement confirmBoxButton = driver.findElement(By.xpath("//*[@id='confirmButton']"));
		confirmBoxButton.click();

		alert = driver.switchTo().alert();

		String alertMsg = alert.getText();
		System.out.println("Content in the Alert: " + alertMsg);

		if (option.equalsIgnoreCase("accept")) {
			alert.accept();
		} else if (option.equalsIgnoreCase("cancel")) {
			alert.dismiss();
		}

		String optionMessage = driver.findElement(By.xpath("//*[@id='confirmResult']")).getText();
		System.out.println(optionMessage);
	}

	@Test(priority = 4)
	public void clickOnPromtBox() {
		String name = "Sabari";
		WebElement promptButton = driver.findElement(By.id("promtButton"));
		promptButton.click();

		alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();

		String nameDetails = driver.findElement(By.xpath("//span[@id='promptResult']")).getText();
		System.out.println("The Name " + nameDetails);

	}

}
