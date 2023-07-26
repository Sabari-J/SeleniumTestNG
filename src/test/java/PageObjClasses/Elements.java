package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Base.base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Elements extends base {

	@Test
	public void clickOnElements() {

		WebElement elementsTab = driver.findElement(By.xpath("//h5[contains(text(), 'Elements')]"));
		scrollToElement(elementsTab);

		elementsTab.click();

	}

	@Test
	public void clickTextBox() {
		WebElement textbox = driver.findElement(By.xpath("//span[contains(.,'Text Box')]"));
		textbox.click();
	}

}
