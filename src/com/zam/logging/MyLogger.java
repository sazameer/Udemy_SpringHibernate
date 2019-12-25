package com.zam.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyLogger {
	
	private String rootLoggerLevel;
	private String consoleLoggerLevel;
	
	
	public void setRootLoggerLevel(String rootLoggerLevel) {
		this.rootLoggerLevel = rootLoggerLevel;
	}
	public void setConsoleLoggerLevel(String consoleLoggerLevel) {
		this.consoleLoggerLevel = consoleLoggerLevel;
	}
	
	public void initLogger() {
		
		Level rootLevel = Level.parse(rootLoggerLevel);
		Level consoleLevel = Level.parse(consoleLoggerLevel);
		
		Logger applicationContextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());
		 
		// get parent logger
		Logger loggerParent = applicationContextLogger.getParent();
 
		// set root logging level
		loggerParent.setLevel(rootLevel);
		
		// set up console handler
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(consoleLevel);
		consoleHandler.setFormatter(new SimpleFormatter());
		
		// add handler to the logger
		loggerParent.addHandler(consoleHandler);
	}
	

}
