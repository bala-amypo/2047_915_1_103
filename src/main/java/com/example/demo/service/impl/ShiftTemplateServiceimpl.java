package com.example.demo.service.impl;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.*;
import com.example.demo.service.ShiftTemplateService;
import java.util.*;

public class ShiftTemplateServiceImpl implements ShiftTemplateService {

    private final ShiftTemplateRepository repo;
    private final DepartmentRepository deptRepo;

    public ShiftTemplateServiceImpl(ShiftTemplateRepository repo,
                                   DepartmentRepository deptRepo) {
        this.repo = repo;
        this.deptRepo = deptRepo;
    }

    public ShiftTemplate create(ShiftTemplate t) {
        if (t.getEndTime().isBefore(t.getStartTime()))
            throw new RuntimeException("after");

        Long deptId = t.getDepartment().getId();
        if (repo.findByTemplateNameAndDepartment_Id(t.getTemplateName(), deptId).isPresent())
            throw new RuntimeException("unique");

        return repo.save(t);
    }

    public List<ShiftTemplate> getByDepartment(Long departmentId) {
        return repo.findByDepartment_Id(departmentId);
    }
}
