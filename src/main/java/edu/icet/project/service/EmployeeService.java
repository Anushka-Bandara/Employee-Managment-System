package edu.icet.project.service;

import edu.icet.project.dto.Employee;
import edu.icet.project.entity.EmployeeEntity;

public interface EmployeeService {

    void addEmployee(Employee employee);

    Iterable<EmployeeEntity> getAll();
}
