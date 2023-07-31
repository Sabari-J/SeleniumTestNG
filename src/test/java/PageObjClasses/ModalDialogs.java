package PageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.base;

public class ModalDialogs extends base {

	BrowserWindows brwsrWnds = new BrowserWindows();

	@Test(priority = 0)
	public void clickOnDialogModalOptions() {
		brwsrWnds.clickOnAlertFrameWindowsTab();

		WebElement dialogModalOption = driver.findElement(By.xpath("//span[.='Modal Dialogs']"));
		dialogModalOption.click();

		System.out.println("Clicked on Modal Dialogs Tab");

	}

	@Test(priority = 1)
	public void clickOnSmallModal() throws InterruptedException {
		WebElement smallModal = driver.findElement(By.xpath("//*[@id='showSmallModal' and .='Small modal']"));
		smallModal.click();

		String modalTitle = driver.findElement(By.xpath("//*[@class='modal-title h4']")).getText();
		System.out.println("Title of the Modal Pop-Up is: " + modalTitle);

		if (!modalTitle.equalsIgnoreCase("Small Modal")) {
			driver.findElement(By.xpath("//*[@class='close']")).click();
			Thread.sleep(3000);
			System.out.println("Clicked on 'X' Icon");
		}

		else if (modalTitle.equalsIgnoreCase("Small Modal")) {
			String modalDialogText = driver.findElement(By.xpath("//*[@class='modal-body']")).getText();
			System.out.println("Content in the Modal Dialog box: \n" + modalDialogText);

			WebElement closeButton = driver.findElement(By.xpath("//*[@id='closeSmallModal']"));
			Thread.sleep(3000);
			closeButton.click();

		}

	}

	@Test(priority = 2)
	public void clickOnLargeModal() throws InterruptedException {

		WebElement largeModal = driver
				.findElement(By.xpath("//*[@class='mt-2 btn btn-primary' and @id='showLargeModal']"));
		largeModal.click();

		String modaltitle = driver
				.findElement(By.xpath("//*[@class='modal-title h4' and @id='example-modal-sizes-title-lg']")).getText();
		System.out.println("Title of the Modal: " + modaltitle);

		if (!modaltitle.equalsIgnoreCase("Large Modal")) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='close']")).click();
			System.out.println("Clicked on 'X' Icon");
		} else if (modaltitle.equalsIgnoreCase("Large Modal")) {
			String modalContent = driver.findElement(By.xpath("//*[@class='modal-body']")).getText();
			System.out.println("Content in the Modal Dialog box: \n" + modalContent + "\n");
			WebElement closeButton = driver.findElement(By.xpath("//*[@id='closeLargeModal']"));
			Thread.sleep(3000);
			closeButton.click();

		}
	}

}
