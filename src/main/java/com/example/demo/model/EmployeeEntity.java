package com.example.demo.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String fullName;
    private String email;
    private String role;
    private String skills;
    private Integer maxWeeklyHours;

    public Employee() {}

    public Employee(String fullName, String email, String role, String skills, Integer maxWeeklyHours) {
        this.fullName = fullName;
        this.email = email;
        this.role = role == null ? "STAFF" : role;
        this.skills = skills;
        this.maxWeeklyHours = maxWeeklyHours;
    }

    public Set<String> getSkills() {
        if (skills == null) return Set.of();
        return new HashSet<>(Arrays.asList(skills.split(",")));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String n) { this.fullName = n; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public Integer getMaxWeeklyHours() { return maxWeeklyHours; }
}
