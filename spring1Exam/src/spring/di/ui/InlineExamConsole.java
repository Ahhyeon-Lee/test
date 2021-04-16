package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {

	private Exam exam;
	
	// 생성자
	public InlineExamConsole() {}
	
	// Exam을 implements하는 다양한 학생의 성적을 매개변수로 넣을 수 있기 때문에 DI에 적합
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}


	@Override
	public void print() {
		System.out.printf("total is %d, avg is %f \n", exam.total(), exam.avg());
	}
	
	@Autowired
	// autowired:자동으로 객체를 연결해달라는 의미
	// xml에서 객체를 찾으면 autowired 된 애를 먼저 찾는다.
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;		
	}

}
