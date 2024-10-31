package OrangeHRMTests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BaseLayer.BrowserInitialization;
import PageLayer.HomePage;
import junit.framework.Assert;

public class Login extends BrowserInitialization{
	
	WebDriver driver;
	HomePage homePage;
	
	@Test(priority=1)
	public void verifyLoginBtnIsDisplayed() {
		
		Assert.assertEquals(true, landingPage.verifyLoginBtnIsDisplayed());
		
	}
	
	@Test(priority=2)
	public void verifyRegisterBtnIsDisplayed() {
		
		Assert.assertEquals(true, landingPage.verifyRegisterBtnIsDisplayed());
		
	}
	
	@Test(priority=3)
	public void verifyUserAbleToLoginWithValidCred() {
		
		homePage = landingPage.login("dnyaneshwargurude1@gmail.com", "Samarth@123");
		Assert.assertEquals(homePage.verifyHomePage(), "Let's Shop");
		homePage.clickOnSignOutBtn();
	}
	
	@Test(priority=4)
	public void verifyUserUnableToLoginWithInvalidEmail() {
		
		homePage = landingPage.login("dnyaneshwar123@gmail.com", "Samarth@123");
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");

	}
	
	@Test(priority=5)
	public void verifyUserUnableToLoginWithInvalidPassword() {
		
		homePage = landingPage.login("dnyaneshwargurude1@gmail.com", "Samarth@144");
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");

	}
	
}
