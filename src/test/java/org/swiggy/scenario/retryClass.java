package org.swiggy.scenario;

import static org.testng.Assert.assertTrue;

import org.adacitin.baseclass.IREtryAnalyser;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class retryClass {
	
	
//	@Test(retryAnalyzer =IREtryAnalyser.class ,dataProvider = "data")
//	public void test(String number) {
//		int a = Integer.parseInt(number);
//		if (a==2) {
//		assertTrue(true);
//		}
//		else {
//			assertTrue(false);
//		}
//	}
	
	@Test(dataProvider = "data")
	public void test(String number) {
		int a = Integer.parseInt(number);
		if (a==2) {
		assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}
	
	@DataProvider
	public Object[][] data(){
		return new Object[][] {{"2"},{"3"}};
	}

}
