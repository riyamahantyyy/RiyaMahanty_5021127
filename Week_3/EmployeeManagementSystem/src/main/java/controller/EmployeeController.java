package controller;

import Model.Employee;
import Model.Department;
import service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{email}")
    public Employee getEmployeeByEmail(@PathVariable String email) {
        return employeeService.getEmployeeByEmail(email);
    }

    @GetMapping("/departments/{name}")
    public Department getDepartmentByName(@PathVariable String name) {
        return employeeService.getDepartmentByName(name);
    }

    // Add other endpoints for CRUD operations here
}
