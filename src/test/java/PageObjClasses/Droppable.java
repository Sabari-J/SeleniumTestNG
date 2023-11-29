package PageObjClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Base.base;

public class Droppable extends base {

	Sortable_Grid sort = new Sortable_Grid();

	@Test(priority = 0)
	public void clickOnDroppable() {
		sort.clickOnInteractions();
		WebElement DroppableTab = driver.findElement(By.xpath("//span[.='Droppable']"));
		scrollToElement(DroppableTab);
		DroppableTab.click();
	}
	
	@Test(priority=1)
	public void dragUnderSimpleTab() {
		
		WebElement drag_Simple = driver.findElement(By.xpath("//div[@id='draggable' and .='Drag me']"));
		WebElement droppedWindow_Simple = driver.findElement(By.xpath("//div[@id='simpleDropContainer']/child::div[.='Drop here']"));
		
		Actions actn = new Actions(driver);
		waitForSeconds(1);
		actn.dragAndDrop(drag_Simple, droppedWindow_Simple).perform();
		String droppedStatus = driver.findElement(By.id("droppable")).getText();
		System.out.println("Dropped the box successfully: " + droppedStatus);
	}
}
