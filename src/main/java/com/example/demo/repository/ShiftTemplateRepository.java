package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ShiftTemplate;
import java.util.*;

public interface ShiftTemplateRepository extends JpaRepository<ShiftTemplate,Long> {
    Optional<ShiftTemplate> findByTemplateNameAndDepartment_Id(String name, Long id);
    List<ShiftTemplate> findByDepartment_Id(Long id);
}
