package edu.icet.project.employeeControl;

import edu.icet.project.dto.Employee;
import edu.icet.project.entity.EmployeeEntity;
import edu.icet.project.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeController {


    final EmployeeService service;
    @PostMapping("add")
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }

    @GetMapping("get")
    public Iterable<EmployeeEntity> getEmployee(){
        return service.getAll();
    }
}
