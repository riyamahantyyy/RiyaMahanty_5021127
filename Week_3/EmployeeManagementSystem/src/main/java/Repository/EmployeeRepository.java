package Repository;

import Model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	// Custom query using @Query annotation
    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> findEmployeesByName(@Param("name") String name);

    @Query("SELECT e FROM Employee e JOIN e.department d WHERE d.name = :departmentName")
    List<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);
    
    
    //Named query
    @Query(name = "Employee.findByEmail")
    Employee findByEmail(String email);
    
}