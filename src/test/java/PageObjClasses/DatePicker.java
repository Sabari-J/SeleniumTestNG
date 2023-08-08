package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.base;

public class DatePicker extends base {

	AccordianOptions acdnOptns = new AccordianOptions();

	@Test(priority = 0)
	public void clickOnDatePicker() {
		acdnOptns.clickOnWidgets();

		WebElement datePicker = driver.findElement(By.xpath("//span[.='Date Picker']"));
		scrollToElement(datePicker);
		datePicker.click();

	}

}
