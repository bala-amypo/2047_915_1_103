package com.example.demo.controller;

import com.example.demo.model.DepartmentEntity;
import com.example.demo.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public DepartmentEntity create(@RequestBody DepartmentEntity department) {
        return service.create(department);
    }

    @GetMapping("/{id}")
    public DepartmentEntity get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<DepartmentEntity> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted";
    }
}
