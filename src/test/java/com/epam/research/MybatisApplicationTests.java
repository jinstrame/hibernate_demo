package com.epam.research;

import com.epam.research.mybatis.entities.Employee;
import com.epam.research.mybatis.entities.Employer;
import com.epam.research.mybatis.mappers.EmployeeMapper;
import com.epam.research.mybatis.mappers.EmployerMapper;
import org.apache.ibatis.session.SqlSession;
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
import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration("classpath:application-context.xml")
public class MybatisApplicationTests {

	@Resource
	private SqlSession mybatisSqlSession;

	@SuppressWarnings("unchecked")
	@Test
	public void contextLoads() {

		EmployerMapper employerMapper = mybatisSqlSession.getMapper(EmployerMapper.class);
		EmployeeMapper employeeMapper = mybatisSqlSession.getMapper(EmployeeMapper.class);

		Employer employer = new Employer();
		employer.setCompany("epam");

		employerMapper.create(employer);
		List<Employer> list = employerMapper.list();

		list.forEach(System.out::println);
		Employer returnedEmployer = list.stream().findAny().orElseThrow(NoSuchElementException::new);

		System.out.println("//");
		System.out.println("//");

		Employee employee = new Employee();
		employee.setName("Eugene");
		employee.setEmployer(returnedEmployer);

		employeeMapper.create(employee);

		List<Employee> byEmployer = employeeMapper.getByEmployer(returnedEmployer.getId());
		byEmployer.forEach(System.out::println);

        System.out.println("//");
        System.out.println("//");

		List<Employee> list1 = employeeMapper.list();
		list1.forEach(System.out::println);

		System.out.println("//");
		System.out.println("//");
	}

}
