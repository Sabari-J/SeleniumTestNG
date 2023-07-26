package PageObjClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.base;

public class WebTables extends base {
	Elements elmnts = new Elements();

	List<WebElement> cellValues;
	List<WebElement> firstNames;

	@Test (priority = 0)
	public void clickOnWebTables() throws InterruptedException {
		elmnts.clickOnElements();
		WebElement WebTablesTab = driver.findElement(By.xpath("//span[contains(.,'Web Tables')]"));
		WebTablesTab.click();
		System.out.println("elements button clicked");

	}

	// @Test
	public void getValues() {

		List<String> headerVals = new ArrayList<String>();
		cellValues = driver.findElements(By.xpath("//div[@class='rt-tbody']//div//div[@class='rt-td']"));
		// HeadersValues
		List<WebElement> headersValues = driver.findElements(By.xpath("// div[@class='rt-resizable-header-content']"));
		for (WebElement values : headersValues) {
			headerVals.add(values.getText());
		}
		System.out.println(headerVals);

		// Cell Values

		for (WebElement celvals : cellValues) {
			String val = (String) celvals.getText();

			// *******Dealing with &nbsp; - Non-breaking space********

			// .replace("\u00a0", "") OR .replace("&nbsp;", "")

			if (!val.replace("&nbsp;", "").trim().isEmpty()) {
				System.out.println(val);
			}
		}
	}

	//@Test
	public void deleteEntry() {
		String deleteEntry = "Kierra";

		int noOfRows = driver.findElements(By.xpath("//div[@role='row']")).size();
		System.out.println(noOfRows + " : Rows Count");

		firstNames = driver.findElements(By.xpath("//div[@class='rt-td'][1]"));
		int intr = 0;
		for (WebElement fName : firstNames) {
			String name = fName.getText();
			System.out.println(name);

			intr++;
			if (name.equalsIgnoreCase(deleteEntry)) {

				WebElement deletableEntry = driver.findElement(
						By.xpath("//*[local-name()='svg' and @fill='currentColor']/../..//span[@id='delete-record-"+ intr + "']"));

				System.out.println("Record " + name + " - Deleted Successfully");
				deletableEntry.click();
				break;
			}
		}
	}

	@Test  (priority = 2)
	public void editFirstName() throws InterruptedException {
		String existingName = "Kierra";
		String updatableName = "Sabari";
		
		int intr = 0;
		firstNames = driver.findElements(By.xpath("//div[@class='rt-td'][1]"));

		for (WebElement fName : firstNames) {
			String name = fName.getText();
			System.out.println(name);
			intr++;
			if (name.equalsIgnoreCase(existingName)) {
				WebElement editableEntry = driver.findElement(
						By.xpath("//*[local-name()='svg' and @fill='currentColor']/../..//span[@id='edit-record-" + intr+ "']"));
				
				clickUsingJsExecutor(editableEntry);
				//editableEntry.click();
				System.out.println("Clicked on the Edit Record Icon");

				WebElement modalDailogueContent = driver.findElement(By.xpath("//div[@class='modal-content']"));
				elementToBevisible(modalDailogueContent);
				
				WebElement fNameTxtBox = driver.findElement(By.xpath("//input[@id='firstName']"));
				fNameTxtBox.clear();
				fNameTxtBox.sendKeys(updatableName);
								
				WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
				submitButton.click();
				
				break;
			}

		}
	}
	
	@Test (priority = 1)
	public void addNewRecord() {

		String fName = "Sabari";
		String lstName = "J";
		String eMail = "Sabari.j3360@gmail.com";
		String age = "23";
		String salary = "230000";
		String dept = "QA_Testing";


		WebElement addButton = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
		elementToBeEnable(addButton);
		addButton.click();

		WebElement registrationForm = driver.findElement(By.xpath("//div[@class='modal-content']"));
		elementToBevisible(registrationForm);

		WebElement fNameTxtbox = driver.findElement(By.xpath("//*[@id='firstName']"));
		fNameTxtbox.sendKeys(fName);

		WebElement lstNameTxtbox = driver.findElement(By.xpath("//*[@id='lastName']"));
		lstNameTxtbox.sendKeys(lstName);

		WebElement emailTxtBox = driver.findElement(By.xpath("//*[@id='userEmail']"));
		emailTxtBox.sendKeys(eMail);

		WebElement ageTxtBox = driver.findElement(By.xpath("//*[@id='age']"));
		ageTxtBox.sendKeys(age);

		WebElement salaryTxtBox = driver.findElement(By.xpath("//*[@id='salary']"));
		salaryTxtBox.sendKeys(salary);

		WebElement deptTxtBox = driver.findElement(By.xpath("//*[@id='department']"));
		deptTxtBox.sendKeys(dept);

		WebElement submitBtn = driver.findElement(By.xpath("//*[@id='submit']"));
		submitBtn.click();

	}
}