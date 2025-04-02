package PageObjClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.base;

public class DatePicker_HYRTutorials extends base {

	@Test
	public void selectDateDetails() throws Exception{
		
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		String input = "06-Jun-2024";
		
		SimpleDateFormat targetDate = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			
			targetDate.setLenient(false); // =>checks the invalid dates(like feb 30) and throws exception
			Date parsedDate = targetDate.parse(input);			// => parse the input to java supported Date object (format)
			
			Calendar calen = Calendar.getInstance();
			calen.setTime(parsedDate); // => setting the input date details in calendar
			
			int inputDate = calen.get(Calendar.DAY_OF_MONTH);
			int inputMonth = calen.get(Calendar.MONTH);
			int inputYear = calen.get(Calendar.YEAR);
			
			WebElement datePicker = driver.findElement(By.id("second_date_picker"));
			datePicker.click();
			
			String actualMonthDate = driver.findElement(By.className("ui-datepicker-title")).getText();
			SimpleDateFormat actualDateDetails = new SimpleDateFormat("MMM yyyy"); // june 2025 ->Details showing/fetched in the calendar
			Date actualParsedDate = actualDateDetails.parse(actualMonthDate);
			calen.setTime(actualParsedDate); // => setting the current date details in calendar
			
			int actualMonth = calen.get(Calendar.MONTH);
			int actualYear = calen.get(Calendar.YEAR);
			
			while(inputMonth < actualMonth || inputYear < actualYear ) 
			// or => for future dates ===>	while(inputMonth > actualMonth || inputYear > actualYear ) 
			{
				
				WebElement preButton = driver.findElement(By.className("ui-datepicker-prev"));
				preButton.click();
				
				/*** OR ->	for future dates
				WebElement nextButton = driver.findElement(By.className("ui-datepicker-prev"));
				nextButton.click(); ***/
				
				
				 actualMonthDate = driver.findElement(By.className("ui-datepicker-title")).getText();
				 actualDateDetails = new SimpleDateFormat("MMM yyyy"); // june 2025 ->Details showing/fetched in the calendar
				 actualParsedDate = actualDateDetails.parse(actualMonthDate);
				 calen.setTime(actualParsedDate);
				
				 actualMonth = calen.get(Calendar.MONTH);
				 actualYear = calen.get(Calendar.YEAR);						
			}
			
			driver.findElement(By.xpath("//a[@class='ui-state-default' and contains(text( ), "+inputDate+")]")).click();
			
			
			
		} catch (ParseException e) {
			throw new Exception("Invalid date has been provided as Input");
		}
		
		
	}

}
