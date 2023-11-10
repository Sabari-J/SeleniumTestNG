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

	@Test (priority =1)
	public void resizeInnerWindow() {
		
		WebElement innerWindow = driver.findElement(By.xpath("//div[contains(text(),'Resizable box')]/following-sibling::span[@class='react-resizable-handle react-resizable-handle-se']"));
		scrollupLittle(-350);
		elementToBevisible(innerWindow);
		
		Actions actns = new Actions(driver);
		actns.dragAndDropBy(innerWindow, 300, 250);
	}
}
