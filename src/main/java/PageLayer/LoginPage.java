package PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseLayer.BrowserInitialization;

public class LoginPage extends BrowserInitialization{
	static WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	private static By uname = By.xpath("//input[@name='username']");
	
	private static By pass = By.xpath("//input[@name='password']");
	
	private static By submitBtn = By.xpath("//button[@type='submit']");
	
	public void enterUsername(String username) {
		WebElement wb= driver.findElement(uname);
		wb.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		WebElement wb= driver.findElement(pass);
		wb.sendKeys(password);
	}
	
	public void clickOnSubmitButton() {
		WebElement wb= driver.findElement(submitBtn);
		wb.click();;
	}

}
