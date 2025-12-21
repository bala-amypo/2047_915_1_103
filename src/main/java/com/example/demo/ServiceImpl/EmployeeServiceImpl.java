package com.example.demo.ServiceImpl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        if (employee.getMaxWeeklyHours() == null || employee.getMaxWeeklyHours() <= 0) {
            throw new RuntimeException("maxWeeklyHours must be greater than zero");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = getEmployee(id);

        if (!existing.getEmail().equals(employee.getEmail()) &&
                employeeRepository.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        existing.setFullName(employee.getFullName());
        existing.setEmail(employee.getEmail());
        existing.setRole(employee.getRole());
        existing.setSkills(employee.getSkills());
        existing.setMaxWeeklyHours(employee.getMaxWeeklyHours());

        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee emp = getEmployee(id);
        employeeRepository.delete(emp);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}
