package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {

		// 스프링에게 지시하는 방법으로 코드 변경
		// DI -> 부품조립 -> exam이라는 부품을 InlineExamConsole에 결합시켜 이용할 수도 있고 GridExamConsole에 결합시켜 이용할 수도 있다.
		// Inline을 쓰다가 Grid로 바꾸고 싶을 때 이를 소스코드 변경없이 간편하게 해주려면,
		// 코드로 하지 않고 외부에서 이를 변경해주는 설정이 있으면 된다.
		// 이런 일을 해주기 위해 변경을 외부설정에서 해주는 프레임워크가 스프링
		// 스프링에게 주문/조립 주문서를 작성해 줘야 한다. -> XML / Annotation 방식
		// Exam exam = new NewlecExam(); // 부품 / 생성
		// ExamConsole console = new InlineExamConsole(exam); // 생성자를 통해 부품조립 / 생성
		// ExamConsole console = new GridExamConsole(); // 생성
		// console.setExam(exam); // setter를 통해 부품 조립 / 결합
		
		
		// 부품을 생성하고 조립해서 나에게 던져주는 스프링 필요
		// 이 코드에서는 Exam과 console의 관계를 분리한다.
		// 지시서 읽어오는 코드 : 지시서를 읽어 온 후 지시서에 생성된 객체와 결합관계는 IoC 컨테이너에 담겨있다.
		// IoC 컨테이너의 이름이 context 
		ApplicationContext context =
				new AnnotationConfigApplicationContext(NewlecDIConfig.class);
				//new ClassPathXmlApplicationContext("spring/di/setting.xml");
		// 컨테이너인 context에서 객체들을 가져온다.
		// 1. 객체 이름(id)로 가져오면 object로 오기 때문에 형변환 해야됨
		ExamConsole console = (ExamConsole)context.getBean("console"); 
		// 2. 자료형명으로 가져온다.
		//ExamConsole console = context.getBean(ExamConsole.class);
		//Exam exam = context.getBean(Exam.class);
		//System.out.println(exam.toString()); // toString() 메소드는 print가 아니라 return 하기 때문에 print 메소드 안에 적어줘야 출력된다.
		console.print();
		
		//List<Exam> exams = (List<Exam>)context.getBean("exams"); // new ArrayList<>();
		// exams.add(new NewlecExam(1,1,1,1));
		
		//for(Exam e : exams)
			//System.out.println(e);
		
	}

}
