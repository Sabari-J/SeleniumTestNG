package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Base.base;

public class SelectMenu extends base {
	AccordianOptions acdnOptns = new AccordianOptions();

	@Test(priority = 0)
	public void selectMenuTab() {
		acdnOptns.clickOnWidgets();

		WebElement selectMenu = driver.findElement(By.xpath("//span[.='Select Menu']"));
		scrollToElement(selectMenu);
		selectMenu.click();
	}

	@Test(priority = 1)
	public void selectValueDropdown() {
		String dropDownValue = "Group 2, option 1";

		WebElement groupDropdown = driver.findElement(By.xpath("//div[@id='withOptGroup']"));
		groupDropdown.click();

		WebElement option = driver.findElement(By.xpath("//div[text()='" + dropDownValue + "']"));
		option.click();
	}

	@Test(priority = 2)
	public void selectOneDropDown() {
		String salutation = "Dr.";
		WebElement selectOneDropDown = driver.findElement(By.xpath("//div[@id='selectOne']"));
		selectOneDropDown.click();

		WebElement option = driver.findElement(By.xpath("//div[text()='" + salutation + "']"));
		option.click();
	}
}
