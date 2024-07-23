package edu.icet.project.repository;

import edu.icet.project.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity,String> {
}
