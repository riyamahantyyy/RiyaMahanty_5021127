package Repository;

import Model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import Projection.EmployeeProjection;
import Projection.EmployeeSummary;
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
    
 // Method to find employees by department with pagination
    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    EmployeeProjection findByEmailProjection(@Param("email") String email);

    @Query("SELECT e FROM Employee e")
    List<EmployeeProjection> findAllEmployeeProjections();
    
    @Query("SELECT new com.employee.EmployeeManagementSystem2.projection.EmployeeSummary(e.id, e.name, e.email) FROM Employee e WHERE e.email = :email")
    EmployeeSummary findByEmailSummary(@Param("email") String email);

    @Query("SELECT new com.employee.EmployeeManagementSystem2.projection.EmployeeSummary(e.id, e.name, e.email) FROM Employee e")
    List<EmployeeSummary> findAllEmployeeSummaries();
}