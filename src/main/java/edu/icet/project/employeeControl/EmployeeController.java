package edu.icet.project.employeeControl;

import edu.icet.project.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    List<Employee> employeeList = new ArrayList<>();
    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee){
        employeeList.add(employee);
    }

}
