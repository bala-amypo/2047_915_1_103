package com.example.demo.service.impl;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.*;
import com.example.demo.service.AvailabilityService;
import java.time.*;
import java.util.*;

public class AvailabilityServiceImpl implements AvailabilityService {

    private final AvailabilityRepository repo;
    private final EmployeeRepository empRepo;

    public AvailabilityServiceImpl(AvailabilityRepository repo,
                                   EmployeeRepository empRepo) {
        this.repo = repo;
        this.empRepo = empRepo;
    }

    public EmployeeAvailability create(EmployeeAvailability a) {
        Long empId = a.getEmployee().getId();
        if (repo.findByEmployee_IdAndAvailableDate(empId, a.getAvailableDate()).isPresent())
            throw new RuntimeException("exists");
        return repo.save(a);
    }

    public EmployeeAvailability update(Long id, EmployeeAvailability a) {
        EmployeeAvailability old = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        old.setAvailable(a.getAvailable());
        return repo.save(old);
    }

    public void delete(Long id) {
        repo.delete(repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found")));
    }

    public List<EmployeeAvailability> getByDate(LocalDate date) {
        return repo.findByAvailableDateAndAvailable(date, true);
    }
}
