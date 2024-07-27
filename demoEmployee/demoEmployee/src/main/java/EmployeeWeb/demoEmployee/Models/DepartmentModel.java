package EmployeeWeb.demoEmployee.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "dept")
public class DepartmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long managerId;


    public DepartmentModel() {
    }

    public DepartmentModel(String name, Long managerId) {
        this.name = name;
        this.managerId = managerId;
    }


}
