package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
	
//	@Test(priority = 1)
//	public void enterDate() throws InterruptedException {
//		String date = "11/24/1987";
//		WebElement selectDate = driver.findElement(By.xpath("//input[@id = 'datePickerMonthYearInput']"));
//		Thread.sleep(3000);
//		enterTextUsingJSexecutor(selectDate, date);
//
//		String updatedDate = selectDate.getAttribute("value");
//
//		System.out.println("Date grabbed from the date field: "  + updatedDate);
//		Assert.assertEquals(updatedDate, date);
//
//	}
	
	@Test(priority = 2)
	public void selectDate() {
		String date = "11/24/1987";

		WebElement calendarWindow = driver.findElement(By.xpath("//input[@id = 'datePickerMonthYearInput']"));
		calendarWindow.click();

		WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
		monthDropdown.click();
		String month = date.substring(0, 2);
		System.out.println("Extracted month is " + month);
		int mnth = Integer.parseInt(month);
		int mnthVal = (mnth - 1);

		String monthNo = String.valueOf(mnthVal);
		System.out.println("Adjusted month is " + monthNo);
		WebElement monthDetail = monthDropdown.findElement(By.xpath("//option[@value='" + monthNo + "']"));
		monthDetail.click();

		WebElement YearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
		String year = date.substring(6, 10);
		System.out.println("year is " + year);
		Select slt = new Select(YearDropdown);
		slt.selectByValue(year);

		String day = date.substring(3, 5);
		System.out.println("day is " + day);
		int desiredDay = Integer.parseInt(day);
		
		// The below details explains the( %03d ) in the below Xpath (dynamicXPath) 
		/* 
		 * % : This indicates that formatting is about to begin. 
		 * 0 : This is a flag that specifies that the value should be zero-padded. 
		 * 3 : This specifies the width of the formatted output. In this case, it's set to 3 characters. 
		 * d : This is the conversion specifier that indicates the argument should be treated as an integer.
		 */
		
		String dynamicXPath = String.format("//div[contains(@class, 'react-datepicker__day--%03d')]", desiredDay);
		
		WebElement datepickerMonth = driver.findElement(By.className("react-datepicker__month"));
		WebElement desiredDateElement = datepickerMonth.findElement(By.xpath(dynamicXPath));
		desiredDateElement.click();
		
		
		WebElement dateEntered = driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
		String FinalDate = dateEntered.getAttribute("value");
		
		Assert.assertEquals(date, FinalDate);
	}
	  
	 
}
