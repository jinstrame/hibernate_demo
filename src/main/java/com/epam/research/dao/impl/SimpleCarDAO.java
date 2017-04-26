package com.epam.research.dao.impl;

import com.epam.research.dao.CarDAO;
import com.epam.research.entities.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class SimpleCarDAO implements CarDAO {

    @Resource
    SessionFactory sessionFactory;

    @Transactional
    @SuppressWarnings("Duplicates")
    @Override
    public void save(Car c) {
        Session session = sessionFactory.openSession();

        session.persist(c);
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Car> list() {
        Session session = sessionFactory.openSession();
        List<Car> cars = session.createQuery("from com.epam.research.entities.Car").list();
        session.close();
        return cars;
    }
}
