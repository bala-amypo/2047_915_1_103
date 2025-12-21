package com.example.demo.controller;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.service.AvailabilityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/availability")
@Tag(name = "Employee Availability Endpoints")
public class AvailabilityController {

    private final AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @PostMapping("/{employeeId}")
    @Operation(summary = "Set availability for employee")
    public ResponseEntity<EmployeeAvailability> create(@PathVariable Long employeeId, @RequestBody EmployeeAvailability availability) {
        return ResponseEntity.ok(availabilityService.create(employeeId, availability));
    }

    @GetMapping("/employee/{employeeId}")
    @Operation(summary = "Get availability by employee")
    public ResponseEntity<List<EmployeeAvailability>> getByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(availabilityService.getByEmployee(employeeId));
    }

    @GetMapping("/{availabilityId}")
    @Operation(summary = "Get specific availability")
    public ResponseEntity<EmployeeAvailability> get(@PathVariable Long availabilityId) {
        return ResponseEntity.ok(availabilityService.get(availabilityId));
    }

    @GetMapping("/date/{date}")
    @Operation(summary = "Get availability by date")
    public ResponseEntity<List<EmployeeAvailability>> getByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(availabilityService.getByDate(date));
    }
}
