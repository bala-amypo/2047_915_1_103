package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleDto {

    private Long id;
    private LocalDate shiftDate;
    private LocalTime startTime;
    private LocalTime endTime;

    private Long employeeId;
    private String employeeName;

    private Long departmentId;
    private String departmentName;

    private Long shiftTemplateId;
    private String templateName;

    public ScheduleDto() {
    }

    public ScheduleDto(Long id,
                       LocalDate shiftDate,
                       LocalTime startTime,
                       LocalTime endTime,
                       Long employeeId,
                       String employeeName,
                       Long departmentId,
                       String departmentName,
                       Long shiftTemplateId,
                       String templateName) {
        this.id = id;
        this.shiftDate = shiftDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.shiftTemplateId = shiftTemplateId;
        this.templateName = templateName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(LocalDate shiftDate) {
        this.shiftDate = shiftDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getShiftTemplateId() {
        return shiftTemplateId;
    }

    public void setShiftTemplateId(Long shiftTemplateId) {
        this.shiftTemplateId = shiftTemplateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
