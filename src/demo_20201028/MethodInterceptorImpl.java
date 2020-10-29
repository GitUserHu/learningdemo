package demo_20201028;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodInterceptorImpl implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		beforeMethod(invocation);
		Object result = null;
		try {
			result = invocation.proceed();
		} catch (Exception e) {
			System.out.println("Exception occurred...");
		}
		
		System.out.println("after");
		return "2";
	}
	
	public void beforeMethod(MethodInvocation invocation) {
		Class<?> declaringClass = invocation.getMethod().getDeclaringClass();
		Object[] arguments = invocation.getArguments();
		String methodName = invocation.getMethod().getName();
		System.out.println("before " + declaringClass+"#"+ methodName + Arrays.toString(arguments));
	}

}
