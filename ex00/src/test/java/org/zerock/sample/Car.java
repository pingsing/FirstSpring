package org.zerock.sample;

public class Car {
	// 스프링 컨테이너 추가
	
	// 1. 어노테이션 등록
	// 2. 스프링 컨테이너(root-context)에 직접 등록
	
	private String model;

	public Car(String model) {
		super();
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
}
