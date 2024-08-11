package Model;

import jakarta.persistence.*;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "employees")
@Data
@NamedQueries({
	@NamedQuery(name = "Employee.findByEmail",
            query = "SELECT e FROM Employee e WHERE e.email = :email")
})
@DynamicUpdate // Only updated columns will be included in the SQL UPDATE statement
@SQLDelete(sql = "UPDATE employees SET deleted = true WHERE id = ?") // Soft delete
@Where(clause = "deleted = false") // Filter condition for queries
@BatchSize(size = 50) // Batch size for fetching
public class Employee extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @Column(name = "deleted")
    private boolean deleted = false;
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
    
}