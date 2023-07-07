package com.ems.dao;

import com.ems.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
