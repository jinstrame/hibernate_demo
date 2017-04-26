package com.epam.research.hibernate.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table
public class Employer {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    @Column
    private String company;
}
