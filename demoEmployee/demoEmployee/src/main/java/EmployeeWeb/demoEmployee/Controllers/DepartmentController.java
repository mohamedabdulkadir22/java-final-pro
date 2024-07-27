package EmployeeWeb.demoEmployee.Controllers;

import EmployeeWeb.demoEmployee.Models.DepartmentModel;

import EmployeeWeb.demoEmployee.Services.DepartmentService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentController {
    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


@GetMapping("/home")
public String getHomePage() {
    return "home"; 
}

    @GetMapping("/createDepartment")
    public String getRegister(Model model) {
        model.addAttribute("dept", new DepartmentModel());
        return "createDepartment";
    }

    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute DepartmentModel department) {
        departmentService.insertDepartment(department);
        return "redirect:/viewAllDepartments";
    }

    @GetMapping("/viewAllDepartments")
    public String getAllDepartments(Model model, @Param("keyword") Long keyword) {
        List<DepartmentModel> list = departmentService.getAllDepartments(keyword);
        model.addAttribute("departments", list);
        model.addAttribute("keyword", keyword);
        return "viewAllDepartments";
    }

    @RequestMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return "redirect:/viewAllDepartments";
    }

    @RequestMapping("/EditDepartment/{id}")
    public String updateDepartment(@PathVariable Long id, Model model) {
        DepartmentModel dept = departmentService.getDepartmentById(id);
        model.addAttribute("dept", dept);
        return "EditDepartment";
    }

}

