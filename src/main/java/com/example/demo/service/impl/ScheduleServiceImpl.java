package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final DepartmentRepository departmentRepository;
    private final ShiftTemplateRepository templateRepository;
    private final AvailabilityRepository availabilityRepository;
    private final GeneratedShiftScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(DepartmentRepository departmentRepository,
                               ShiftTemplateRepository templateRepository,
                               AvailabilityRepository availabilityRepository,
                               GeneratedShiftScheduleRepository scheduleRepository) {
        this.departmentRepository = departmentRepository;
        this.templateRepository = templateRepository;
        this.availabilityRepository = availabilityRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {
        List<GeneratedShiftSchedule> result = new ArrayList<>();

        for (Department dept : departmentRepository.findAll()) {
            for (ShiftTemplate template : templateRepository.findByDepartment_Id(dept.getId())) {
                availabilityRepository.findByAvailableDateAndAvailable(date, true)
                        .stream()
                        .findFirst()
                        .ifPresent(av -> {
                            GeneratedShiftSchedule gs = new GeneratedShiftSchedule(
                                    date,
                                    template.getStartTime(),
                                    template.getEndTime(),
                                    template,
                                    dept,
                                    av.getEmployee()
                            );
                            result.add(scheduleRepository.save(gs));
                        });
            }
        }
        return result;
    }

    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {
        return scheduleRepository.findByShiftDate(date);
    }
}
