package com.example.demo.service;

import com.example.demo.model.DepartmentEntity;

import java.util.List;

public interface DepartmentService {
    DepartmentEntity create(DepartmentEntity department);
    DepartmentEntity get(Long id);
    List<DepartmentEntity> getAll();
    void delete(Long id);
}
