package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonUtils {
	
	public static void selectDpDnOptionByVisibleText(WebElement wb, String option) {
		
		Select select = new Select(wb);
		select.selectByVisibleText(option);
		
	}

	public static void selectDpDnOptionByIndex(WebElement wb, int option) {
		
		Select select = new Select(wb);
		select.selectByIndex(option);
		
	}


}
