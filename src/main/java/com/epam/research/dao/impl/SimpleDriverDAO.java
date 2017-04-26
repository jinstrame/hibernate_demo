package com.epam.research.dao.impl;

import com.epam.research.dao.CarDAO;
import com.epam.research.dao.DriverDAO;
import com.epam.research.entities.Car;
import com.epam.research.entities.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class SimpleDriverDAO implements DriverDAO {

    @Resource
    SessionFactory sessionFactory;


    @Transactional
    @SuppressWarnings("Duplicates")
    @Override
    public void save(Driver c) {
        Session session = sessionFactory.openSession();
        session.persist(c);
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Driver> list() {
        Session session = sessionFactory.openSession();
        List<Driver> drivers = session.createQuery("from com.epam.research.entities.Driver").list();
        session.close();
        return drivers;
    }
}
