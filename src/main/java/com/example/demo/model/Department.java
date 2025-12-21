package com.example.demo.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private String requiredSkills;

    public Department() {}

    public Department(String name, String description, String skills) {
        this.name = name;
        this.description = description;
        this.requiredSkills = skills;
    }

    public Set<String> getRequiredSkills() {
        if (requiredSkills == null) return Set.of();
        return new HashSet<>(Arrays.asList(requiredSkills.split(",")));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
}
