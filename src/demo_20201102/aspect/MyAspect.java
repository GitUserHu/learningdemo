package demo_20201102.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	/*NOTE: 切入点复用：再切面类中定义一个函数，上面加上@PointCut注解。*/
	@Pointcut("execution(* *test(..))")
	public void myPointCut() {}
	
	@Around("myPointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Annotation Aspect");
		return joinPoint.proceed();
	}
}
