package org.swiggy.scenario;

import org.testng.annotations.Test;

public class dependeongroup {
	
	
	@Test(groups = {"smoke"})
	public void test() {
		System.out.println("test");
	}
	

	@Test(groups = {"sanity"},dependsOnGroups = {"integration"})
	public void test1() {
		System.out.println("test1");
	}
	
	

	@Test(groups = {"integration"})
	public void test2() {
		System.out.println("test2");
	}
	

	@Test(groups = {"regression"})
	public void test3() {
		System.out.println("test3");
	}

}
