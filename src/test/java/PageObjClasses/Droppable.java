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

	@Test(priority = 1)
	public void dragUnderSimpleTab() {

		WebElement drag_Simple = driver.findElement(By.xpath("//div[@id='draggable' and .='Drag me']"));
		WebElement droppedWindow_Simple = driver
				.findElement(By.xpath("//div[@id='simpleDropContainer']/child::div[.='Drop here']"));
		dragAndDropElement(drag_Simple, droppedWindow_Simple);

		String droppedStatus = driver.findElement(By.id("droppable")).getText();
		waitForSeconds(2);
		System.out.println("Dropped the box successfully: " + droppedStatus);
	}

	@Test(priority = 2)
	public void acceptOptions() {
		WebElement acceptTab = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept' and .='Accept']"));
		acceptTab.click();
		System.out.println("Successfully clicked on Accept Tab");
		
//		String option = "acceptable";
		String option = "notacceptable";
		WebElement dropHereBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//child::p[.='Drop here']"));
		if (option.equalsIgnoreCase("Acceptable")) {
			WebElement optionToDrop = driver.findElement(By.id("acceptable"));
			dragAndDropElement(optionToDrop, dropHereBox);
			waitForSeconds(2);
			System.out.println("Dropped the option successfully: " + optionToDrop.getText());

		} else if (option.equalsIgnoreCase("NotAcceptable")) {
			WebElement optionToDrop = driver.findElement(By.id("notAcceptable"));
			dragAndDropElement(optionToDrop, dropHereBox);
			waitForSeconds(2);
			System.out.println("Dropped the option successfully: " + optionToDrop.getText());
		}
	}
	
	@Test(priority = 3)
	public void preventPropogationOptions() {
		WebElement preventPropogation = driver.findElement(By.xpath("//a[@id='droppableExample-tab-preventPropogation' and .='Prevent Propogation']"));
		preventPropogation.click();
		System.out.println("Successfully clicked on prevent Propogation Tab");
		
		WebElement dragMeBox = driver.findElement(By.xpath("//div[@id='ppDropContainer']//child::div[@id='dragBox']"));
		
		//notGreedyDropBox
		WebElement outerDroppableBox = driver.findElement(By.xpath("//div[@id='notGreedyDropBox']//child::p[.='Outer droppable']"));
		
		
		//GreedyDropBox
		WebElement outerDroppableBox2 = driver.findElement(By.xpath("//div[@id='greedyDropBox']//child::p[.='Outer droppable']"));
		
		dragAndDropElement(dragMeBox, outerDroppableBox2);
		
		
		
	}
	
	
}
