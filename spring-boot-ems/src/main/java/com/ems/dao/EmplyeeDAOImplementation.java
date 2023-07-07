package com.ems.dao;

import com.ems.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmplyeeDAOImplementation implements EmployeeDAO{

    // fields for entityManager
    private EntityManager entityManager;

    // constructor injection

    public EmplyeeDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        // execute query and getResultList
        List<Employee> employees = query.getResultList();

        // return result
        return employees;
    }

    @Override
    // find employee by id
    public Employee findById(int id) {
        // get the employee
        Employee theEmployee = entityManager.find(Employee.class, id);
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        // save the employee
        Employee theEmployee = entityManager.merge(employee);
        return theEmployee;
    }

    @Override
    public void deleteById(int id) {
        // find the employee
        Employee theEmployee = entityManager.find(Employee.class, id);

        // then delete
        entityManager.remove(theEmployee);
    }
}
