package com.epam.research.dao;

import com.epam.research.entities.Car;
import com.epam.research.entities.Driver;

import java.util.List;

public interface DriverDAO {

    public void save(Driver c);

    public List<Driver> list();

}
