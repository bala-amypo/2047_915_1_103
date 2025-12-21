package com.example.demo.repository;

import com.example.demo.model.ShiftTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShiftTemplateRepository extends JpaRepository<ShiftTemplateEntity, Long> {
    Optional<ShiftTemplateEntity> findByTemplateNameAndDepartment_Id(String name, Long departmentId);
    List<ShiftTemplateEntity> findByDepartment_Id(Long departmentId);
}
