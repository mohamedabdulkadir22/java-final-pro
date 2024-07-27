package EmployeeWeb.demoEmployee.Services;

import EmployeeWeb.demoEmployee.Models.User;
import EmployeeWeb.demoEmployee.Responses.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByName(String name) {
        return userRepository.findByUsername(name);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
