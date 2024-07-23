package edu.icet.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentId;
    private String roleId;
}
