package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;

public class Program2 {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring/aop/setting.xml");
		
		Exam proxy = (Exam)context.getBean("proxy");
		
		System.out.printf("total is %d \n", proxy.total());
		System.out.println("------------------------------");
		System.out.printf("avg is %f \n", proxy.avg());
		//System.out.printf("total is %d \n", exam.total());
		
		System.out.println("Hellow GitHub");
		

	}

}
