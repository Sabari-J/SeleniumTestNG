package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.base;

public class linksPage extends base {

	private WebElement linksOption;
	private WebElement homeLink;
	Elements elemnts = new Elements();

	@Test (priority = 0)
	public void clickOnLinks() throws InterruptedException {

		elemnts.clickOnElements();
		linksOption = driver.findElement(By.xpath("//span[.='Links']"));
		linksOption.click();
	}

	// 
	public void clickOnHome() {

		homeLink = driver.findElement(By.id("simpleLink"));
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("simpleLink")));
		System.out.println("Element identified");
		homeLink.click();
//		clickUsingJsExecutor(homeLink);
		System.out.println("clicked On Home Link");

	}

	@Test (priority = 1)
	public void clickOnHomeAsf() throws InterruptedException {

		
		System.out.println("entered method");
		WebElement homeAsfLink = driver.findElement(By.id("simpleLink"));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(homeAsfLink));

		System.out.println("element identified	");
		//homeAsfLink.click();
		clickUsingJsExecutor(homeAsfLink);
	}

}
