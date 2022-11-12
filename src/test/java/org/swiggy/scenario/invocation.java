package org.swiggy.scenario;

import static org.testng.Assert.assertTrue;

import java.util.Date;

import org.testng.annotations.Test;

public class invocation {
	
	@Test(invocationCount = 5,threadPoolSize = 5,invocationTimeOut = 3)
	public void booking() {
		System.out.println("Select the place and book the ticket...");
		System.out.println(new Date());
		assertTrue(true);
	}

}
