package demo_20201028;


import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibDynamicProxy {

	public static void main(String[] args) {
		OriginObject originObject = new OriginObject();
		Enhancer enhancer = new Enhancer();
		enhancer.setClassLoader(ClassLoader.getSystemClassLoader());
		enhancer.setSuperclass(OriginObject.class);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				System.out.println("111");
				Object invoke = arg1.invoke(originObject, arg2);
				return invoke;
			}
		});
		
		OriginObject create = (OriginObject) enhancer.create();
		create.test();
	}

}
