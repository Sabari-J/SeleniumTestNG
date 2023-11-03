package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.base;

public class SelectableGrid extends base {

	Sortable_List sortList = new Sortable_List();
	Selectable_list selectableList = new Selectable_list();

	@Test(priority = 0)
	public void clickOnGrid() {
		sortList.clickOnInteractions();
		selectableList.clickOnSelectable();

		WebElement grid = driver.findElement(By.xpath("//a[@id='demo-tab-grid']"));
		scrollToElement(grid);
		grid.click();
		System.out.println("Clicked on Grid Tab");
	}

	@Test(priority = 1)
	public void selectOptions() {
		String[] Options = { "Nine", "Five", "One" };
		int secs = -50;

		for (String optn : Options) {
			WebElement selectableOptions = driver.findElement(By.xpath("//li[.='" + optn + "']"));
			scrollupLittle(secs);
			waitForSeconds(2);
			selectableOptions.click();
			System.out.println("Clicked on " + selectableOptions.getText());
		}
	}
}
