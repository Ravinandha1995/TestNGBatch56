package org.swiggy.scenario;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Date;

import org.adacitin.baseclass.CommonUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Sample extends CommonUtils {

	@BeforeGroups("smoke")
	public void meth() {
		System.out.println(System.getProperty("browser"));
		System.out.println(System.getProperty("environment"));
			
		System.out.println("before groups smoke");
	}

	@Test(priority = 0, groups = { "smoke" })
	public void me() {
		logger = extentreport.createTest("me");
		logger.log(Status.INFO,"this is the first line of the test");
		if (true) {
			
			logger.log(Status.PASS, "the assertion is pass");
		}
		else {
			logger.log(Status.WARNING, "this si failed case");
		}
	}

	@Test(priority = -1, groups = { "smoke", "sanity" })
	public void me1() throws IOException {
		logger = extentreport.createTest("me1");
		log.info("this is the second line of the test");
		logger.log(Status.INFO,"this is the second line of the test");
		if (true) {
			log.info("the assertion is pass");
			logger.log(Status.WARNING, "the assertion is pass");
			logger.addScreencastFromPath("");
		}
		
		log.info("test 2");
	}

	@BeforeGroups("sanity")
	public void meth1() {
		System.out.println("before groups sanity");
	}

	@BeforeMethod
	public void bMethod() {
		System.out.println(new Date());
		System.out.println("before method");
	}

	// priority this is give preference to -number then 0 and then will give
	// preference to +
	// we can give - value as non sequence but if we give possitve value without
	// sequence means this
	// will collect all the non prioritised method and executed then once in
	// accsending order
	// and run the next priority even if the sequence missed.

	@Test(priority = -3, groups = { "sanity" })
	public void me2() {
		logger = extentreport.createTest("me2");
		System.out.println("test 3");
	}

	@Test(priority = 2)
	public void mee() {
		logger = extentreport.createTest("mee");
		System.out.println("test 4");
	}

	@Test(priority = 4)
	public void meee() {
		logger = extentreport.createTest("meee");
		System.out.println("test 5");
	}

	@Test(groups = { "smoke" })
	public void news() {
		logger = extentreport.createTest("news");
		System.out.println("no priority");
	}

}
