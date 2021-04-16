package spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// cross-cutting concern
		long start = System.currentTimeMillis();
		
		// core-concern 로직 호출
		Object result = invocation.proceed();
		
		// cross-cutting concern
		long end = System.currentTimeMillis();
		String message = (end - start) + "ms 시간이 걸렸습니다.";	
		System.out.println(message);
		
		return result;
	}
	
	

}
