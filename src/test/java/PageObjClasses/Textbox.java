package PageObjClasses;

import java.util.List;
import javax.xml.transform.Templates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Base.base;

public class Textbox extends base {

	Elements elemnts = new Elements();

	@Test(priority = 0)
	public void clickonCheckBox() {

		elemnts.clickOnElements();

		WebElement checkBox = driver.findElement(By.xpath("//span[.='Check Box' and  @class=\"text\"]"));
		checkBox.click();
		System.out.println("Clicked on checkBox Tab");
	}

	@Test(priority = 1)
	public void clickOnHomeExpandArrow() throws InterruptedException {

		// *******Dealing with SVG elements******

		WebElement expandHomeArrow = driver
				.findElement(By.xpath("//*[local-name()='svg' and @class='rct-icon rct-icon-expand-close']"));
		System.out.println("++++++");
		expandHomeArrow.click();
		System.out.println("Clicked on Home Arrow");

		// Actions a = new Actions(driver); a.moveToElement(expandArrow).
		// click().build().perform();

	}

	// @Test(priority = 2)
	public void desktop() {

		WebElement desktopCheckBox = driver.findElement(
				By.xpath("//*[@class='rct-title' and contains(text(),'Desktop')]/..//span[@class='rct-checkbox']"));
		desktopCheckBox.click();
		System.out.println("Clicked on Desktop checkbox");

	}

	@Test(priority = 2)
	public void selectRequiredCheckbox() {

		// temp
		String input = "Word File.doc";

		if (input.equalsIgnoreCase("home")) {

			// Xpath -TIPS: //*[name()='svg' and starts-with(@class, 'rct-icon
			// rct-icon-uncheck')]/../..//span[text()='Home'] -> "/.."AS -goes up(1step)

			WebElement homeCheckBox = driver.findElement(
					By.xpath("//*[name()='svg' and starts-with(@class, 'rct')]/../..//span[text()='Home']"));
			homeCheckBox.click();
			System.out.println("Selected Home - CheckBox");
		} else {

			if (input.equalsIgnoreCase("Notes") || input.equalsIgnoreCase("Commands")) {
				WebElement expandDesktopArrow = driver
						.findElement(By.xpath("//*[@class='rct-title' and contains(text(),'Desktop')]/../..//button"));
				expandDesktopArrow.click();
				System.out.println("Clicked on Desktop Arrow");

				if (input.equalsIgnoreCase("Notes")) {
					WebElement notesCheckBox = driver.findElement(
							By.xpath("//*[name()='svg' and starts-with(@class, 'rct')]/../..//span[text()='Notes']"));
					notesCheckBox.click();
					System.out.println("Clicked on  Notes CheckBox");
				}
				if (input.equalsIgnoreCase("Commands")) {
					WebElement commandsCheckBox = driver.findElement(By
							.xpath("//*[name()='svg' and starts-with(@class, 'rct')]/../..//span[text()='Commands']"));
					commandsCheckBox.click();
					System.out.println("Clicked on Commands CheckBox");
				}
			}

			if (input.equalsIgnoreCase("react") || input.equalsIgnoreCase("angular") || input.equalsIgnoreCase("veu")) {

				WebElement expandDocumentArrow = driver
						.findElement(By.xpath("//*[@class='rct-title' and .='Documents']/../..//button"));
				expandDocumentArrow.click();
				System.out.println("Clicked on - Document Arrow");

				WebElement expandWorkSpaceArrow = driver.findElement(By.xpath(
						"//*[@class='rct-title' and .='WorkSpace']/../..//button[@class='rct-collapse rct-collapse-btn']"));
				expandWorkSpaceArrow.click();
				System.out.println("Clicked on - Workspace Arrow");

				if (input.equalsIgnoreCase("react")) {
					WebElement reactCheckBox = driver.findElement(
							By.xpath("//*[@class='rct-title' and .='React']/../..//span[@class='rct-checkbox']"));
					reactCheckBox.click();
					System.out.println("Clicked on - React Checkbox");
				}

				if (input.equalsIgnoreCase("angular")) {
					WebElement angularCheckBox = driver.findElement(
							By.xpath("//*[@class='rct-title' and .='Angular']/../..//span[@class='rct-checkbox']"));
					angularCheckBox.click();
					System.out.println("Clicked on - Angluar Checkbox");

				}
			}

			if (input.equalsIgnoreCase("public") || input.equalsIgnoreCase("private")
					|| input.equalsIgnoreCase("classified") || input.equalsIgnoreCase("general")) {

				WebElement expandDocumentArrow = driver
						.findElement(By.xpath("//*[@class='rct-title' and .='Documents']/../..//button"));
				expandDocumentArrow.click();
				System.out.println("Clicked on - Document Arrow");

				WebElement expandOfficeArrow = driver
						.findElement(By.xpath("//*[@class='rct-title' and .='Office']/../..//button"));
				expandOfficeArrow.click();
				System.out.println("Clicked on - Office Arrow");

				if (input.equalsIgnoreCase("public")) {
					WebElement publicCheckBox = driver.findElement(
							By.xpath("//*[@class='rct-title' and .='Public']/..//span[@class='rct-checkbox']"));
					publicCheckBox.click();

					System.out.println("Clicked on - Public CheckBox");
				}

				if (input.equalsIgnoreCase("private")) {
					WebElement privateCheckbox = driver.findElement(
							By.xpath("//*[@class='rct-title' and .='Private']/..//span[@class='rct-checkbox']"));
					privateCheckbox.click();
					System.out.println("Clicked on - Private Checkbox");
				}

				if (input.equalsIgnoreCase("classified")) {
					WebElement classifiedCheckbox = driver.findElement(
							By.xpath("//*[@class='rct-title' and .='Classified']/..//span[@class='rct-checkbox']"));
					classifiedCheckbox.click();
					System.out.println("Clicked on - classified Checkbox");
				}
				if (input.equalsIgnoreCase("General")) {
					WebElement generalCheckbox = driver.findElement(
							By.xpath("//*[@class='rct-title' and .='General']/..//span[@class='rct-checkbox']"));
					generalCheckbox.click();
					System.out.println("Clicked on - General Checkbox");
				}

			}

			if (input.equalsIgnoreCase("Word File.doc") || input.equalsIgnoreCase("Excel File.doc")) {
				WebElement expandDownloadArrow = driver
						.findElement(By.xpath("//*[@class=\"rct-title\" and .='Downloads']/../..//button"));
				expandDownloadArrow.click();

				System.out.println("Clicked on Download Arrow Button");

				if (input.equalsIgnoreCase("Word File.doc")) {
					WebElement wordCheckbox = driver.findElement(By
							.xpath("//*[@class='rct-title' and .='Word File.doc']/../..//span[@class='rct-checkbox']"));
					wordCheckbox.click();

					System.out.println("Clicked on - Word Checkbox");

				}

				if (input.equalsIgnoreCase("Excel File.doc")) {
					WebElement excelCheckbox = driver.findElement(By.xpath(
							"//*[@class='rct-title' and .='Excel File.doc']/../..//span[@class='rct-checkbox']"));
					excelCheckbox.click();

					System.out.println("Clicked on - Excel Checkbox");

				}

			}

		}
	}

	@Test(priority = 3)
	public void getSelectionList() {
		WebElement SelectionList = driver.findElement(By.xpath("//div[@id='result' and @class='display-result mt-4']"));
		String selection = SelectionList.getText();
		System.out.println(selection);

	}

}
