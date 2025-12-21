package com.example.demo.service.impl;

import com.example.demo.model.GeneratedShiftScheduleEntity;
import com.example.demo.repository.GeneratedShiftScheduleRepository;
import com.example.demo.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final GeneratedShiftScheduleRepository repository;

    public ScheduleServiceImpl(GeneratedShiftScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GeneratedShiftScheduleEntity> generateForDate(LocalDate date) {
        // scheduling logic can be added later
        return List.of();
    }

    @Override
    public List<GeneratedShiftScheduleEntity> getByDate(LocalDate date) {
        return repository.findByShiftDate(date);
    }
}
