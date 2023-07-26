package PageObjClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.base;

public class PracticeForm extends base {

	private String nameXpath = "//input[@id='firstName']";
	private String Fname = "Sabari";

	private String LastNameXpath = "//input[@id='lastName']";
	private String Lname = "J";

	private String mailIDXpath = "//input[@id='userEmail']";
	private String eMailID = "sabari.J@gmail.com";

	private String mobileNoXpath = "//input[@id='userNumber']";
	private String mobileNo = "9333396666";

	private String subjectXpath = "//input[@id='subjectsInput']";

	private String currentAddress = "no2,\n1/333  \nBazaar street  \nKadathur ";

	@Test(priority = 0)
	public void clickOnPracticeForm() {
		WebElement formOption = driver.findElement(By.xpath("//h5[text()= 'Forms']"));
		scrollToElement(formOption);
		formOption.click();
		System.out.println("Clicked on Forms");

		WebElement practiceForm = driver.findElement(By.xpath("//span[contains(., 'Practice Form')]"));
		practiceForm.click();
		System.out.println("Clicked on Practice Form");

	}

	@Test(priority = 1)
	public void enterName() {
		enterTextInTxtBox(nameXpath, Fname);

	}

	@Test(priority = 2)
	public void enterEmailID() {
		enterTextInTxtBox(mailIDXpath, eMailID);
	}

	@Test(priority = 3)
	public void genderSelection() throws InterruptedException {
		String gender = "Female";

		switch (gender) {
		case "Male":
			WebElement genderMaleButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
			clickUsingJsExecutor(genderMaleButton);
			System.out.println("Clicked on the Option - " + gender);
			break;

		case "Female":
			WebElement genderFemaleButton = driver.findElement(By.xpath("//input[@id='gender-radio-2']"));
			clickUsingJsExecutor(genderFemaleButton);
			System.out.println("Clicked on the Option - " + gender);
			break;

		case "Other":
			WebElement genderOtherButton = driver.findElement(By.xpath("//input[@id='gender-radio-3']"));
			clickUsingJsExecutor(genderOtherButton);
			System.out.println("Clicked on the Option - " + gender);
			break;

		default:
			System.err.println("Invalid input :" + gender);
			break;
		}

	}

	@Test(priority = 4)
	public void enterMobileNo() {
		enterTextInTxtBox(mobileNoXpath, mobileNo);
	}

	// @Test(priority = 5)
	/*
	 * public void enterDate() throws Exception { String dateInput = "03-Mar-2023";
	 * Calendar calendarInstance = Calendar.getInstance(); SimpleDateFormat
	 * dateformat = new SimpleDateFormat("DD-MMM-YYYY");
	 * dateformat.setLenient(false);
	 * 
	 * Date formattedDate; int targetDay; int targetMonth; int targetYear;
	 * 
	 * try {
	 * 
	 * formattedDate = dateformat.parse(dateInput);
	 * calendarInstance.setTime(formattedDate);
	 * 
	 * targetDay = calendarInstance.get(Calendar.DAY_OF_MONTH); targetMonth =
	 * calendarInstance.get(Calendar.MONTH); targetYear =
	 * calendarInstance.get(Calendar.YEAR);
	 * 
	 * WebElement dobTextBox = driver.findElement(By.id("dateOfBirthInput"));
	 * dobTextBox.click();
	 * 
	 * } catch (ParseException e) { throw new
	 * Exception("Issue in parsing the date"); }
	 * 
	 * }
	 */

	@Test(priority = 5)
	public void selectHobbies() {
		String hobbies = "Music";

		switch (hobbies) {
		case "Sports":
			WebElement sports = driver.findElement(By.xpath("//label[contains(.,  'Sports')]"));
			clickUsingJsExecutor(sports);
			System.out.println(hobbies + ": Option has been selected Successfully");
			break;
		case "Reading":
			WebElement Reading = driver.findElement(By.xpath("//label[contains(.,  'Reading')]"));
			clickUsingJsExecutor(Reading);
			System.out.println(hobbies + ": Option has been selected Successfully");
			break;
		case "Music":
			WebElement Music = driver.findElement(By.xpath("//label[contains(.,  'Music')]"));
			clickUsingJsExecutor(Music);
			System.out.println(hobbies + ": Option has been selected Successfully");
			break;

		default:
			break;
		}

	}

	@Test(priority = 6)
	public void EnterSubject() throws AWTException {

		WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
		Robot rbt = new Robot();
		String[] subjects = { "English", "History", "Maths", "Arts", "chemistry" };

		for (String str : subjects) {
			subjectsInput.sendKeys(str);

			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.textToBePresentInElementValue(subjectsInput, str));

			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);

		}

	}

	@Test(priority = 7)
	public void uploadFile() throws AWTException {
		WebElement uploadButton = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
		highlightElement(uploadButton);
		clickUsingJsExecutor(uploadButton);

		StringSelection selectPath = new StringSelection(
				"C:\\Users\\sabareesan.j\\Documents\\Reimbursement Form A 2013 (3).pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectPath, null);

		Robot rbt = new Robot();
		rbt.delay(2000);
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_V);

		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);

	}

	@Test(priority = 8)
	public void enterCurrentAdrs() {
		WebElement currentaddres = driver.findElement(By.id("currentAddress"));
		currentaddres.sendKeys(currentAddress);

	}

	@Test(priority = 9)
	public void selectCity() throws InterruptedException {

		WebElement stateDropdown = driver.findElement(By.xpath("//*[local-name()='svg' and @class='css-19bqh2r']/../../../../..//div[@id='state']"));
		highlightElement(stateDropdown);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		By optionsLocator = By.cssSelector("#state div.css-yk16xz-control div.css-1hwfws3");
		wait.until(ExpectedConditions.presenceOfElementLocated(optionsLocator));

		clickUsingJsExecutor(stateDropdown);

//		By stateOptionLocator = By.xpath("//div[@id='state']//div[@class='css-1pahdxg']/div[text()='Rajasthan']");
//		WebElement stateOption = driver.findElement(stateOptionLocator);
//		stateOption.click();

//		scrollToElement(stateDropdown);
//		
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.elementToBeClickable(stateDropdown));
//		

//		WebElement stateDrpDwn = driver.findElement(By.xpath("//div[@id='state']//div[contains(text(), 'Uttar Pradesh')]"));
//		scrollToElement(stateDrpDwn);
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.elementToBeClickable(stateDrpDwn));
//		clickUsingJsExecutor(stateDrpDwn);

	}

}
