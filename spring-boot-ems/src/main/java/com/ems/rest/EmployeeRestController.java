package com.ems.rest;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    // add new employee : POST request
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){   // employee data is coming through the request body in json format-) that why @RequestBody

        // if id!= 0, then this will be treated as an update.
        // to avoid this,initially set the employee id to zero.
        // then it'll force to save a new item instead of update
        employee.setId(0);
        Employee newEmployee = employeeService.save(employee);
        return newEmployee;
    }

    // update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.save(employee);
        return updatedEmployee;
    }

    // delete employee
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
//        Employee deleteEmployee = employeeService.findById(employeeId);
        employeeService.deleteById(employeeId);
    }

}
