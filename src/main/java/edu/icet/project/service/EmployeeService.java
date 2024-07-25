package edu.icet.project.service;

import edu.icet.project.dto.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    List<Employee> getAll();

    void delete(String id);

    void update(Employee employee);

    Employee findById(String id);

    List<Employee> findByFirstName(String name);
}
