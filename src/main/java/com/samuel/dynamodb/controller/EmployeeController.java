package com.samuel.dynamodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samuel.dynamodb.model.Employee;
import com.samuel.dynamodb.repository.EmployeeRepository;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") String employeeId) {
        return employeeRepository.getById(employeeId);
    }
    /*
    @GetMapping
    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }*/
    
    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    
    @PutMapping
    public void delete(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }
}
