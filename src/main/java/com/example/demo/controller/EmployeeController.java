package com.example.demo.controller;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeEntity create(@RequestBody EmployeeEntity employee) {
        return service.create(employee);
    }

    @GetMapping("/{id}")
    public EmployeeEntity get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<EmployeeEntity> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted";
    }
}
