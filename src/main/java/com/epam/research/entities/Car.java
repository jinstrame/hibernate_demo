package com.epam.research.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Car {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String number;

    @Column
    private int driver_id;
}
