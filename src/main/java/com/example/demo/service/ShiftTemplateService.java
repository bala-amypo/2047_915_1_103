package com.example.demo.service;

import com.example.demo.model.ShiftTemplateEntity;

import java.util.List;

public interface ShiftTemplateService {
    ShiftTemplateEntity create(ShiftTemplateEntity template, Long departmentId);
    List<ShiftTemplateEntity> getByDepartment(Long departmentId);
}
