package com.zam.ex1.xmlDescriptor.car;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarDemoApp {

	public static void main(String[] args) {
		
		//Step 1: Get application Context using spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/zam/xmlDescriptor/car/applicationContext.xml");
				
		//Example 1: Simple Spring Dependency Injection Example
		
		/*
		//Step 2: Retrieve the required bean from the spring context
		Car bmw = context.getBean("myCar", Car.class);
		
		//Step 3: Call the required methods on the bean
		//System.out.println(bmw.getDailyWorkout());
		//System.out.println(bmw.getDailyFortune());
		System.out.println(bmw.toString());
		*/
		
		//Example 2 : Spring Beans Scopes and Lifecycle Demonstration
		
		//Retrieve bean from the spring container
		Car bmw = context.getBean("myCar", Car.class);
		Car audi = context.getBean("myCar", Car.class);		
		
		boolean areTheObjectsSame = (bmw == audi);
		System.out.println("Are the objects Same? : " + areTheObjectsSame);
		System.out.println("bmw  : " + bmw);
		System.out.println("audi : " + audi);
		
		//Step 4: Close the application context
		context.close();
	}
}
