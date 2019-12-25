package com.zam.ex2.annotations.car.impl;

import org.springframework.stereotype.Component;

import com.zam.ex2.annotations.car.Engine;

@Component
public class V12Engine implements Engine {

	@Override
	public String getEngine() {
		return "Super Powerful Four Cylinder V12 Engine";
	}
}
