package com.epam.research.hibernate.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue
    private int employee_id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private Employer employer;
}
