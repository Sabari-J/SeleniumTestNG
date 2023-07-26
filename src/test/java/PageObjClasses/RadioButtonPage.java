package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.base;

public class RadioButtonPage extends base {

	private WebElement radioButton;
	private WebElement yesOption;
	private WebElement impressiveOption;
	private WebElement selectionText;

	Elements elements = new Elements();

	String optn = "Yes";

	@Test
	public void radioButton() throws InterruptedException {

		elements.clickOnElements();
		radioButton = driver.findElement(By.xpath("//span[.='Radio Button' and @class='text']"));
		radioButton.click();

		selectRadioButtonOption(optn);
	}

	public void selectRadioButtonOption(String option) {
		
		switch (option) {

		case "Yes":
			yesOption = driver.findElement(By.xpath("//input[@id='yesRadio']"));
			scrollToElement(yesOption);
			clickUsingJsExecutor(yesOption);

			selectionText = driver.findElement(By.xpath("//span[@class='text-success']"));
			System.out.println("You have selected the option: " + selectionText.getText());

			break;

		case "Impressive":
			impressiveOption = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
			scrollToElement(impressiveOption);
			clickUsingJsExecutor(impressiveOption);

			selectionText = driver.findElement(By.xpath("//span[@class='text-success']"));
			System.out.println("You have selected the option: " + selectionText.getText());

			break;

		default:
			System.out.println("valid option is unavailable");

		}
	}

}
