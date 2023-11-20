package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import Base.base;

public class Resizable extends base {
	Sortable_List sortList = new Sortable_List();

	@Test(priority = 0)
	public void clickOnResizable() {
		sortList.clickOnInteractions();

		WebElement resizableTab = driver.findElement(By.xpath("//span[.='Resizable']"));
		scrollToElement(resizableTab);
		resizableTab.click();
	}

	@Test(priority = 1)
	public void resizeInnerWindow() {
		WebElement innerWindow = driver.findElement(By.xpath("//div[contains(text(),'Resizable box')]/following-sibling::span[contains(@class, 'handle-se')]"));
		scrollup_DownLittle(-350);
		elementToBevisible(innerWindow);
//		actns.clickAndHold(innerWindow).moveByOffset(100, 80).perform();
		Actions actns = new Actions(driver);
		actns.dragAndDropBy(innerWindow, 100, 70).perform();
		System.out.println("resized the inner box successfully");
	}

	@Test(priority = 2)
	public void resizeWindow() {
		WebElement resizableWindow = driver.findElement(By.xpath("//div[@id='resizable']//span[contains(@class, 'handle-se')]"));

		scrollup_DownLittle(200);
		Actions actns = new Actions(driver);
		actns.dragAndDropBy(resizableWindow, 120, 100).perform();
		System.out.println("resized the entire window successfully");
	}
}
