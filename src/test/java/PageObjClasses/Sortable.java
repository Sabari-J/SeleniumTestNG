package PageObjClasses;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.base;

public class Sortable extends base {

	@Test(priority = 0)
	public void clickOnInteractions() {
		WebElement interactionTab = driver.findElement(By.xpath("//div[.='Interactions']"));
		interactionTab.click();
	}

	@Test(priority = 1)
	public void clickOnSortable() {
		WebElement sortable = driver.findElement(By.xpath("//span[text()='Sortable']"));
		scrollToElement(sortable);
		sortable.click();
	}

	@Test(priority = 2)
	public void listSorting() throws AWTException {
		String[] sort = { "Three", "Five" };

		Actions actns = new Actions(driver);
		for (String listSorter : sort) {
			WebElement sortableElement = driver.findElement(By.xpath("//div[.='" + listSorter + "']"));
			WebElement firstItem = driver.findElement(By.xpath("//div[@class='list-group-item list-group-item-action'][1]"));
			scrollToElement(firstItem);
			waitForSeconds(1);
			actns.dragAndDrop(sortableElement, firstItem).perform();
			System.out.println("Placed the item: " + listSorter);
			
			/**  OR
			actns.clickAndHold(sortableElement).moveToElement(firstItem).release().perform();
			**/
		}
	}
}
