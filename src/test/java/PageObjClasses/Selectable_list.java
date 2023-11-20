package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Base.base;

public class Selectable_list extends base {

	Sortable_List srtable = new Sortable_List();

	@Test(priority = 0)
	public void clickOnSelectable() {
		srtable.clickOnInteractions();
		WebElement selectableOption = driver.findElement(By.xpath("//span[.='Selectable']"));
		scrollToElement(selectableOption);
		selectableOption.click();
	}

	@Test(priority = 1)
	public void selectOptions() {
		String[] selectItems = { "Porta ac consectetur ac", "Cras justo odio", "Morbi leo risus" };

		int scrollValue = -200;
		for (String options : selectItems) {
			WebElement optns = driver.findElement(By.xpath("//li[.='" + options + "']"));
			scrollup_DownLittle(scrollValue);
			waitForSeconds(1);
			optns.click();
			System.out.println("Successfully selected \"" + optns.getText() + "\" option.");
		}

	}

}
