package demo_20201028;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;

public class AOPDefinition implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String methodName = method.getName();
		System.out.println(target + "#" + methodName + Arrays.toString(args));
		System.out.println("something to do before core bussiness logic.");
		
	}

}
