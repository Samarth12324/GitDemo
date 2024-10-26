package BaseLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserInitialization {
	
	public static WebDriver initialization() throws IOException {
		
		WebDriver driver = null;
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty(("user.dir")+"C:\\Users\\RAMESHWAR\\eclipse-workspace\\OrangeHRM\\PropertyFiles\\configuration.properties"));
		prop.load(file);
		
		String browser = "chrome";
		
		if(browser=="chrome") {
			driver=new ChromeDriver();
		}
		else if(browser=="firefox") {
			driver=new FirefoxDriver();
		}
		else if (browser=="edge") {
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		return driver;
	}
		
}
