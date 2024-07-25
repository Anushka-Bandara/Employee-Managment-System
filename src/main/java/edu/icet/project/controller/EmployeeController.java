package edu.icet.project.controller;

import edu.icet.project.dto.Employee;
import edu.icet.project.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeController {


    final EmployeeService service;
    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }

    @GetMapping("get")
    public List<Employee> getEmployee(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteEmployee(@PathVariable String id){
        service.delete(id);
    }

    @PostMapping("/update")  // or use PutMapping
    public void update(@RequestBody Employee employee){
        service.update(employee);
    }

    @GetMapping("/find-by-id/{id}")
    public Employee findById(@PathVariable String id){
        return service.findById(id);
    }

    @GetMapping("/find-by-firstName/{name}")
    public List<Employee> findByFirstName(@PathVariable String name){
        return service.findByFirstName(name);
    }
}