package com.zam.ex3.javaConfig.car.impl;

import org.springframework.stereotype.Component;

import com.zam.ex2.annotations.car.Engine;

@Component
public class V6Engine implements Engine {

	@Override
	public String getEngine() {
		return "Twin Cylinder V6 Engine";
	}
}
