package com.example.demo.service.impl;

import com.example.demo.model.DepartmentEntity;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public DepartmentEntity create(DepartmentEntity department) {
        if (repository.existsByName(department.getName())) {
            throw new RuntimeException("exists");
        }
        return repository.save(department);
    }

    @Override
    public DepartmentEntity get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<DepartmentEntity> getAll() {
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
