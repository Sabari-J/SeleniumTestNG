package PageObjClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.base;

public class frames extends base {
	BrowserWindows brws = new BrowserWindows();

	@Test(priority = 0)
	public void clickOnFrames() {

		brws.clickOnAlertFrameWindowsTab();

		WebElement frames = driver.findElement(By.xpath("//span[.='Frames']"));
		frames.click();

		System.out.println("Clicked on Frames Tab");

	}

	@Test(priority = 1)
	public void frame1() {

		/* int countOfFrames = driver.findElements(By.tagName("iframe")).getSize() 
		 		(OR)
		 	the below snippet:  */

		List<WebElement> countOfFrames = driver.findElements(By.tagName("iframe"));
		int NocountOfFrames = countOfFrames.size();

		System.out.println("No of frames in this page: " + NocountOfFrames);

		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frame1);

		String parentFrame = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
		System.out.println("Content inside the frame1: \n" + parentFrame);

		driver.switchTo().defaultContent();
	}

	@Test(priority = 2)
	public void frame2() {
		
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame2);

		String childframe = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
		System.out.println("Content inside the frame2: " + childframe);

	}

}
