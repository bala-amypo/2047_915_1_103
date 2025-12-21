package com.example.demo.service;

import com.example.demo.model.GeneratedShiftScheduleEntity;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {

    List<GeneratedShiftScheduleEntity> generateForDate(LocalDate date);

    List<GeneratedShiftScheduleEntity> getByDate(LocalDate date);
}
