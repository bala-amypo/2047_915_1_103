package com.example.demo.service.impl;

import com.example.demo.model.DepartmentEntity;
import com.example.demo.model.ShiftTemplateEntity;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ShiftTemplateRepository;
import com.example.demo.service.ShiftTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftTemplateServiceImpl implements ShiftTemplateService {

    private final ShiftTemplateRepository templateRepository;
    private final DepartmentRepository departmentRepository;

    public ShiftTemplateServiceImpl(ShiftTemplateRepository templateRepository,
                                    DepartmentRepository departmentRepository) {
        this.templateRepository = templateRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ShiftTemplateEntity create(ShiftTemplateEntity template, Long departmentId) {
        if (!template.getEndTime().isAfter(template.getStartTime())) {
            throw new RuntimeException("after");
        }

        DepartmentEntity department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("not found"));

        templateRepository
                .findByTemplateNameAndDepartment_Id(
                        template.getTemplateName(), departmentId)
                .ifPresent(t -> {
                    throw new RuntimeException("unique");
                });

        template.setDepartment(department);
        return templateRepository.save(template);
    }

    @Override
    public List<ShiftTemplateEntity> getByDepartment(Long departmentId) {
        return templateRepository.findByDepartment_Id(departmentId);
    }
}
