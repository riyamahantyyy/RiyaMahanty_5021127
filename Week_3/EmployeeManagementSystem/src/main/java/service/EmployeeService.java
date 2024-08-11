package service;

import Model.Employee;
import Model.Department;
import Repository.EmployeeRepository;
import Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // Example methods to use repositories
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }

    // Add other CRUD operations here
}
