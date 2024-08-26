package controller;

import model.Customer;
import repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<EntityModel<Customer>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream()
                .map(customer -> EntityModel.of(customer,
                        linkTo(methodOn(CustomerController.class).getCustomerById(customer.getId())).withSelfRel(),
                        linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("customers")))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Customer>> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            EntityModel<Customer> resource = EntityModel.of(customer.get(),
                    linkTo(methodOn(CustomerController.class).getCustomerById(id)).withSelfRel(),
                    linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("customers"));
            return ResponseEntity.ok(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EntityModel<Customer>> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        EntityModel<Customer> resource = EntityModel.of(savedCustomer,
                linkTo(methodOn(CustomerController.class).getCustomerById(savedCustomer.getId())).withSelfRel(),
                linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("customers"));

        return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Customer>> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            Customer updatedCustomer = customer.get();
            updatedCustomer.setName(customerDetails.getName());
            updatedCustomer.setEmail(customerDetails.getEmail());
            updatedCustomer.setAddress(customerDetails.getAddress());
            customerRepository.save(updatedCustomer);

            EntityModel<Customer> resource = EntityModel.of(updatedCustomer,
                    linkTo(methodOn(CustomerController.class).getCustomerById(updatedCustomer.getId())).withSelfRel(),
                    linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("customers"));

            return ResponseEntity.ok(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            customerRepository.delete(customer.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
