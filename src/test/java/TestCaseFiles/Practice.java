package TestCaseFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.base;
import PageObjClasses.Elements;

public class Practice extends base {
	Elements elemnts = new Elements();
	
	private static WebElement DesktopArrow = driver.findElement(By.xpath("//label[@for='tree-node-notes']//span[@class='rct-checkbox']"));

	@Test(priority = 0)
	public void clickonCheckBox() {

		elemnts.clickOnElements();

		WebElement checkBox = driver.findElement(By.xpath("//span[.='Check Box' and  @class='text']"));
		checkBox.click();
		System.out.println("Clicked on checkBox Tab");
	}

	@Test(priority = 1)
	public void clickOnHomeExpandArrow() throws InterruptedException {

		// *******Dealing with SVG elements****** In xpath =>local-name()='svg'

		WebElement expandHomeArrow = driver
				.findElement(By.xpath("//*[local-name()='svg' and @class='rct-icon rct-icon-expand-close']"));

		System.out.println("++++++");
		expandHomeArrow.click();
		System.out.println("Clicked on Home Arrow");

	}

}