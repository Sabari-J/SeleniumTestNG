package PageObjClasses;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.base;

public class uploadDownload extends base {
	Elements elmnts = new Elements();

	public void clickonUploadDownloadTab() throws InterruptedException {

		elmnts.clickOnElements();
		WebElement uploadDownloadTab = driver.findElement(By.xpath("//span[contains(.,'Upload and Download')]"));
		uploadDownloadTab.click();

	}

	// @Test
	public void clickDownloadButton() throws InterruptedException {
		clickonUploadDownloadTab();
		WebElement downloadButton = driver.findElement(By.xpath("//*[@id='downloadButton' and .='Download']"));
		downloadButton.click();

	}

	@Test
	public void uploadfile() throws AWTException, InterruptedException {

		clickonUploadDownloadTab();

		WebElement uploadBtn = driver.findElement(By.xpath("//input[@id='uploadFile']"));
		clickUsingJsExecutor(uploadBtn);

		System.out.println("Clicked on Upload Button");

		StringSelection ss = new StringSelection("C:\\Users\\sabareesan.j\\Downloads\\rent-receipt.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot rt = new Robot();
		rt.delay(2000);
		rt.keyPress(KeyEvent.VK_CONTROL);
		rt.keyPress(KeyEvent.VK_V);
		rt.keyRelease(KeyEvent.VK_CONTROL);
		rt.keyRelease(KeyEvent.VK_V);

		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);

		WebElement fileStatus = driver.findElement(By.xpath("//p[@id='uploadedFilePath']"));

		System.out.println(fileStatus.getText() + " File uploaded Successfully");

	}

}
