package EmployeeWeb.demoEmployee.Services;

import EmployeeWeb.demoEmployee.Models.DepartmentModel;

import EmployeeWeb.demoEmployee.Responses.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;


    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public void insertDepartment(DepartmentModel departmentModel) {
        departmentRepository.save(departmentModel);
    }


    public List<DepartmentModel> getAllDepartments(Long keyword){
        if(keyword != null)
            return departmentRepository.search(keyword);
        return departmentRepository.findAll();
    }

    public DepartmentModel getDepartmentById(Long id) {
        Optional<DepartmentModel> optionalDepartment = departmentRepository.findById(id);
        return optionalDepartment.orElse(null);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
