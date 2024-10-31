package PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.CommonUtils;

public class RegisterPage {
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
	}

	private By firstName = By.id("firstName");
	private By lastName = By.id("lastName");
	private By email = By.id("userEmail");
	private By phone = By.id("userMobile");
	private By occupation = By.xpath("//select[@formcontrolname='occupation']");
	private By gender = By.xpath("//label[text()='Gender']/parent :: div/descendant :: input[@value='Male']");
	private By password = By.id("userPassword");
	private By confirmPassword = By.id("confirmPassword");
	private By checkBox = By.xpath("//input[@type='checkbox']");
	private By submitBtn = By.id("login");
	
	
	public void enterFirstName(String fname) {
		driver.findElement(firstName).sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		driver.findElement(lastName).sendKeys(lname);
	}
	
	public void enterEmail(String emailId) {
		driver.findElement(email).sendKeys(emailId);
	}
	
	public void enterPhone(String phoneNumber) {
		driver.findElement(phone).sendKeys(phoneNumber);
	}
	
	public void selectOccupation(String option) {
		WebElement wb = driver.findElement(occupation);
		CommonUtils.selectDpDnOptionByVisibleText(wb, option);
	}
	
	public void selectGender() {
		driver.findElement(gender).click();
	}
	
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void enterConfirmPassword(String ConfirmPass) {
		driver.findElement(confirmPassword).sendKeys(ConfirmPass);
	}
	
	public void clickOnBox() {
		driver.findElement(checkBox).click();
	}
	
	public void clickOnRegisterBtn() {
		driver.findElement(submitBtn).click();
	}
	
}
