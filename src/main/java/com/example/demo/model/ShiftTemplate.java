package com.example.demo.model;

import jakarta.persistence.*;
import java.time.*;
import java.util.*;

@Entity
public class ShiftTemplate {

    @Id
    @GeneratedValue
    private Long id;

    private String templateName;
    private LocalTime startTime;
    private LocalTime endTime;
    private String requiredSkills;

    @ManyToOne
    private Department department;

    public ShiftTemplate() {}

    public ShiftTemplate(String name, LocalTime s, LocalTime e, String skills, Department d) {
        this.templateName = name;
        this.startTime = s;
        this.endTime = e;
        this.requiredSkills = skills;
        this.department = d;
    }

    public Set<String> getRequiredSkills() {
        if (requiredSkills == null) return Set.of();
        return new HashSet<>(Arrays.asList(requiredSkills.split(",")));
    }

    public String getTemplateName() { return templateName; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
}
