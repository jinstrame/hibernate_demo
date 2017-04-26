package com.epam.research;

import com.epam.research.hibernate.entities.Employee;
import com.epam.research.hibernate.entities.Employer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration("classpath:application-context.xml")
public class HibernateApplicationTests {

	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Test
	public void contextLoads() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();


		Employer employer = new Employer();
		employer.setCompany("epam");
		session.save(employer);

		Employee employee = new Employee();
		employee.setEmployer(employer);
		employee.setName("Eugene");
		session.save(employee);
		session.save(employer);
		tx.commit();

		System.out.println("//");
		System.out.println("//");
		List<Employee> employees = session.createQuery("from com.epam.research.hibernate.entities.Employee").list();
		employees.forEach(System.out::println);


		System.out.println("//");
		System.out.println("//");
		List<Employer> employers = session.createQuery("from com.epam.research.hibernate.entities.Employer").list();
		employers.forEach(System.out::println);

		System.out.println("//");
		System.out.println("//");
		List list = session.createQuery("from com.epam.research.hibernate.entities.Employee where employer_id = 1").list();
		list.forEach(System.out::println);


		System.out.println("//");
		System.out.println("//");
		session.close();
	}

}
