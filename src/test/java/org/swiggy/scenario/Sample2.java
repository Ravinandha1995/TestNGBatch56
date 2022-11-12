package org.swiggy.scenario;

import java.util.Date;

import org.adacitin.baseclass.CommonUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample2 extends CommonUtils {
	
	
	@BeforeMethod
	public void bMethod() {
		System.out.println(new Date());
		System.out.println("before method");
	}
	
	//priority this is give preference to -number then 0 and then will give preference to +
	//we can give - value as non sequence but if we give possitve value without sequence means this
	//will collect all the non prioritised method and executed then once in accsending order
	//and run the next priority even if the sequence missed.
	@Test(priority = 0)
	public void me() {
		System.out.println("test 1");
	}
	
	@Test(priority = -1)
	public void me1() {
		System.out.println("test 2");
	}

	@Test(priority = -3)
	public void me2() {
		System.out.println("test 3");
	}
	
	@Test(priority = 2)
	public void mee() {
		System.out.println("test 4");
	}

	@Test(priority = 4)
	public void meee() {
		System.out.println("test 5");
	}

	
	@Test
	public void news() {
		System.out.println("no priority");
	}
	
	@Test
	public void newss() {
		System.out.println("no priority 2");
	}
}
