package com.example.demo.repository;

import com.example.demo.model.EmployeeAvailabilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AvailabilityRepository extends JpaRepository<EmployeeAvailabilityEntity, Long> {
    Optional<EmployeeAvailabilityEntity> findByEmployee_IdAndAvailableDate(Long employeeId, LocalDate date);
    List<EmployeeAvailabilityEntity> findByEmployee_Id(Long employeeId);
    List<EmployeeAvailabilityEntity> findByAvailableDateAndAvailable(LocalDate date, boolean available);
}
