package com.example.demo.model;

import jakarta.persistence.*;
import java.time.*;

@Entity
public class GeneratedShiftSchedule {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate shiftDate;
    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Department department;

    @ManyToOne
    private ShiftTemplate shiftTemplate;

    public GeneratedShiftSchedule() {}

    public LocalDate getShiftDate() { return shiftDate; }
    public void setShiftDate(LocalDate d) { this.shiftDate = d; }
}
