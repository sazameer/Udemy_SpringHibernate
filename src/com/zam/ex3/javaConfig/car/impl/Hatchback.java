package com.zam.ex3.javaConfig.car.impl;

import com.zam.ex3.javaConfig.car.Car;
import com.zam.ex3.javaConfig.car.Engine;

public class Hatchback implements Car {
	
	
	private Engine engine;
	
	
	public Hatchback(Engine engine) {
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
