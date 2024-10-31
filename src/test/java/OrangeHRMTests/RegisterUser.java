package OrangeHRMTests;

import org.testng.annotations.Test;

import BaseLayer.BrowserInitialization;
import PageLayer.RegisterPage;

public class RegisterUser extends BrowserInitialization {
	RegisterPage registerPage;
	
	@Test(priority=1)
	public void verifyUserRegisteration() {
		String password = "Samarth@123";
		
		registerPage = landingPage.clickOnRegisterBtn();
		registerPage.enterFirstName("Dnyaneshwar");
		registerPage.enterLastName("Gurude");
		registerPage.enterEmail("dnyaneshwargurude1@gmail.com");
		registerPage.enterPhone("9637433340");
		registerPage.selectOccupation("Engineer");
		registerPage.selectGender();
		registerPage.enterPassword(password);
		registerPage.enterConfirmPassword(password);
		registerPage.clickOnBox();
		registerPage.clickOnRegisterBtn();

	}


}
