package org.swiggy.scenario;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataclass {

	
//	
//	@Test
//	public void newss() {
//		for(int i=0; i<100;i++) {
//			
//			System.out.println("username password click on login");	
//		}
//		
//	}
	
	
	@Test(dataProvider = "dataname" )
	public void testData(String password,String username) {
		System.out.println(password + " "+username );
	}
	
	@DataProvider(parallel = true)
	public Object[][] dataname(){
		
		return new Object[][] {{"dillibabu","Babu@01"},{"nandha","Nanda@01"},{"tawfeek","Tawfeek@01"}};
		
	}
	
	@Test(dataProvider = "dataname")
	public void ne(String user,String pass) {
		System.out.println(user+""+pass);
	}
	
	
	
	
	
}
