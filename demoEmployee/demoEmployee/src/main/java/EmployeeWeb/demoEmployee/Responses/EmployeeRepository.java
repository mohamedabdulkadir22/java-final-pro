package EmployeeWeb.demoEmployee.Responses;

import EmployeeWeb.demoEmployee.Models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

    @Query(value = "SELECT * FROM emp WHERE id = :id", nativeQuery = true)
    List<EmployeeModel> search(@Param("id") Long id);
}