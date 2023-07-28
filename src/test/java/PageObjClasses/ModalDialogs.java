package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.base;

public class ModalDialogs extends base {

	public void clickOnDialogModalOptions() {

		WebElement dialogModalOption = driver.findElement(By.xpath(""));
		dialogModalOption.click();
		
		System.out.println("");

	}

}
