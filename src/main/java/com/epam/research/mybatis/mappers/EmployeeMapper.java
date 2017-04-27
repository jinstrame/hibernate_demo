package com.epam.research.mybatis.mappers;

import com.epam.research.mybatis.entities.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.Alias;

import java.util.List;

public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee get(@Param("id") int id);

    @Insert("INSERT INTO employee (name, employer_id) VALUES (#{e.name}, #{emp_id})")
    void create(@Param("e") Employee employee, @Param("emp_id") int employer_id);

    default void create(Employee employee) {
        create(employee, employee.getEmployer().getId());
    }

    @Select("SELECT * FROM employee WHERE employer_id = #{emp_id}")
    List<Employee> getByEmployer(@Param("emp_id") int id);

    @Select("SELECT * FROM employee")
    List<Employee> list();
}
