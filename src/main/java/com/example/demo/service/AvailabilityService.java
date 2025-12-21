package com.example.demo.service;

import com.example.demo.model.EmployeeAvailabilityEntity;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityService {


    EmployeeAvailabilityEntity create(
            Long employeeId,
            EmployeeAvailabilityEntity availability
    );

    List<EmployeeAvailabilityEntity> getByEmployee(Long employeeId);

    List<EmployeeAvailabilityEntity> getByDate(LocalDate date);
}
