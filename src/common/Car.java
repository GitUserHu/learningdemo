package common;

import java.io.Serializable;

public class Car implements Serializable {
	String brand;
	
	public Car(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}

}
