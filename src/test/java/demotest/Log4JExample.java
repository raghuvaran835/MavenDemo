package demotest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4JExample {
	private static Logger log=LogManager.getLogger(Log4JExample.class.getName());
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.info("This is info");
		log.debug("It is debugs");
		log.error("It is error");
		log.fatal("It is fatal");
		

	}

}
