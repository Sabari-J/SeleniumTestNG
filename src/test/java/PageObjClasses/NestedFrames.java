package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.base;

public class NestedFrames extends base {
	BrowserWindows brws = new BrowserWindows();

	@Test(priority = 0)
	public void clickOnNestedFrame() {
		brws.clickOnAlertFrameWindowsTab();

		WebElement nestedFrames = driver.findElement(By.xpath("//span[.='Nested Frames']"));
		nestedFrames.click();
	}

	@Test(priority = 1)
	public void OuterFramevalidation() {
		int size = driver.findElements(By.xpath("//iframe")).size();
		System.out.println("No of frames in this page: " + size);

		driver.switchTo().frame(0);
		String outerFrame = driver.findElement(By.tagName("body")).getText();
		System.out.println("Content in the outer frame is : " + outerFrame);

	}

	@Test(priority = 2)
	public void innerFrameValidation() {
		driver.switchTo().frame(0);

		String innerFrame = driver.findElement(By.tagName("body")).getText();
		System.out.println("Content in the inner frame is :" + innerFrame);
		
		// To come out of the child frame:
		/*
		 * driver.switchTo().parentFrame();
		 * OuterFramevalidation();
		 */
		
		//To come back to the Main Window:
		driver.switchTo().defaultContent();
		String mainWindowContent = driver.findElement(By.xpath("//div[@id='framesWrapper']/div[1]")).getText();
		System.out.println("Content in the Main Widow: \n " + mainWindowContent);
	}

}
