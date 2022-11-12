package org.adacitin.baseclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4J {
	
	 static Logger log ;
	 
	 public static Logger loadLogger(Class<?> name) {
		log = LoggerFactory.getLogger(name);
		return log;
	 }

}
