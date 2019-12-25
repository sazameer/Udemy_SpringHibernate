package com.zam.ex3.javaConfig.car.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.zam.ex2.annotations.car.Car;
import com.zam.ex2.annotations.car.Engine;

@Component
public class Hatchback implements Car {
	
	
	private Engine engine;
	
	public Hatchback() {
		
	}
	
	@Autowired
	public Hatchback(@Qualifier("v6Engine")Engine engine) {
		this.engine = engine;	
	}

	@Override
	public String getCarColor() {
		return "Black";	
	}

	@Override
	public String getEngine() {
		return engine.getEngine();
	}
	
	public void myCustomInitMethod() {
		System.out.println("My custom Init method called");
	}
	
	public void myCustomDestroyMethod() {
		System.out.println("My custom Destroy method called");
	}
}
