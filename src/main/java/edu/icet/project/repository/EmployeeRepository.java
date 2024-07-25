package edu.icet.project.repository;

import edu.icet.project.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity,String> {
    List<EmployeeEntity> findByFirstName(String name);
}
