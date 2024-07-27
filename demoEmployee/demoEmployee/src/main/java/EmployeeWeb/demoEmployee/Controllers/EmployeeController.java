package EmployeeWeb.demoEmployee.Controllers;

import EmployeeWeb.demoEmployee.Services.EmployeeService;
import EmployeeWeb.demoEmployee.Models.EmployeeModel;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

//    @GetMapping("/")
//    public String getHomePage() {
//        return "home";
//    }

    @GetMapping("/")
    public String getHomePage() {
        return "home"; // This corresponds to home.html in src/main/resources/templates/
    }


    @GetMapping("/createEmployee")
    public String getRegister() {
        return "createEmployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute EmployeeModel emp) {
        service.insertEmployee(emp);
        return "redirect:/viewAllEmployees";
    }


    @GetMapping("/viewAllEmployees")
    public String getAll(Model model, @Param("keyword") Long keyword){
        List<EmployeeModel> list = service.getAllEmployees(keyword);
        model.addAttribute("employee" , list);
        model.addAttribute("keyword" , keyword);
        return "viewAllEmployees";
    }


    @RequestMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "redirect:/viewAllEmployees";
    }


    @RequestMapping("/edit/{id}")
            public String UpdateEmployee(@PathVariable Long id, Model model) {
            EmployeeModel emp = service.getEmployeeById(id);
            model.addAttribute("emp", emp);
        return "EditEmployee";
}


}
