package com.example.demo.service.impl;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.ShiftTemplateRepository;
import com.example.demo.service.ShiftTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftTemplateServiceImpl implements ShiftTemplateService {

    private final ShiftTemplateRepository repository;

    public ShiftTemplateServiceImpl(ShiftTemplateRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShiftTemplate create(ShiftTemplate template) {
        if (template.getEndTime().isBefore(template.getStartTime()) ||
            template.getEndTime().equals(template.getStartTime())) {
            throw new RuntimeException("endTime must be after startTime");
        }

        repository.findByTemplateNameAndDepartment_Id(
                template.getTemplateName(),
                template.getDepartment().getId()
        ).ifPresent(t -> {
            throw new RuntimeException("Template name must be unique");
        });

        return repository.save(template);
    }

    @Override
    public List<ShiftTemplate> getByDepartment(Long departmentId) {
        return repository.findByDepartment_Id(departmentId);
    }
}
