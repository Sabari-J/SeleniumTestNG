package PageObjClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.base;

public class ProgressBar extends base {
	AccordianOptions accrdOptns = new AccordianOptions();

	@Test(priority = 0)
	public void clickOnProgressBarTab() {
		accrdOptns.clickOnWidgets();
		WebElement progressBarTab = driver.findElement(By.xpath("//span[.='Progress Bar']"));
		scrollToElement(progressBarTab);
		progressBarTab.click();
	}

	@Test(priority = 1)
	public void verifyProgressBar() throws InterruptedException {

		String requiredPercentage = "19";
		WebElement startButton = driver.findElement(By.xpath("//button[@id='startStopButton']"));
		startButton.click();

		WebDriverWait wbdrvrWait = new WebDriverWait(driver, 10);

		WebElement progressBar = driver.findElement(By.xpath("//div[@class='progress-bar bg-info']"));
		scrollToTop(progressBar);

		wbdrvrWait.pollingEvery(Duration.ofMillis(1));
		wbdrvrWait.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", requiredPercentage));

		String progressbarValue = progressBar.getText();
		System.out.println(progressbarValue + " is the value With Percentage");

//		String noInProgressBar = progressbarValue.substring(0, progressbarValue.length() - 1);
		String noInProgressBar = progressbarValue.replace("%", "").trim();
		System.out.println("No showing in ProgressBar :" + noInProgressBar + "%");

		if (noInProgressBar.equals(requiredPercentage)) {
			startButton.click();
			System.out.println("Successfully Stopped at " + requiredPercentage + "%");

		}
	}
}
