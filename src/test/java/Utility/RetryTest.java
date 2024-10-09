package Utility;

import org.testng.IRetryAnalyzer;

import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {

	private int retrycount=0;
	public static final int maxretryInt=2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retrycount<maxretryInt)
		{
			retrycount++;
			return true;
		}
		return false;
	}

	
	
}
