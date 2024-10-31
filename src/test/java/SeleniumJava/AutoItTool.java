package SeleniumJava;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Test
public class AutoItTool {
	
	public void uploadFile() throws InterruptedException, IOException {
		String path = System.getProperty("user.dir");
    	
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	map.put("profile.default_content_settings.popups", 0);
    	map.put("download.default_directory", path);
    	
    	ChromeOptions options = new ChromeOptions();
    	options.setExperimentalOption("prefs", map);
    	
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement selectFile = driver.findElement(By.id("pickfiles"));
		selectFile.click();
		
		Thread.sleep(5000);
		
		Runtime.getRuntime().exec("C:\\Users\\RAMESHWAR\\Desktop\\AutoIT\\FileUpload2.exe");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("processTaskTextBtn")));
		driver.findElement(By.id("processTaskTextBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		driver.findElement(By.id("pickfiles")).click();
		
		Thread.sleep(12000);
		
		File file = new File(path+"/ilovepdf_pages-to-jpg.zip");
		
		if(file.exists()) {
			System.out.println("File is present");
			if(file.delete()) {
				System.out.println("File is deleted");
			}
		}
		
		driver.close();
		
	}

}
