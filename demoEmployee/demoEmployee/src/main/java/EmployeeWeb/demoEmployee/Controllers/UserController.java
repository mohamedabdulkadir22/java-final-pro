package EmployeeWeb.demoEmployee.Controllers;

import EmployeeWeb.demoEmployee.Models.User;

import EmployeeWeb.demoEmployee.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password, Model model) {
        User user = userService.findByName(name);
        if (user != null && user.getPassword().equals(password)) {
            // Add all users to the model
            model.addAttribute("users", userService.getAllUsers());
            return "home"; // Redirect to home page
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
}
