package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.GeneratedShiftSchedule;
import java.time.*;
import java.util.*;

public interface GeneratedShiftScheduleRepository
        extends JpaRepository<GeneratedShiftSchedule,Long> {

    List<GeneratedShiftSchedule> findByShiftDate(LocalDate date);
}
