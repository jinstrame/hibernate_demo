package com.epam.research.dao;

import com.epam.research.entities.Car;

import java.util.List;

public interface CarDAO {

    public void save(Car c);

    public List<Car> list();

}
