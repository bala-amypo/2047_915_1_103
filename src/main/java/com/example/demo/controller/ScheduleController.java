package com.example.demo.controller;

import com.example.demo.model.GeneratedShiftScheduleEntity;
import com.example.demo.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService service;

    public ScheduleController(ScheduleService service) {
        this.service = service;
    }

    @PostMapping("/generate/{date}")
    public List<GeneratedShiftScheduleEntity> generate(@PathVariable LocalDate date) {
        return service.generateForDate(date);
    }

    @GetMapping("/date/{date}")
    public List<GeneratedShiftScheduleEntity> getByDate(@PathVariable LocalDate date) {
        return service.getByDate(date);
    }
}
