package com.example.demo.repository;

import com.example.demo.model.GeneratedShiftScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface GeneratedShiftScheduleRepository
        extends JpaRepository<GeneratedShiftScheduleEntity, Long> {

    List<GeneratedShiftScheduleEntity> findByShiftDate(LocalDate date);
}
