package EmployeeWeb.demoEmployee.Responses;

import EmployeeWeb.demoEmployee.Models.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {
    List<DepartmentModel> findByName(String name);

    List<DepartmentModel> findByManagerId(Long managerId);

    List<DepartmentModel> findAllByNameContaining(String keyword);

    @Query(value = "SELECT * FROM dept WHERE id = :id", nativeQuery = true)
    List<DepartmentModel> search(@Param("id") Long id);



}
