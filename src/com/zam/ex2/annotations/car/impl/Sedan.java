package com.zam.ex2.annotations.car.impl;

import org.springframework.stereotype.Component;

import com.zam.ex2.annotations.car.Car;
import com.zam.ex2.annotations.car.Engine;

@Component
public class Sedan implements Car {

	private String carType;
	private String carModel;	
	private Engine engine; 
	
	public void setCarType(String carType) {
		System.out.println("Setting Car Type : " + carType);
		this.carType = carType;
	}

	public void setCarModel(String carModel) {
		System.out.println("Setting Car Model : " + carModel);
		this.carModel = carModel;
	}

	public void setEngine(Engine engine) {
		System.out.println("Setting Car Engine : " + engine);
		this.engine = engine;
	}

	@Override
	public String getCarColor() {
		return "Red";
	}

	@Override
	public String getEngine() {
		return engine.getEngine();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Car Type	 : " + this.carType + "\n");
		sb.append("Car Model : " + this.carModel + "\n");
		sb.append("Car Color : " + getCarColor() + "\n");
		sb.append("Engine	 : " + getEngine() + "\n");
		
		return sb.toString();
	}
}
