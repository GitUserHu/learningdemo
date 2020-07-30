package demo_20200410;

import java.io.IOException;

import common.Car;
import common.Person;
import util.CloneUtil;

public class Test_Clone {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Person person1 = new Person("Test", new Car("BMW"));
		Person clonedPerson = CloneUtil.clone(person1);
		clonedPerson.getCar().setBrand("GTR");
		System.out.println(person1);
		System.out.println(clonedPerson);
	}

}
