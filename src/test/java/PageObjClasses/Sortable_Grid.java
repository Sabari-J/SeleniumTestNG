package PageObjClasses;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.base;

public class Sortable_Grid extends base {

	@Test(priority = 0)
	public void clickOnInteractions() {
		WebElement interactionTab = driver.findElement(By.xpath("//div[.='Interactions']"));
		scrollToElement(interactionTab);
		interactionTab.click();
	}

	@Test(priority = 1)
	public void clickOnSortable_Grid() {
		WebElement sortable = driver.findElement(By.xpath("//span[text()='Sortable']"));
		scrollToElement(sortable);
		sortable.click();

		WebElement grid = driver.findElement(By.xpath("//a[@id='demo-tab-grid']"));
		grid.click();
	}

	@Test(priority = 2)
	public void listSorting() throws AWTException {
		String[] sort = { "Three", "Six" };
		Actions actns = new Actions(driver);
		int scrollValue = -200;
		
		
		for (String gridSorter : sort) {
			WebElement sortableElement = driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']/following::div[.='" + gridSorter + "']"));
			WebElement firstItem = driver.findElement(By.xpath("//div[@class='create-grid']/child::div[1]"));
			scrollup_DownLittle(scrollValue);
			waitForSeconds(1);
			actns.dragAndDrop(sortableElement, firstItem).perform();
			System.out.println("Placed the item: " + gridSorter);

			/**
			 * OR
			 * actns.clickAndHold(sortableElement).moveToElement(firstItem).release().perform();
			 */
		}
	}
			 
}
