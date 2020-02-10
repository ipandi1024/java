package com.woniuxy.k_di;

import java.io.Serializable;

public class Car implements Serializable {
	private String brand;
	private String color = "ºÚÉ«";
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + "]";
	}

}
