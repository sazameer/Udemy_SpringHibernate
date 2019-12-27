package com.zam.ex3.javaConfig.car;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//Step 1: Get application Context using spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);
				
		//Example 1: Simple Spring Dependency Injection Example
		
		//Step 2: Get the required bean
		Car car = context.getBean("hatchback", Car.class);
		
		//Step 3: Call the required method of that bean
		System.out.println("Car Color  : " + car.getCarColor());
		System.out.println("Car Engine : " + car.getEngine());
		
		//Step 4: Close the application context
		context.close();
	}
}
