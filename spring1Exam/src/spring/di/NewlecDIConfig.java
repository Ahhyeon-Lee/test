package spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;

@ComponentScan("spring.di.ui") // = <context:component-scan base-package="spring.di.ui, spring.di.entity"/>
@Configuration // configuration 파일이라는 걸 알려주는 어노테이션
public class NewlecDIConfig {
	
	// @Bean을 통해 exam()에서 반환하는 NewlecExam을 IoC 컨테이너에 담는다.
	// exam()은 객체에서 id 역할을 한다.
	@Bean
	public Exam exam() {
		return new NewlecExam();
	}
	
}
