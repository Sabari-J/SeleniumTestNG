package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Base.base;

public class DynamicProperties extends base {

	Elements elemnts = new Elements();

	@Test(priority = 0)
	public void clickOnWebTables() {
		elemnts.clickOnElements();
		WebElement DynamicPropTab = driver.findElement(By.xpath("//span[contains(.,'Dynamic Properties')]"));
		DynamicPropTab.click();
		System.out.println("DynamicProp button clicked");

	}

	@Test(priority = 1)
	public void elementEnabled() {

		WebElement enableButton = driver.findElement(By.id("enableAfter"));
		elementToBeEnable(enableButton);

		if (enableButton.isEnabled() == true) {
			enableButton.click();
			System.out.println( "Enable_Dynamic button has been clicked after 5 Secs");
			highlightElement(enableButton);
		}

	}

}
