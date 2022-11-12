package org.adacitin.baseclass;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IREtryAnalyser implements IRetryAnalyzer{

	
	int min =0;
	int max=5;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(min<max) {
			
			min++;
			return true;
		}
		return false;
	}

}
