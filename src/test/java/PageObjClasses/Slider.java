package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Base.base;

public class Slider extends base {
	AccordianOptions accOptns = new AccordianOptions();

	@Test(priority = 0)
	public void clickOnSlider() {
		accOptns.clickOnWidgets();
		WebElement sliderTab = driver.findElement(By.xpath("//span[.='Slider']"));
		scrollToElement(sliderTab);
		sliderTab.click();
	}

	@Test(priority = 1)
	public void moveTheSlider() {

		// ** Method - 1 **
		int targetValue = 93;
		WebElement sliderArrow = driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));
		Actions actns = new Actions(driver);
		actns.click(sliderArrow).build().perform();

		// The below code snippet can be used as a dynamic method
		int valueInSlider = Integer.parseInt(sliderArrow.getAttribute("value"));

		/** "Math.abs" --->It calculates the absolute value of a number. The absolute value is always positive.
		For example, the absolute value of -5 is 5, and the absolute value of +10 is 10. **/ 
		int steps = Math.abs(valueInSlider - targetValue);
		System.out.println(valueInSlider + "val");
		System.out.println(steps + " steps val");

		// Determine whether to move left or right
		Keys arrowKey = (valueInSlider > targetValue) ? Keys.ARROW_LEFT : Keys.ARROW_RIGHT;

		for (int i = 0; i < steps; i++) {
			actns.sendKeys(arrowKey).build().perform();

		}

		WebElement tooltip = driver.findElement(By.xpath("//div[@class='range-slider__tooltip__label']"));
		highlightElement(tooltip);
		String tooltipText = tooltip.getText();

		int noIntoolTip = Integer.parseInt(tooltipText);
		System.out.println("No in the ToolTip :" + noIntoolTip);

		if (noIntoolTip == targetValue) {
			WebElement valueTextBox = driver.findElement(By.xpath("//input[@id='sliderValue']"));
			highlightElement(valueTextBox);
			String valueInTextBox = valueTextBox.getAttribute("value");
			System.out.println("Value in Tooltip and TextBox are Matching: " + valueInTextBox);
		}

		 /** Method - 2 **
		 *JavascriptExecutor js = (JavascriptExecutor) driver; //
		 * js.executeScript("arguments[0].style.left = '70%'", sliderArrow);
		 
		 * // **Method - 3 ** 
		 * int width=sliderArrow.getSize().getWidth();
		 * actns.moveToElement(sliderArrow,((width*10)/100), 0).click(); 
		 * actns.build().perform();
		 
		 * // **Method - 4** 
		 * actns.dragAndDropBy(sliderArrow, 30, 0).click(); 
		 * actns.build().perform();
		 **/
	}

}
