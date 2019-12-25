package com.zam.ex2.annotations.car;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarAnnotationsDemoApp {

	public static void main(String[] args) {
		
		//Step 1: Get application Context using spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/zam/annotations/car/applicationContext.xml");
				
		//Example 1: Simple Spring Dependency Injection Example
		
		//Step 2: Get the required bean
		Car car = context.getBean("hatchback", Car.class);
		
		//Step 3: Call the required method of that bean
		System.out.println("Car Color : " + car.getCarColor());
		System.out.println("Car Engine : " + car.getEngine());
		
		//Step 4: Close the application context
		context.close();
	}
}
