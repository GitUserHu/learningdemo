package demo_20201106.transaction.aop;

import java.lang.reflect.Method;
import java.sql.Connection;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class MyTXN implements MethodInterceptor{

	
	@Override
	public Object intercept(Object arg0, Method method, Object[] arg2, MethodProxy arg3) throws Throwable {
		
		Object invoke = method.invoke(arg0, arg2);
		
		return invoke;
	}

}
