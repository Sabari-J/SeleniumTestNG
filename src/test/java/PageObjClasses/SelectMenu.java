package PageObjClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

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
		scrollToElement(groupDropdown);
		groupDropdown.click();

		WebElement option = driver.findElement(By.xpath("//div[text()='" + dropDownValue + "']"));
		option.click();
	}

	@Test(priority = 2)
	public void selectOneDropDown() {
		String salutation = "Prof.";
		WebElement selectOneDropDown = driver.findElement(By.xpath("//div[@id='selectOne']"));
		scrollToElement(selectOneDropDown);
		selectOneDropDown.click();

		WebElement option = driver.findElement(By.xpath("//div[text()='" + salutation + "']"));
		elementToBevisible(option);
		clickUsingJsExecutor(option);

	}

	@Test(priority = 3)
	public void selectOldStyle() {
		String colour = "Yellow";
		WebElement oldStyleMenu = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));

		Select selct = new Select(oldStyleMenu);
		selct.selectByVisibleText(colour);
	}

	@Test(priority = 4)
	public void clickMultiselectdropdown() throws AWTException {
		String color[] = { "Red", "Green", "Blue" };

		WebElement multiselectdropdown = driver
				.findElement(By.xpath("//p[.='Multiselect drop down']/following::div[@class=' css-2b097c-container']"));
		multiselectdropdown.click();

		for (String colour : color) {
			WebElement selectColor = driver.findElement(By.xpath("//div[text()='" + colour + "']"));

			selectColor.click();
		}

		WebElement multiselectTitle = driver.findElement(By.xpath("//p[.='Multiselect drop down']"));
		multiselectTitle.click();
		System.out.println("Selected the required options under - " + multiselectTitle.getText());
	}

	@Test(priority = 5)
	public void selectCars() throws AWTException {
		String[] carBrands = { "Saab", "Volvo", "Audi" };

		WebElement cars = driver.findElement(By.xpath("//select[@id='cars']"));
		Select slt = new Select(cars);
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		for (String car : carBrands) {
			slt.selectByVisibleText(car);
			System.out.println( car + " - Car has been selected");
		}
		rbt.keyRelease(KeyEvent.VK_CONTROL);
	}

}
