package com.samuel.dynamodb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.samuel.dynamodb.model.Employee;

@Repository
public class EmployeeRepository {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public EmployeeRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Employee save(Employee employee) {
        dynamoDBMapper.save(employee);
        return employee;
    }

    public Employee getById(String employeeId) {
        return dynamoDBMapper.load(Employee.class, employeeId);
    }
/*
    public Employee findAll(String employeeId) {
        return dynamoDBMapper.q
    }*/

    public void delete(String employeeId) {
        Employee employee = dynamoDBMapper.load(Employee.class, employeeId);
        dynamoDBMapper.delete(employee);
    }

    public Employee update(Employee employee, String employeeId) {
        dynamoDBMapper.save(employee, 
                new DynamoDBSaveExpression()
                .withExpectedEntry("employeeId",
                        new ExpectedAttributeValue(new AttributeValue().withS(employeeId))));
        
        return employee;
    }

}
