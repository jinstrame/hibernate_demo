package com.epam.research;

import com.epam.research.dao.CarDAO;
import com.epam.research.dao.DriverDAO;
import com.epam.research.entities.Car;
import com.epam.research.entities.Driver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.ZonedDateTime;
import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration("classpath:application-context.xml")
public class HibernateApplicationTests {

	@Resource
	private CarDAO carDAO;

    @Resource
    private DriverDAO driverDAO;

	@Test
	public void contextLoads() {
		Car car = new Car();
		Driver driver = new Driver();

		driver.setAge(20);
		driver.setFirstName("John");
		driver.setLastName("Smith");
		driver.setDriver_id(7896);
        
        car.setNumber("S501W");
        car.setId(12);

        driverDAO.save(driver);
        carDAO.save(car);

        carDAO.list().forEach(System.out::println);

	}

}
