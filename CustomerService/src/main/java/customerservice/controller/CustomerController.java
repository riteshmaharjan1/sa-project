package customerservice.controller;

import customerservice.pojo.Customer;
import customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/getCustomer/{customerNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable("customerNumber") int customerNumber) {
        Customer customer = customerService.getCustomer(customerNumber);
        return new ResponseEntity<>(customer
                , HttpStatus.OK);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        customerService.insertCustomer(customer);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/editCustomer")
    public ResponseEntity<?> editCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/deleteCustomer")
    public ResponseEntity<?> deleteCustomer(@RequestBody Customer customer) {
        customerService.deleteCustomer(customer);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<?> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

}
