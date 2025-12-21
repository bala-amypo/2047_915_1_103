package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;
import java.time.*;
import java.util.*;

public class ScheduleServiceImpl implements ScheduleService {

    private final ShiftTemplateRepository templateRepo;
    private final AvailabilityRepository availabilityRepo;
    private final EmployeeRepository employeeRepo;
    private final GeneratedShiftScheduleRepository scheduleRepo;
    private final DepartmentRepository departmentRepo;

    public ScheduleServiceImpl(
            ShiftTemplateRepository t,
            AvailabilityRepository a,
            EmployeeRepository e,
            GeneratedShiftScheduleRepository s,
            DepartmentRepository d) {
        this.templateRepo = t;
        this.availabilityRepo = a;
        this.employeeRepo = e;
        this.scheduleRepo = s;
        this.departmentRepo = d;
    }

    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {
        List<GeneratedShiftSchedule> out = new ArrayList<>();

        var avs = availabilityRepo.findByAvailableDateAndAvailable(date, true);
        for (Department d : departmentRepo.findAll()) {
            for (ShiftTemplate st : templateRepo.findByDepartment_Id(d.getId())) {
                for (EmployeeAvailability av : avs) {
                    if (av.getEmployee().getSkills()
                            .containsAll(st.getRequiredSkills())) {
                        GeneratedShiftSchedule g = new GeneratedShiftSchedule();
                        g.setShiftDate(date);
                        g.setEmployee(av.getEmployee());
                        g.setDepartment(d);
                        g.setShiftTemplate(st);
                        out.add(scheduleRepo.save(g));
                        break;
                    }
                }
            }
        }
        return out;
    }

    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {
        return scheduleRepo.findByShiftDate(date);
    }
}
