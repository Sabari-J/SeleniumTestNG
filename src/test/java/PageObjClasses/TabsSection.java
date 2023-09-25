package PageObjClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.base;

public class TabsSection extends base {
	AccordianOptions accrdOptns = new AccordianOptions();

	@Test(priority = 0)
	public void clickOnTabsSection() {
		accrdOptns.clickOnWidgets();
		WebElement tabOption = driver.findElement(By.xpath("//span[.='Tabs']"));
		scrollToElement(tabOption);
		tabOption.click();
	}

	@Test(priority = 1)
	public void clickOnTabs() {

		String tabOption = "use";

		if (tabOption.equalsIgnoreCase("What")) {
			driver.findElement(By.xpath("//a[@id='demo-tab-what']")).click();

			String content = driver.findElement(By.xpath("//div[@id='demo-tabpane-what']//p")).getText();
			System.out.println("Content below the 'What' Tab:" + '\n' + content);
		}

		else if (tabOption.equalsIgnoreCase("Origin")) {
			driver.findElement(By.xpath("//a[@id='demo-tab-origin']")).click();

			List<WebElement> paragraphContent = driver.findElements(By.xpath("//div[@id='demo-tabpane-origin']//p"));
			StringBuilder contentBuilder = new StringBuilder();

			for (WebElement para : paragraphContent) {
				contentBuilder.append(para.getText());
			}
			System.out.println("Content below the 'Origin' Tab:" + '\n' + contentBuilder.toString());
		}

		else if (tabOption.equalsIgnoreCase("Use")) {
			driver.findElement(By.xpath("//a[@id='demo-tab-use']")).click();

			String content = driver.findElement(By.xpath("//div[@id='demo-tabpane-use']")).getText();
			System.out.println("Content below the 'Use' Tab:" + '\n' + content);
		}
	}
}
