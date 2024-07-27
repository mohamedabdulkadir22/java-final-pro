package EmployeeWeb.demoEmployee.Services;

import EmployeeWeb.demoEmployee.Models.EmployeeModel;
import EmployeeWeb.demoEmployee.Responses.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void insertEmployee(EmployeeModel employeeModel){
        employeeRepository.save(employeeModel);
    }

    public void updateUniversity(EmployeeModel employeeModel) {
        employeeRepository.save(employeeModel);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    public EmployeeModel getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }


    public List<EmployeeModel> getAllEmployees(Long keyword){
        if(keyword != null)
            return employeeRepository.search(keyword);
        return employeeRepository.findAll();
    }
}
