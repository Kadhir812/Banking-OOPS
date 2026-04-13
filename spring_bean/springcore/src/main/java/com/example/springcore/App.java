package spring_bean.springcore.src.main.java.com.example.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
            Employee e1 = (Employee) context.getBean("emp1");
            Employee e2 = (Employee) context.getBean("emp2");

            Department d1 = (Department) context.getBean("dept1");
            Address a1 = (Address) context.getBean("addr1");
            Project p1 = (Project) context.getBean("proj1");

            System.out.println(e1.toString());
            System.out.println(e2.toString());
            System.out.println(d1.toString());
            System.out.println(a1.toString());
            System.out.println(p1.toString());
    }
}
