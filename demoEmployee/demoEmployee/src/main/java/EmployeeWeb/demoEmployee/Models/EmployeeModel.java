package EmployeeWeb.demoEmployee.Models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp")
public class EmployeeModel {
    @Id
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    private String email;
    private String phone;
    private String salary;
}
