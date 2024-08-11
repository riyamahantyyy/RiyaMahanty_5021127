package service;

import Model.Department;
import Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Iterable<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> updateDepartment(Long id, Department department) {
        if (departmentRepository.existsById(id)) {
            department.setId(id);
            return Optional.of(departmentRepository.save(department));
        }
        return Optional.empty();
    }

    public boolean deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
