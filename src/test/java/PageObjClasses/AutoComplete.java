package PageObjClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.base;

public class AutoComplete extends base {
	AccordianOptions acdnOptn = new AccordianOptions();

	@Test(priority = 0)
	public void clickOnAutoCompleteTab() {
		acdnOptn.clickOnWidgets();

		WebElement autoComplete = driver.findElement(By.xpath("//span[.='Auto Complete']"));
		scrollToElement(autoComplete);
		autoComplete.click();

	}

	@Test(priority = 1)
	public void enterTextInMultipleColornames() throws AWTException {

		List<String> colorsAdded = new ArrayList<String>();

		List<String> color = new ArrayList<String>();
		color.add("yellow");
		color.add("red");
		color.add("blue");
		WebElement multicolorTextBox = driver.findElement(By.xpath("//input[@id='autoCompleteMultipleInput']"));
		for (String eachcolor : color) {
			multicolorTextBox.sendKeys(eachcolor);

			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.textToBePresentInElementValue(multicolorTextBox, eachcolor));

			Robot actns = new Robot();
			actns.keyPress(KeyEvent.VK_ENTER);
			actns.keyRelease(KeyEvent.VK_ENTER);

			colorsAdded.add(eachcolor);

		}
		System.out.println("Colors entered in the textbox : " + colorsAdded);
		if (color.equals(colorsAdded)) {
			System.out.println("All the required colors were added successfully");
		} else {
			System.out.println("color/colors - missing");
		}
	}
}
