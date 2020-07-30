package common;

import java.io.Serializable;

public class Person implements Serializable {
	String name;
	Car car;
	
	public Person(String name, Car car) {
		this.name = name;
		this.car = car;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", car=" + car + "]";
	}
	
}
