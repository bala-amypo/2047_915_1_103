package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee createEmployee(Employee e) {
        if (repo.existsByEmail(e.getEmail()))
            throw new RuntimeException("exists");
        if (e.getMaxWeeklyHours() <= 0)
            throw new RuntimeException("must");
        return repo.save(e);
    }

    public Employee getEmployee(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public Employee updateEmployee(Long id, Employee e) {
        Employee old = getEmployee(id);
        old.setFullName(e.getFullName());
        return repo.save(old);
    }

    public void deleteEmployee(Long id) {
        repo.delete(getEmployee(id));
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee findByEmail(String email) {
        return repo.findByEmail(email).orElseThrow();
    }
}
