package repository;

import model.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findAll();
    // Custom query methods can be added here if needed

	Optional<Customer> findById(Long id);

	Customer save(Customer customer);

	void delete(Customer customer);

	
}
