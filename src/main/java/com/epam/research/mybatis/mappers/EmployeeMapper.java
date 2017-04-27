package com.epam.research.mybatis.mappers;

import com.epam.research.hibernate.entities.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee get(@Param("id") int id);

    @Insert("INSERT INTO employee (name, employer_id) VALUES (#{e.name}, #{e.employer})")
    void create(@Param("e") Employee e);

    @Select("SELECT * FROM employee WHERE employer_id = #{id}")
    List<Employee> getByEmployer(@Param("id") int id);
}
