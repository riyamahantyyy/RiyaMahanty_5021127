package controller;

import model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @PostMapping
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        customer.setId(1L); // Temporary ID for example
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomerForm(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password) {
        // Process form data and register the customer
        return new ResponseEntity<>("Customer registered successfully", HttpStatus.CREATED);
    }
}
