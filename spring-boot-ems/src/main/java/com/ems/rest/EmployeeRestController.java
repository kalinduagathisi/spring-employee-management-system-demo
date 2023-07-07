package com.ems.rest;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {

    // define field for EmployeeDAO
    private EmployeeService employeeService;

    // injecting employeeDAO using constructor injection
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // return list fo employees when exposed to "/employees"
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    
    // get employee by id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee==null){
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }
        return theEmployee;
    }

}
