package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    // define field for entityManager
    EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> typedQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // return the query result list
        return typedQuery.getResultList();
    }
}
