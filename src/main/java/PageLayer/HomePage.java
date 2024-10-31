package PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractLayer.AbstractClass;

public class HomePage extends AbstractClass{

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	private By signOutBtn = By.xpath("//button[@class='btn btn-custom']/child :: i[@class='fa fa-sign-out']");


	public void clickOnSignOutBtn() {
		
		waitForElementToAppear(signOutBtn);
		driver.findElement(signOutBtn).click();
		
	}
	
	public String verifyHomePage() {
		
		return driver.getTitle();
		
	}
	
	
}
