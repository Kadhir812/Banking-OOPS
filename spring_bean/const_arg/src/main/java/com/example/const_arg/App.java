package spring.const_arg.src.main.java.com.example.const_arg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext cont = new ClassPathXmlApplicationContext("bean.xml");

		Student student = (Student) cont.getBean("student1");
		College college = (College) cont.getBean("college1");

		System.out.println(student.toString());
		System.out.println(college.toString());
	}
}
