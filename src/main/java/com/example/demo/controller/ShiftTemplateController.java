package com.example.demo.controller;

import com.example.demo.model.ShiftTemplateEntity;
import com.example.demo.service.ShiftTemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shift-templates")
public class ShiftTemplateController {

    private final ShiftTemplateService service;

    public ShiftTemplateController(ShiftTemplateService service) {
        this.service = service;
    }

    @PostMapping("/{departmentId}")
    public ShiftTemplateEntity create(@PathVariable Long departmentId,
                                      @RequestBody ShiftTemplateEntity template) {
        return service.create(template, departmentId);
    }

    @GetMapping("/department/{departmentId}")
    public List<ShiftTemplateEntity> getByDepartment(@PathVariable Long departmentId) {
        return service.getByDepartment(departmentId);
    }
}
