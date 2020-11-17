package demo_20201028;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy {

	public static void main(String[] args) throws Exception {
		
		Origin origin = new OriginObject();
		Origin newProxyInstance = (Origin)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), OriginObject.class.getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("111");
				Object invoke = method.invoke(origin, args);
				return invoke;
			}
		});
		newProxyInstance.test3();

	}

}
