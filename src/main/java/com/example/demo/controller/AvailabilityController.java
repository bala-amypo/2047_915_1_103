package com.example.demo.controller;

import com.example.demo.model.EmployeeAvailabilityEntity;
import com.example.demo.service.AvailabilityService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    private final AvailabilityService service;

    public AvailabilityController(AvailabilityService service) {
        this.service = service;
    }

    @PostMapping("/{employeeId}")
    public EmployeeAvailabilityEntity create(@PathVariable Long employeeId,
                                             @RequestBody EmployeeAvailabilityEntity availability) {
        return service.create(employeeId, availability);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeAvailabilityEntity> getByEmployee(@PathVariable Long employeeId) {
        return service.getByEmployee(employeeId);
    }

    @GetMapping("/date/{date}")
    public List<EmployeeAvailabilityEntity> getByDate(@PathVariable LocalDate date) {
        return service.getByDate(date);
    }
}
