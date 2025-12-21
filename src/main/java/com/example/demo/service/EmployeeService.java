package com.example.demo.service;

import com.example.demo.model.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeEntity create(EmployeeEntity employee);
    EmployeeEntity get(Long id);
    List<EmployeeEntity> getAll();
    void delete(Long id);
}
