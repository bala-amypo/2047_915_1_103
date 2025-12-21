package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "generated_shift_schedule")
public class GeneratedShiftScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate shiftDate;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @ManyToOne(optional = false)
    private ShiftTemplateEntity shiftTemplate;

    @ManyToOne(optional = false)
    private DepartmentEntity department;

    @ManyToOne(optional = false)
    private EmployeeEntity employee;

    public GeneratedShiftScheduleEntity() {}

    public GeneratedShiftScheduleEntity(LocalDate shiftDate,
                                        LocalTime startTime,
                                        LocalTime endTime,
                                        ShiftTemplateEntity shiftTemplate,
                                        DepartmentEntity department,
                                        EmployeeEntity employee) {
        this.shiftDate = shiftDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shiftTemplate = shiftTemplate;
        this.department = department;
        this.employee = employee;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getShiftDate() { return shiftDate; }
    public void setShiftDate(LocalDate shiftDate) {
        this.shiftDate = shiftDate;
    }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public ShiftTemplateEntity getShiftTemplate() { return shiftTemplate; }
    public void setShiftTemplate(ShiftTemplateEntity shiftTemplate) {
        this.shiftTemplate = shiftTemplate;
    }

    public DepartmentEntity getDepartment() { return department; }
    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public EmployeeEntity getEmployee() { return employee; }
    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}
