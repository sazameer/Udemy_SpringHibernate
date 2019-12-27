package com.zam.ex3.javaConfig.car.impl;

import org.springframework.stereotype.Component;

import com.zam.ex3.javaConfig.car.Engine;

@Component
public class V12Engine implements Engine {

	@Override
	public String getEngine() {
		return "Super Powerful Four Cylinder V12 Engine";
	}
}
