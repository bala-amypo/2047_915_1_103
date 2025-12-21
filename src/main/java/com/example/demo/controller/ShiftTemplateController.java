package com.example.demo.controller;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.service.ShiftTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
@Tag(name = "Shift Templates Endpoints")
public class ShiftTemplateController {

    private final ShiftTemplateService shiftTemplateService;

    public ShiftTemplateController(ShiftTemplateService shiftTemplateService) {
        this.shiftTemplateService = shiftTemplateService;
    }

    @PostMapping("/department/{departmentId}")
    @Operation(summary = "Create shift template for department")
    public ResponseEntity<ShiftTemplate> create(@PathVariable Long departmentId, @RequestBody ShiftTemplate template) {
        template.setDepartment(null); // service layer will assign department
        return ResponseEntity.ok(shiftTemplateService.create(template, departmentId));
    }

    @GetMapping
    @Operation(summary = "Get all shift templates")
    public ResponseEntity<List<ShiftTemplate>> getAll() {
        return ResponseEntity.ok(shiftTemplateService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get shift template by ID")
    public ResponseEntity<ShiftTemplate> get(@PathVariable Long id) {
        return ResponseEntity.ok(shiftTemplateService.get(id));
    }

    @GetMapping("/department/{departmentId}")
    @Operation(summary = "Get templates by department")
    public ResponseEntity<List<ShiftTemplate>> getByDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(shiftTemplateService.getByDepartment(departmentId));
    }
}
