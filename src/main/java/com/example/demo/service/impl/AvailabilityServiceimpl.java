package com.example.demo.service.impl;

import com.example.demo.model.EmployeeAvailabilityEntity;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.AvailabilityRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AvailabilityService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    private final AvailabilityRepository availabilityRepository;
    private final EmployeeRepository employeeRepository;

    public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository,
                                   EmployeeRepository employeeRepository) {
        this.availabilityRepository = availabilityRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeAvailabilityEntity create(Long employeeId,
                                             EmployeeAvailabilityEntity availability) {

        EmployeeEntity employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("not found"));

        availabilityRepository
                .findByEmployee_IdAndAvailableDate(
                        employeeId, availability.getAvailableDate())
                .ifPresent(a -> {
                    throw new RuntimeException("exists");
                });

        availability.setEmployee(employee);
        return availabilityRepository.save(availability);
    }

    @Override
    public List<EmployeeAvailabilityEntity> getByEmployee(Long employeeId) {
        return availabilityRepository.findByEmployee_Id(employeeId);
    }

    @Override
    public List<EmployeeAvailabilityEntity> getByDate(LocalDate date) {
        return availabilityRepository.findByAvailableDateAndAvailable(date, true);
    }
}
