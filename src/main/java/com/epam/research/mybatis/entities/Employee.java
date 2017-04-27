package com.epam.research.mybatis.entities;


import lombok.Data;

import javax.persistence.*;

@Data
public class Employee {
    private int employee_id;
    private String name;
    private Employer employer;
}
