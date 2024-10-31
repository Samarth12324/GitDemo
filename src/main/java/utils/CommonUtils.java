package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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

	public static String takeScreenShot(WebDriver driver, String testcaseName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"//Reports//" + testcaseName + ".png"));
		
		return System.getProperty("user.dir")+"//Reports//" + testcaseName + ".png";
	}

}
