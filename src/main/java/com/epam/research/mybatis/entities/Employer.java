package com.epam.research.mybatis.entities;

import lombok.Data;

import javax.persistence.*;


@Data
public class Employer {
    private int id;
    private String company;
}
