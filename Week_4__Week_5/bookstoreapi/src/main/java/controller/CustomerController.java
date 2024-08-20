package controller;

import model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customerList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customerList.add(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestParam String name, @RequestParam String email) {
        Customer customer = new Customer(null, name, email);
        customerList.add(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
