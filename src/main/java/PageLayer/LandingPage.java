package PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractLayer.AbstractClass;

public class LandingPage extends AbstractClass{
	WebDriver driver;
	
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	private static By userEmail = By.id("userEmail");
	private static By userPassword = By.id("userPassword");
	private static By loginBtn = By.id("login");
	private static By registerUserBtn = By.xpath("//a[text()='Register']");
	private By errMsg = By.xpath("//div[text()=' Incorrect email or password. ']");
	
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
	public RegisterPage clickOnRegisterBtn() {
		
		driver.findElement(registerUserBtn).click();
		return new RegisterPage(driver);
		
	}
	
	public HomePage login(String username, String password) {
		
		driver.findElement(userEmail).sendKeys(username);
		driver.findElement(userPassword).sendKeys(password);
		driver.findElement(loginBtn).click();
		
		return new HomePage(driver);
		
	}

	public String  getErrorMessage() {
		
		waitForElementToAppear(errMsg);
		return driver.findElement(errMsg).getText();
		
	}
	
	public boolean verifyLoginBtnIsDisplayed() {
		
		waitForElementToAppear(loginBtn);
		WebElement login = driver.findElement(loginBtn);
		return login.isDisplayed();
	}
	
	public boolean verifyRegisterBtnIsDisplayed() {
		
		waitForElementToAppear(registerUserBtn);
		WebElement login = driver.findElement(registerUserBtn);
		return login.isDisplayed();
	}

}
