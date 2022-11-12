package org.swiggy.scenario;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class dependeonconcept {

	
	
	@Test(dependsOnMethods = {"mee","me1"})
	public void me() {
		System.out.println("me method");
	}
	
	@Test
	public void me1() {
		System.out.println("me1 method");
	}
	
	@Test
	public void mee() {
		System.out.println("this is my mee method");
		assertTrue(false);
	}
}
