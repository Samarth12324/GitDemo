package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.CommonUtils;
import utils.ExtentReport;

public class TestListener implements ITestListener{

	ExtentReports extent = ExtentReport.getExtentReport();
	ExtentTest test;
	WebDriver driver;
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test is passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getThrowable().toString());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String path=null;
		try {
			path = CommonUtils.takeScreenShot(driver, result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test is skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
