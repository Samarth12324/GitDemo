package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentReports getExtentReport() {
		
		String path = System.getProperty("user.dir")+"/Reports/extentReport.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setDocumentTitle("OrangeHRMTesting");
		reporter.config().setReportName("ExtentReport");
		reporter.config().setTheme(Theme.STANDARD);
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Dnyaneshwar Gurude");
		
		return extent;
	}
}
