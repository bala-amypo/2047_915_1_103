package com.example.demo.service.impl;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.AvailabilityRepository;
import com.example.demo.service.AvailabilityService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    private final AvailabilityRepository repository;

    public AvailabilityServiceImpl(AvailabilityRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeAvailability create(EmployeeAvailability availability) {
        repository.findByEmployee_IdAndAvailableDate(
                availability.getEmployee().getId(),
                availability.getAvailableDate()
        ).ifPresent(a -> {
            throw new RuntimeException("Availability already exists");
        });

        return repository.save(availability);
    }

    @Override
    public EmployeeAvailability update(Long id, EmployeeAvailability availability) {
        EmployeeAvailability existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Availability not found"));

        existing.setAvailable(availability.getAvailable());
        existing.setAvailableDate(availability.getAvailableDate());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        EmployeeAvailability av = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Availability not found"));
        repository.delete(av);
    }

    @Override
    public List<EmployeeAvailability> getByDate(LocalDate date) {
        return repository.findByAvailableDateAndAvailable(date, true);
    }
}
