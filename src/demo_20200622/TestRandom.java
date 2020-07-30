package demo_20200622;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestRandom {

	public static void main(String[] args) {
		System.out.println(Math.random());
		Random random = new Random();
		int nextInt = random.nextInt(10)+1;
		System.out.println(ThreadLocalRandom.current().nextInt(10)+1);
		
	}

}
