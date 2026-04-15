package spring.auto_wired.src.main.java.com.example.auto_wired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		
		//autowire =byType
		// Car car = (Car) context.getBean("car1");
		// System.out.println(car.toString());
		// car.getEngine().start();

		//Collections
		// Student stu = (Student) context.getBean("student1");
		// System.out.println(stu.toString());

		//Bean Scope
		// Item it = (Item) context.getBean("s1");
		// System.out.println(it.toString());

		// Inner Bean
		// Department dept = (Department) context.getBean("dept1");
		// System.out.println(dept.toString());

		//Spring bean life cycle
		Employee emp = (Employee) context.getBean("emp");
		System.out.println(emp.toString());

		((ClassPathXmlApplicationContext) context).registerShutdownHook();
	}
}
