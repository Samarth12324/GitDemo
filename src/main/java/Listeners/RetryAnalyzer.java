package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int counter=2;
	int max=0;
	
	@Override
	public boolean retry(ITestResult result) {
		if(max<counter) {
			max++;
			return true;
		}
		return false;
	}

}
