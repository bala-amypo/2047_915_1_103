package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
    name = "employee_availability",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"employee_id", "availableDate"}
    )
)
public class EmployeeAvailabilityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @Column(nullable = false)
    private LocalDate availableDate;

    @Column(nullable = false)
    private Boolean available = true;

    public EmployeeAvailabilityEntity() {}

    public EmployeeAvailabilityEntity(LocalDate availableDate, Boolean available) {
        this.availableDate = availableDate;
        this.available = available;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public EmployeeEntity getEmployee() { return employee; }
    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public LocalDate getAvailableDate() { return availableDate; }
    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
