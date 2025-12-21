package com.example.demo.model;

import jakarta.persistence.*;
import java.time.*;

@Entity
public class EmployeeAvailability {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Employee employee;

    private LocalDate availableDate;
    private Boolean available = true;

    public EmployeeAvailability() {}

    public EmployeeAvailability(Employee e, LocalDate d, Boolean a) {
        this.employee = e;
        this.availableDate = d;
        this.available = a;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Employee getEmployee() { return employee; }
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean a) { this.available = a; }
}
