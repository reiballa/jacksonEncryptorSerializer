package com.rei.jacksonencrypt.contollers;

import com.fasterxml.jackson.annotation.JsonView;
import com.rei.jacksonencrypt.models.Employee;
import com.rei.jacksonencrypt.models.Employer;
import com.rei.jacksonencrypt.views.Views;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

@RestController
public class MainController {

    Employee employee = new Employee("Rei", "Developer", 25, new Employer("X"));


    @GetMapping("/hashed")
    @JsonView(Views.Hashed.class)
    public Employee getHashedEmployee(){
        return employee;
    }

    @GetMapping("/not-hashed")
    public Employee getEmployee(){
        return employee;
    }

    @PostMapping("/")
    public void postEmployee(@RequestBody Employee postEmployee){
        System.out.println(postEmployee);
    }
}
