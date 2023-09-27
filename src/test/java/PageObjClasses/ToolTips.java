package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Base.base;

public class ToolTips extends base {

	private static String hoverOverButtonXpath = "//button[@id='toolTipButton']";
	private static String hoverOverTextField = "//input[@id='toolTipTextField']";
	private static String hoverOverContraryText = "//a[.='Contrary']";
	private static String hoverOversectionText = "//a[.='1.10.32']";

	AccordianOptions acdnOptns = new AccordianOptions();

	@Test(priority = 0)
	public void clickOnToolTipsTab() {
		acdnOptns.clickOnWidgets();

		WebElement toolTipsTab = driver.findElement(By.xpath("//span[.='Tool Tips']"));
		scrollToElement(toolTipsTab);
		toolTipsTab.click();
	}

	@Test(priority = 1)
	public void hoverAndFetchToolTipText() {
		WebElement hoverButton = driver.findElement(By.xpath(hoverOversectionText));
		scrollToElement(hoverButton);
		highlightElement(hoverButton);
		Actions actn = new Actions(driver);
		actn.moveToElement(hoverButton).perform();

		WebElement toolTipText = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
		elementToBevisible(toolTipText);
		String txt = toolTipText.getText();
		System.out.println("Text fetched from the ToolTip: " + txt);
	}

}
