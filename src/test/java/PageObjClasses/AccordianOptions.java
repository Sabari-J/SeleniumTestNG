package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.base;

public class AccordianOptions extends base {

	@Test(priority = 0)
	public void clickOnWidgets() {
		WebElement widgetsOption = driver.findElement(By.xpath("//div[.='Widgets']"));
		widgetsOption.click();
	}

	@Test(priority = 1)
	public void clickOnAccordianOptions() {
		WebElement accordianOptions = driver.findElement(By.xpath("//span[.='Accordian']"));
		scrollToElement(accordianOptions);
		accordianOptions.click();
	}

	@Test(priority = 2)
	public void clickOnAccordianOption1() throws InterruptedException {

		WebElement section1Content = driver.findElement(By.xpath("//div[@id='section1Content']"));

		if (section1Content.isDisplayed() == true) {
			WebElement accordianOption1 = driver.findElement(By.xpath("//*[@id='section1Heading']"));
			highlightElement(accordianOption1);
			Thread.sleep(3000);
			accordianOption1.click();
		}

	}

	@Test(priority = 3)
	public void clickOnAccordianOption2() throws InterruptedException {
		WebElement section2Content = driver.findElement(By.xpath("//div[@id='section2Content']"));

		if (section2Content.isDisplayed() == false) {
			WebElement accordianOption2 = driver.findElement(By.xpath("//*[@id='section2Heading']"));
			highlightElement(accordianOption2);
			Thread.sleep(3000);
			accordianOption2.click();
		}

	}

	@Test(priority = 4)
	public void clickOnAccordianOption3() throws InterruptedException {
		WebElement section3Content = driver.findElement(By.xpath("//div[@id='section3Content']"));

		if (section3Content.isDisplayed() == false) {
			WebElement accordianOption3 = driver.findElement(By.xpath("//div[@id='section3Heading']"));
			highlightElement(accordianOption3);
			Thread.sleep(3000);
			accordianOption3.click();
		}
		
		driver.close();

	}

}
