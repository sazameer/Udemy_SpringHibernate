package com.zam.ex3.javaConfig.car;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zam.ex3.javaConfig.car.impl.Hatchback;
import com.zam.ex3.javaConfig.car.impl.V12Engine;
import com.zam.ex3.javaConfig.car.impl.V6Engine;

@Configuration
public class CarConfig {
	
	@Bean
	public Engine V6Engine() {
		return new V12Engine();
	}
	
	@Bean
	public Car hatchback() {
		Car hatchback = new Hatchback(V6Engine());
		return hatchback;
	}

}
