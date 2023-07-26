package PageObjClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.base;

public class brokenImagesLinks extends base {

	Elements ele = new Elements();

	String tempInput = "Valid Link"; // Broken Link

	@Test
	public void brokenElements() throws InterruptedException {

		ele.clickOnElements();

		WebElement brokenLinksImgsTab = driver
				.findElement(By.xpath("//span[@class='text'  and .='Broken Links - Images']"));
		brokenLinksImgsTab.click();

		List<WebElement> broken = driver.findElements(By.xpath("//img/..//p"));
		for (WebElement allElements : broken) {
			String s = allElements.getText();
			System.out.println("Name of image: " + s);

			if (tempInput.equalsIgnoreCase("Valid Link") && s.equalsIgnoreCase("Valid Link")) {
				WebElement validLink = driver.findElement(By.xpath("//a[.='Click Here for Valid Link']"));
				validLink.click();
				System.out.println("Clicked on - Valid Link");

				String pageTitle = driver.getTitle();
				Assert.assertEquals(pageTitle, "ToolsQA");
				break;
			}

			if (tempInput.equalsIgnoreCase("Broken Link") && s.equalsIgnoreCase("Broken Link")) {
				WebElement brokenLink = driver.findElement(By.xpath("//a[.='Click Here for Broken Link']"));
				brokenLink.click();
				System.out.println("Clicked on - Broken Link");

				String pageTitle = driver.getTitle();
				Assert.assertEquals(pageTitle, "The Internet");
			}

		}

		System.out.println("No of images " + broken.size());

	}

}
