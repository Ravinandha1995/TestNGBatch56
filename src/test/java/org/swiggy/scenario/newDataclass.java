package org.swiggy.scenario;

import java.util.Date;

import org.testng.annotations.Test;

public class newDataclass {
	
	
	@Test(dataProvider = "dataname",dataProviderClass = dataclass.class )
	public void mett(String user,String pass) {
		System.out.println(new Date());
		System.out.println(user+" "+pass);
		
	}

}
