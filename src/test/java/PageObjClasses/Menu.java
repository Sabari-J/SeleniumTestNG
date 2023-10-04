package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

}
