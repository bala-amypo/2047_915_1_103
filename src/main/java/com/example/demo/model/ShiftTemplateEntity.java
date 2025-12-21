package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(
    name = "shift_templates",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"templateName", "department_id"}
    )
)
public class ShiftTemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String templateName;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    private String requiredSkills;

    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

    public ShiftTemplateEntity() {}

    public ShiftTemplateEntity(String templateName, LocalTime startTime,
                               LocalTime endTime, String requiredSkills) {
        this.templateName = templateName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.requiredSkills = requiredSkills;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getRequiredSkills() { return requiredSkills; }
    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public DepartmentEntity getDepartment() { return department; }
    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }
}
