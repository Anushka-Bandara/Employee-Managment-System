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
import java.util.Optional;

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

    @Override
    public void update(Employee employee) {
        if(repository.findById(employee.getId()).isPresent()){
            repository.save(new ObjectMapper().convertValue(employee,EmployeeEntity.class));
        }
    }

    @Override
    public Employee findById(String id) {
        if(repository.findById(id).isPresent()){
            Optional<EmployeeEntity> byId = repository.findById(id);
            return new ObjectMapper().convertValue(byId.get(),Employee.class);
        }
        return new Employee();
    }

    @Override
    public List<Employee> findByFirstName(String name) {
        List<EmployeeEntity> byFirstName = repository.findByFirstName(name);
        List<Employee> list = new ArrayList<>();
        byFirstName.forEach(employeeEntity -> {
            list.add(new ObjectMapper().convertValue(employeeEntity,Employee.class));
        });
        return list;
    }
}
