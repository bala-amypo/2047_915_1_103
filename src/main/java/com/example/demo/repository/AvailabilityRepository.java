package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.EmployeeAvailability;
import java.time.*;
import java.util.*;

public interface AvailabilityRepository extends JpaRepository<EmployeeAvailability,Long> {
    Optional<EmployeeAvailability> findByEmployee_IdAndAvailableDate(Long id, LocalDate date);
    List<EmployeeAvailability> findByAvailableDateAndAvailable(LocalDate date, boolean available);
    List<EmployeeAvailability> findByEmployee_Id(Long id);
}
