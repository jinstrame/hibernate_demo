package com.epam.research.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Driver {
    @Id
    private int driver_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private int age;

    @Column
    private Car car;
}
