package com.example.demo.service.impl;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeEntity create(EmployeeEntity employee) {
        if (repository.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("exists");
        }
        if (employee.getMaxWeeklyHours() <= 0) {
            throw new RuntimeException("must");
        }
        return repository.save(employee);
    }

    @Override
    public EmployeeEntity get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<EmployeeEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("not found");
        }
        repository.deleteById(id);
    }
}
