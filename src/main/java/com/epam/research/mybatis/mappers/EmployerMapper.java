package com.epam.research.mybatis.mappers;

import com.epam.research.mybatis.entities.Employee;
import com.epam.research.mybatis.entities.Employer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployerMapper {

    @Select("SELECT * FROM employer WHERE id = #{id}")
    Employer get(@Param("id") int id);

    @Select("SELECT * FROM employer")
    List<Employer> list();

    @Insert("INSERT INTO employer (company) VALUES (#{e.company})")
    void create(@Param("e") Employer e);
}
