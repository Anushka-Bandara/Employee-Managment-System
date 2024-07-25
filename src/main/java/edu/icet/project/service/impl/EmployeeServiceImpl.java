package edu.icet.project.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.project.dto.Employee;
import edu.icet.project.entity.EmployeeEntity;
import edu.icet.project.repository.EmployeeRepository;
import edu.icet.project.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository repository;

    @Override
    public void addEmployee(Employee employee) {
        repository.save(new ObjectMapper().convertValue(employee, EmployeeEntity.class));
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        Iterable<EmployeeEntity> all = repository.findAll();
        all.forEach(employeeEntity -> {
            employeeList.add(new ObjectMapper().convertValue(employeeEntity, Employee.class));
        });
        return employeeList;
    }

    @Override
    public void delete(String id) {
        if(repository.existsById(id))repository.deleteById(id);
    }
}
