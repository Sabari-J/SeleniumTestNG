package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Base.base;

public class Menu extends base {
	AccordianOptions acdnOptns = new AccordianOptions();

	@Test(priority = 0)
	public void clickOnMenuOption() {
		acdnOptns.clickOnWidgets();

		WebElement menu = driver.findElement(By.xpath("//span[.='Menu']"));
		scrollToElement(menu);
		menu.click();
	}

	@Test(priority = 1)
	public void selectTheMenu() {
		String subItem1 = "Sub Sub Item 1";
		String subItem2 = "Sub Sub Item 2";

		WebElement mainItem_2 = driver.findElement(By.xpath("//a[.='Main Item 2']"));

		Actions actns = new Actions(driver);

		elementToBevisible(mainItem_2);
		actns.moveToElement(mainItem_2).perform();
		highlightElement(mainItem_2);

		WebElement subSubList = driver.findElement(By.xpath("//a[.='SUB SUB LIST »']"));
		elementToBevisible(subSubList);
		actns.moveToElement(subSubList).perform();

		WebElement subSubItem = driver.findElement(By.xpath("//a[.='" + subItem2 + "']"));
		elementToBevisible(subSubItem);
		actns.moveToElement(subSubItem).perform();

		highlightElement(subSubItem);
		subSubItem.click();
		System.out.println("Clicked on the " + subSubItem.getText());
	}

}
