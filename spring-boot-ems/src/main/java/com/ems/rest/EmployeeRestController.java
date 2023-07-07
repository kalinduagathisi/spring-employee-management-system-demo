package com.ems.rest;

import com.ems.dao.EmployeeDAO;
import com.ems.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {

    // define field for EmployeeDAO
    private EmployeeDAO employeeDAO;

    // injecting employeeDAO using constructor injection
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // return list fo employees when exposed to "/employees"
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

}
