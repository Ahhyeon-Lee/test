package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("con")
public class GridExamConsole implements ExamConsole {

	// 기본 생성자를 호출하면서 injection이 된다.
	// 기본 생성자가 없으면 필드에 Autowired를 연결해줘도 연결이 안된다.
	// 생성자를 overload 하고 기본 생성자가 없는 경우, 기본이 없어도 아무튼 생성자가 있긴 하기 때문에 연결이 안된다.
	// 하지만 아예 생성자가 없는 경우라면 자동으로 자바는 기본 생성자를 호출하기 때문에 자동 생성되어 annotation이 연결된다.	
	
	@Autowired // 예외처리 가능하도록 하는 Autowired의 속성
	//@Qualifier("exam10")
	private Exam exam;
	
	// 생성자
	public GridExamConsole() {
		System.out.println("기본 생성자");
	}
	
	
	// Exam을 implements하는 다양한 학생의 성적을 매개변수로 넣을 수 있기 때문에 DI에 적합
	
	public GridExamConsole(Exam exam) {
		System.out.println("overload 생성자 injection");
		this.exam = exam;
	}

	
	@Override
	public void print() {
		if (exam == null)
			System.out.printf("total is %d \\ avg is %f \n", 0, 0.0); // 예외처리
		else
			System.out.printf("total is %d \\ avg is %f \n", exam.total(), exam.avg());
	}

	
	// 여기에 Autowired를 하면 setter 함수로 injection이 된다.
	// autowired:자동으로 객체를 연결해달라는 의미
	// xml에서 객체를 찾으면 autowired 된 애를 먼저 찾는다.	
	
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter 함수 injection");
		this.exam = exam;		
	}

}
